````markdown
# DriveCore API

API REST para gerenciamento de veículos e concessionárias.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Docker Compose
- Maven

---

# Docker

A aplicação possui dois containers:

- `drivecore-api` - aplicação Spring Boot
- `drivecore-postgres` - banco PostgreSQL

O Docker Compose configura automaticamente a comunicação entre eles.

## Estrutura

```text
drivecore-api/
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── .env
├── pom.xml
└── src/
````

---

# Executando o projeto

## 1. Pré-requisitos

Instale:

* Docker
* Docker Compose

Verifique:

```bash
docker --version
```

```bash
docker compose version
```

---

## 2. Subir a aplicação

Na raiz do projeto:

```bash
docker compose up --build
```

O Docker irá:

1. Criar o container PostgreSQL
2. Criar o banco `drivecore`
3. Criar o volume do PostgreSQL
4. Aguardar o banco ficar disponível
5. Compilar a aplicação Spring Boot
6. Criar o container da API
7. Iniciar a aplicação

---

# Executar em background

Para deixar os containers rodando em segundo plano:

```bash
docker compose up -d --build
```

---

# Verificar os containers

```bash
docker compose ps
```

Deve aparecer algo semelhante a:

```text
NAME                  STATUS
drivecore-postgres    Up
drivecore-api         Up
```

---

# Visualizar logs

Todos os serviços:

```bash
docker compose logs -f
```

Somente a API:

```bash
docker compose logs -f drivecore-api
```

Somente o PostgreSQL:

```bash
docker compose logs -f postgres
```

---

# Parar a aplicação

```bash
docker compose down
```

Isso remove os containers, mas mantém os dados do PostgreSQL.

---

# Remover containers e banco

Para apagar também o volume do PostgreSQL:

```bash
docker compose down -v
```

ATENÇÃO: isso apaga os dados persistidos do banco.

---

# API

Depois que os containers estiverem executando:

```text
http://localhost:8080
```

## Veículos

### Listar

```http
GET http://localhost:8080/vehicles
```

### Buscar por ID

```http
GET http://localhost:8080/vehicles/{id}
```

### Criar

```http
POST http://localhost:8080/vehicles
```

### Atualizar

```http
PUT http://localhost:8080/vehicles/{id}
```

### Excluir

```http
DELETE http://localhost:8080/vehicles/{id}
```

---

## Concessionárias

### Listar

```http
GET http://localhost:8080/dealer
```

### Buscar por ID

```http
GET http://localhost:8080/dealer/{id}
```

### Criar

```http
POST http://localhost:8080/dealer
```

### Atualizar

```http
PUT http://localhost:8080/dealer/{id}
```

### Excluir

```http
DELETE http://localhost:8080/dealer/{id}
```

---
# Swagger / OpenAPI

A API possui documentação interativa através do Swagger UI.

Com a aplicação em execução, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```
---

# PostgreSQL

As configurações padrão são:

```text
Host: localhost
Port: 5432
Database: drivecore
User: postgres
Password: 150366
```

Dentro do container da aplicação, o PostgreSQL é acessado através de:

```text
postgres:5432
```

Não utilize `localhost` para acessar o PostgreSQL a partir da aplicação Spring Boot dentro do Docker.

---

# Volume

Os dados do PostgreSQL são armazenados no volume:

```text
drivecore-postgres-data
```

Isso significa que:

```bash
docker compose down
```

não apaga os dados.

Para apagar:

```bash
docker compose down -v
```

---

# Rebuild da aplicação

Sempre que alterar o código Java:

```bash
docker compose up --build
```

Ou:

```bash
docker compose build --no-cache
docker compose up -d
```

---

# Desenvolvimento

Durante o desenvolvimento, a aplicação pode continuar sendo executada diretamente pelo IntelliJ/IDEA ou Maven.

Nesse caso, o PostgreSQL pode continuar sendo executado pelo Docker:

```bash
docker compose up -d postgres
```

E a aplicação localmente:

```bash
mvn spring-boot:run
```

Nesse cenário o `application.yml` utiliza:

```text
jdbc:postgresql://localhost:5432/drivecore
```

Enquanto dentro do Docker utiliza:

```text
jdbc:postgresql://postgres:5432/drivecore
```

Isso é controlado automaticamente pelas variáveis de ambiente.

---

# Fluxo da aplicação

```text
                 Docker Compose
                       │
          ┌────────────┴────────────┐
          │                         │
          ▼                         ▼
   drivecore-api              drivecore-postgres
     Spring Boot                  PostgreSQL
       :8080                        :5432
          │                         │
          └───────────┬─────────────┘
                      │
                rede Docker
```

A aplicação Spring Boot não acessa o banco através de `localhost`.

Ela utiliza:

```text
postgres:5432
```

porque `postgres` é o nome do serviço definido no Docker Compose.

```
```
