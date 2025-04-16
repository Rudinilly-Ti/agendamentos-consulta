# 🩺 API de Agendamentos de Consulta - Voll.med

Este repositório contém uma API desenvolvida em **Spring Boot** que permite o **cadastro de médicos e pacientes**, além do **agendamento e cancelamento de consultas médicas**. A aplicação segue boas práticas com autenticação via JWT, versionamento de banco com Flyway e persistência com PostgreSQL.

---

## 🔧 Tecnologias e Dependências

- ✅ Java 17
- ✅ Spring Boot 3.4.1
- ✅ Spring Web
- ✅ Spring Security
- ✅ Spring Data JPA
- ✅ Bean Validation
- ✅ PostgreSQL
- ✅ Flyway (migrations)
- ✅ JWT (Autenticação)
- ✅ Lombok

---

## 💡 Funcionalidades da API

- ✅ Cadastro de médicos
- ✅ Cadastro de pacientes
- ✅ Agendamento de consultas
- ✅ Cancelamento de consultas
- ✅ Autenticação com JWT
- ✅ Validações de regra de negócio (médico disponível, horário válido, etc.)
- ✅ Versionamento de banco de dados com Flyway

---
## 🔐 Autenticação
A autenticação da API é baseada em JWT. Para acessar os endpoints protegidos, é necessário realizar login e usar o token no header:
Authorization: Bearer <seu-token>

##🛠️ Como rodar localmente
- Pré-requisitos
- Java 17
- PostgreSQL rodando localmente
- Maven

Passos
Clone o repositório:
```bash
git clone https://github.com/Rudinilly-Ti/agendamentos-consulta.git
cd agendamentos-consulta
```

Configure o application.properties com seu banco local:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/volmed
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```
