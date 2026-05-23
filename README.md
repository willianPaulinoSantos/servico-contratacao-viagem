# Serviço de Contratação de Viagem

API Spring Boot para consulta de pacotes turísticos.

## Requisitos

- Java 17
- Maven (ou `./mvnw`)

## Executar

```bash
./mvnw spring-boot:run
```

Endpoint: `GET http://localhost:8080/pacotes`

## Fluxo de trabalho em grupo

A branch `main` é protegida: **não envie commits diretamente para ela**.

1. Atualize sua base: `git pull origin main`
2. Crie uma branch: `git checkout -b feature/nome-da-tarefa`
3. Desenvolva, commit e push: `git push -u origin feature/nome-da-tarefa`
4. Abra um **Pull Request** no GitHub para `main`
5. Após o merge do PR, os demais atualizam: `git pull origin main`

Detalhes em [CONTRIBUTING.md](CONTRIBUTING.md).
