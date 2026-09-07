# 🚗 Desafio Técnico – Gestão de Veículos e Concessionárias

**Cargo:** Desenvolvedor Fullstack

---

## 📋 Contexto

Desenvolver uma aplicação web para **gestão de veículos e concessionárias**, permitindo o cadastro, consulta, alteração e exclusão dos registros.

O sistema deverá possuir **frontend e backend separados**, consumindo **APIs REST**.

---

## 🎯 Cenário

A área comercial de uma montadora deseja uma aplicação simples para centralizar informações de **veículos disponíveis** e **concessionárias parceiras**.

O sistema deve permitir:

* Cadastro de veículos;
* Cadastro de concessionárias;
* Associação de veículos a concessionárias;
* Consulta e manutenção dos dados cadastrados.

---

# 📌 Requisitos Funcionais

## 1. 🚘 Cadastro de Veículos

Implementar as seguintes operações:

* Criar veículo;
* Consultar veículo;
* Atualizar veículo;
* Excluir veículo.

### Campos obrigatórios

| Campo               | Tipo  |
| ------------------- | ----- |
| Marca               | Texto |
| Modelo              | Texto |
| Tipo de Combustível | Lista |
| Cor                 | Texto |

### Campos opcionais

| Campo       |
| ----------- |
| Ano         |
| Chassi      |
| Valor       |
| Cor Externa |

---

## 2. 🏢 Cadastro de Concessionárias

Implementar as seguintes operações:

* Criar concessionária;
* Consultar concessionária;
* Atualizar concessionária;
* Excluir concessionária.

### Campos obrigatórios

| Campo        | Tipo  |
| ------------ | ----- |
| Razão Social | Texto |
| CNPJ         | Texto |
| Endereço     | Texto |

---

## 2.1 🌐 Integração ViaCEP — Opcional / Diferencial

Ao informar um **CEP** no cadastro da concessionária:

1. Consultar automaticamente a API ViaCEP;
2. Popular os campos de endereço com os dados retornados pela API.

**API:**
https://viacep.com.br/

### Exemplo

**Entrada:**

```text
58400-000
```

**Retorno esperado:**

* Logradouro;
* Bairro;
* Cidade;
* Estado.

---

## 3. 🔗 Associação de Veículos

Permitir vincular **um ou mais veículos** a uma concessionária.

O sistema deve permitir:

* Associar um veículo a uma concessionária;
* Alterar a concessionária de um veículo;
* Listar veículos por concessionária.

### Regra de relacionamento

A aplicação deverá permitir consultar, a partir de uma concessionária, todos os veículos associados a ela.

---

# 🛠️ Requisitos Técnicos

## Backend

### Tecnologias obrigatórias

* **Java 21**
* **Spring Boot**
* **Hibernate / JPA**
* **Maven**

### API REST

Criar endpoints para gerenciamento de veículos e concessionárias.

#### 🚘 Veículos

| Método   | Endpoint         | Descrição         |
| -------- | ---------------- | ----------------- |
| `GET`    | `/vehicles`      | Listar veículos   |
| `GET`    | `/vehicles/{id}` | Consultar veículo |
| `POST`   | `/vehicles`      | Criar veículo     |
| `PUT`    | `/vehicles/{id}` | Atualizar veículo |
| `DELETE` | `/vehicles/{id}` | Excluir veículo   |

#### 🏢 Concessionárias

| Método   | Endpoint       | Descrição                |
| -------- | -------------- | ------------------------ |
| `GET`    | `/dealer`      | Listar concessionárias   |
| `GET`    | `/dealer/{id}` | Consultar concessionária |
| `POST`   | `/dealer`      | Criar concessionária     |
| `PUT`    | `/dealer/{id}` | Atualizar concessionária |
| `DELETE` | `/dealer/{id}` | Excluir concessionária   |

---

# 💻 Frontend

## Tecnologias obrigatórias

* **React**
* **TypeScript**
* **Vite** ou **Next.js**

## Bibliotecas

* **TanStack Query (React Query)**
* **React Hook Form**
* **Zod** ou **Yup**
* **React Router**
* **shadcn/ui** — opcional

---

# ✅ Validações

Implementar validações de negócio para:

* Campos obrigatórios;
* CNPJ válido;
* CEP válido;
* Enum para tipo de combustível.

### Tipos de combustível

```text
GASOLINA
ETANOL
FLEX
DIESEL
ELETRICO
HIBRIDO
```

No backend, recomenda-se utilizar um `enum` para representar os tipos de combustível.

---

# 🗄️ Banco de Dados

Pode ser utilizado qualquer banco de dados relacional:

* PostgreSQL;
* MySQL;
* SQL Server;
* Oracle XE;
* H2.

---

# ⚙️ Funcionalidades

## Veículos

* Listagem;
* Cadastro;
* Edição;
* Exclusão;
* Associação com concessionária.

## Concessionárias

* Listagem;
* Cadastro;
* Edição;
* Exclusão;
* Visualização dos veículos associados.

---

# 🎨 UX / Experiência do Usuário

A aplicação deverá possuir:

* Feedback visual para operações de loading;
* Tratamento de erros;
* Validações client-side;
* Navegação entre telas;
* Interface intuitiva.

### Responsividade

A implementação de uma interface responsiva é **opcional**, porém será considerada positivamente na avaliação.

---

# ⭐ Diferenciais

Os seguintes itens serão considerados diferenciais durante a avaliação.

## 🐳 Docker

Containerização dos componentes da aplicação:

* Banco de dados;
* Backend;
* Frontend;
* Docker Compose.

Exemplo de estrutura:

```text
docker-compose.yml
```

---

## 🧪 Testes

Implementação de:

* Testes unitários;
* Testes das principais regras de negócio.

---

## ☁️ AWS

Deploy ou utilização de serviços AWS, por exemplo:

* **DynamoDB** para armazenamento de logs;
* **Amazon S3**;
* **Amazon RDS**;
* **Amazon ECS**;
* **Amazon EC2**.

---

## 📊 Observabilidade

Implementação de:

* Logs estruturados;
* Logs de erros;
* Informações relevantes para troubleshooting.

---

## 📖 Documentação da API

Disponibilizar documentação da API utilizando:

* **Swagger**
* **OpenAPI**

A documentação deverá permitir visualizar e, preferencialmente, testar os endpoints disponíveis.

---

# 📦 Entrega

Disponibilizar um **repositório público no GitHub** contendo:

* Código-fonte;
* README com instruções de execução;
* Desenho da arquitetura da solução;
* Scripts de banco de dados, quando necessário;
* Instruções para configuração do ambiente;
* Documentação da API, quando implementada.

### README

O README deverá conter, preferencialmente:

```text
1. Descrição do projeto
2. Tecnologias utilizadas
3. Arquitetura da solução
4. Pré-requisitos
5. Configuração do ambiente
6. Como executar o backend
7. Como executar o frontend
8. Configuração do banco de dados
9. Como executar com Docker
10. Como executar os testes
11. Documentação da API
```

---

# 🧱 Boas Práticas Esperadas

O projeto deverá demonstrar conhecimento e aplicação de boas práticas de desenvolvimento.

### Princípios

* **SOLID**
* **Clean Code**
* Separação adequada de responsabilidades;
* Baixo acoplamento;
* Alta coesão.

### Backend

Espera-se a utilização adequada de:

* DTOs;
* Camada de Service;
* Repositories;
* Mapeamento JPA;
* Validações;
* Tratamento global de exceções;
* Logs básicos da aplicação.

### Arquitetura

A arquitetura deve apresentar uma separação clara entre as responsabilidades da aplicação.

Um exemplo de organização:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

A estrutura final fica a critério do candidato, desde que as decisões arquiteturais sejam justificadas.

---

# ⏱️ Prazo

O desafio deverá ser finalizado em até:

**5 dias úteis**

---

# 🎤 Apresentação Técnica

Após a entrega será realizada uma apresentação técnica com duração máxima de:

**15 minutos**

Durante a apresentação será esperado:

1. Explicação da arquitetura da solução;
2. Demonstração da aplicação funcionando;
3. Navegação pelo código-fonte;
4. Explicação das principais decisões técnicas;
5. Perguntas e respostas técnicas.

---

# 🤖 Uso de Inteligência Artificial

É permitido o uso de ferramentas de **Inteligência Artificial** durante o desenvolvimento do desafio.

Entretanto, espera-se que o candidato tenha **conhecimento sobre todo o código desenvolvido** e seja capaz de:

* Explicar as decisões técnicas;
* Justificar a arquitetura utilizada;
* Explicar as principais implementações;
* Responder dúvidas sobre o código;
* Realizar alterações durante a apresentação, caso solicitado.

> O uso de IA não substitui o conhecimento técnico sobre a solução entregue.

---

# 📋 Checklist de Entrega

### Backend

* [ ] Java 21
* [ ] Spring Boot
* [ ] Maven
* [ ] JPA / Hibernate
* [ ] API REST
* [ ] CRUD de veículos
* [ ] CRUD de concessionárias
* [ ] Associação veículo ↔ concessionária
* [ ] DTOs
* [ ] Service Layer
* [ ] Validações
* [ ] Tratamento de exceções
* [ ] Logs
* [ ] Swagger / OpenAPI

### Frontend

* [ ] React
* [ ] TypeScript
* [ ] Vite ou Next.js
* [ ] TanStack Query
* [ ] React Hook Form
* [ ] Zod ou Yup
* [ ] React Router
* [ ] Listagem de veículos
* [ ] Cadastro de veículos
* [ ] Edição de veículos
* [ ] Exclusão de veículos
* [ ] Listagem de concessionárias
* [ ] Cadastro de concessionárias
* [ ] Edição de concessionárias
* [ ] Exclusão de concessionárias
* [ ] Associação de veículos
* [ ] Loading states
* [ ] Tratamento de erros
* [ ] Validação client-side

### Diferenciais

* [ ] Docker
* [ ] Docker Compose
* [ ] Testes unitários
* [ ] Integração ViaCEP
* [ ] AWS
* [ ] Observabilidade
* [ ] Logs estruturados
* [ ] Deploy

### Entrega

* [ ] Repositório público no GitHub
* [ ] README
* [ ] Instruções de execução
* [ ] Desenho da arquitetura
* [ ] Scripts de banco
* [ ] Documentação da API

---

# 🎯 Objetivo da Avaliação

O principal objetivo do desafio é avaliar a capacidade do candidato de desenvolver uma solução **fullstack completa**, considerando não apenas a implementação das funcionalidades, mas também:

* Qualidade do código;
* Organização do projeto;
* Arquitetura;
* Boas práticas;
* Modelagem de dados;
* Conhecimento de APIs REST;
* Validação de dados;
* Tratamento de erros;
* Experiência do usuário;
* Capacidade de tomada de decisões técnicas;
* Capacidade de explicar e defender a solução desenvolvida.
