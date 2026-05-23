# Serviço de Contratação de Viagem

API Spring Boot para consulta de pacotes turísticos. Os dados retornados por `/pacotes` são gerados dinamicamente (mock) via [JavaFaker](https://github.com/DiUS/java-faker).

**Produção:** https://servico-contratacao-viagem.onrender.com  
**API:** `GET https://servico-contratacao-viagem.onrender.com/pacotes`

**Repositório:** https://github.com/willianPaulinoSantos/servico-contratacao-viagem

## Requisitos

- Java 17
- Maven (ou `./mvnw`)
- [Docker](https://www.docker.com/) (opcional, para container local ou deploy)

## Executar localmente (sem Docker)

```bash
./mvnw spring-boot:run
```

**Endpoint:** `GET http://localhost:8080/pacotes`

A aplicação escuta na porta definida pela variável `PORT` (padrão `8080`):

```properties
server.port=${PORT:8080}
```

## Docker

### Dockerfile

O build usa imagem multi-stage (Maven 17 + JRE Alpine):

| Item | Valor |
|------|--------|
| **Dockerfile path** | `Dockerfile` (raiz do projeto) |
| **Porta exposta** | `8080` |
| **Artefato** | `demo-0.0.1-SNAPSHOT.jar` |

### Build da imagem

```bash
docker build -t servico-contratacao-viagem:latest .
```

### Executar o container

```bash
docker run --rm -p 8080:8080 servico-contratacao-viagem:latest
```

### Docker Compose

```bash
docker compose up --build
```

A API fica disponível em `http://localhost:8080/pacotes`.

Para parar: `docker compose down`.

## Deploy em produção (Render)

O deploy em produção usa **Docker** no [Render](https://render.com), com deploy automático a cada merge na branch `main` do GitHub.

### URL de produção

```text
https://servico-contratacao-viagem.onrender.com
```

Teste:

```bash
curl https://servico-contratacao-viagem.onrender.com/pacotes
```

### Deploy contínuo

Com **Auto-Deploy** ativo:

```text
feature branch → Pull Request → merge em main → Render faz novo build e deploy
```

A branch `main` no GitHub está protegida: alterações só entram via PR (veja [CONTRIBUTING.md](CONTRIBUTING.md)).

### Plano gratuito Render

No plano free, o serviço pode **hibernar** após inatividade. A primeira requisição após idle pode demorar alguns segundos (cold start).

## Estrutura do projeto

```text
src/main/java/br/com/pecepoli/demo/
├── controller/     # REST (GET /pacotes)
├── service/        # regras de aplicação
├── repository/     # DummyPacoteRepository (dados mock)
└── domain/         # entidades do domínio
```

## Fluxo de trabalho em grupo

A branch `main` é protegida: **não envie commits diretamente para ela**.

1. `git pull origin main`
2. `git checkout -b feature/nome-da-tarefa`
3. Desenvolva, commit e push: `git push -u origin feature/nome-da-tarefa`
4. Abra um **Pull Request** para `main`
5. Após o merge, atualize localmente: `git pull origin main`

Detalhes em [CONTRIBUTING.md](CONTRIBUTING.md).

## Testes

```bash
./mvnw test
```
