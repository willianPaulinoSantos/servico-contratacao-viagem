# Guia de contribuição (grupo de 4)

## Regra principal

| Permitido | Bloqueado |
|-----------|-----------|
| Push em `feature/*` | Push direto em `main` |
| Merge em `main` via Pull Request | Commit direto em `main` |

## Passo a passo

### 1. Primeira vez (clone)

```bash
git clone <url-do-repositorio>
cd demo
```

### 2. Antes de cada tarefa

```bash
git checkout main
git pull origin main
git checkout -b feature/minha-tarefa
```

Use nomes claros: `feature/listar-pacotes`, `feature/contratar-viagem`.

### 3. Durante o desenvolvimento

```bash
git add .
git commit -m "descrição objetiva do que foi feito"
git push -u origin feature/minha-tarefa
```

### 4. Abrir o Pull Request

1. Acesse o repositório no GitHub
2. Clique em **Compare & pull request**
3. Base: `main` ← Compare: `feature/minha-tarefa`
4. Descreva o que mudou e peça revisão de um colega (opcional, mas recomendado)
5. **Merge pull request** quando estiver aprovado

### 5. Depois do merge

```bash
git checkout main
git pull origin main
git branch -d feature/minha-tarefa
```

## Boas práticas para o grupo

- **Commits pequenos e frequentes** na feature branch
- **Um PR por tarefa** — evita PRs gigantes
- **Comunicação**: avise no grupo quando abrir PR ou fizer merge
- Em conflito: resolva na feature branch (`git pull origin main` estando na feature) antes do merge

## Proteção da branch `main`

A configuração no GitHub exige Pull Request para alterar `main`. Se alguém tentar `git push origin main`, o GitHub rejeita.

Para aplicar/reaplicar a proteção (após criar o repo remoto):

```bash
./scripts/setup-github-protection.sh
```
