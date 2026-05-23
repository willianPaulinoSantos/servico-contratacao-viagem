#!/usr/bin/env bash
# Exige Pull Request para alterar main (bloqueia push direto).
# Uso: ./scripts/setup-github-protection.sh
# Requer: gh autenticado; repositório público (ou GitHub Pro se privado).

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

REPO_SLUG="$(echo "$REMOTE_URL" | sed -E 's#.*github\.com[:/]([^/]+/[^/.]+)(\.git)?#\1#')"
OWNER="${REPO_SLUG%%/*}"
REPO="${REPO_SLUG##*/}"

echo "Configurando proteção em ${OWNER}/${REPO} (branch main)..."

VISIBILITY="$(gh repo view "${OWNER}/${REPO}" --json visibility -q .visibility)"
if [[ "$VISIBILITY" == "PRIVATE" ]]; then
  echo "Erro: repositório privado no plano Free não suporta proteção de branch."
  echo "Torne público: gh repo edit ${OWNER}/${REPO} --visibility public --accept-visibility-change-consequences"
  exit 1
fi

gh api --method PUT "repos/${OWNER}/${REPO}/branches/main/protection" --input - <<EOF
{
  "required_status_checks": null,
  "enforce_admins": true,
  "required_pull_request_reviews": {
    "dismiss_stale_reviews": false,
    "require_code_owner_reviews": false,
    "required_approving_review_count": 0
  },
  "restrictions": null,
  "allow_force_pushes": false,
  "allow_deletions": false
}
EOF

echo "Proteção aplicada: alterações em main apenas via Pull Request."
echo "Teste esperado: git push origin main -> rejeitado pelo GitHub."
