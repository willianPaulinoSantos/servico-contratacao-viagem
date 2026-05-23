#!/usr/bin/env bash
# Configura regras no GitHub para bloquear push direto em main e exigir PR.
# Uso: ./scripts/setup-github-protection.sh
# Requer: gh autenticado (gh auth login)

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$REPO_ROOT"

if ! command -v gh >/dev/null 2>&1; then
  echo "Erro: GitHub CLI (gh) não encontrado. Instale: https://cli.github.com/"
  exit 1
fi

if ! gh auth status >/dev/null 2>&1; then
  echo "Erro: faça login com: gh auth login"
  exit 1
fi

REMOTE_URL="$(git remote get-url origin 2>/dev/null || true)"
if [[ -z "$REMOTE_URL" ]]; then
  echo "Erro: remote 'origin' não configurado."
  exit 1
fi

# Extrai owner/repo de git@github.com:owner/repo.git ou https://github.com/owner/repo.git
REPO_SLUG="$(echo "$REMOTE_URL" | sed -E 's#.*github\.com[:/]([^/]+/[^/.]+)(\.git)?#\1#')"
OWNER="${REPO_SLUG%%/*}"
REPO="${REPO_SLUG##*/}"

echo "Configurando proteção em ${OWNER}/${REPO} (branch main)..."

# Ruleset: exige PR para merge e bloqueia atualizações diretas (push) em main
gh api "repos/${OWNER}/${REPO}/rulesets" --method POST --input - <<EOF
{
  "name": "Proteger main - apenas via PR",
  "target": "branch",
  "enforcement": "active",
  "conditions": {
    "ref_name": {
      "include": ["refs/heads/main"],
      "exclude": []
    }
  },
  "rules": [
    {
      "type": "pull_request",
      "parameters": {
        "required_approving_review_count": 0,
        "dismiss_stale_reviews_on_push": false,
        "require_code_owner_review": false,
        "require_last_push_approval": false,
        "required_review_thread_resolution": false
      }
    },
    {
      "type": "update",
      "parameters": {
        "update_allows_merge_commits": true,
        "update_allows_rebase_merges": true,
        "update_allows_squash_merges": true
      }
    },
    {
      "type": "deletion",
      "parameters": {}
    },
    {
      "type": "non_fast_forward",
      "parameters": {}
    }
  ]
}
EOF

echo "Concluído. Teste: git push origin main deve ser rejeitado."
echo "Fluxo correto: feature branch -> PR -> merge em main."
