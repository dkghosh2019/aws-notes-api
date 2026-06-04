# AWS Notes API

Cloud-native Spring Boot REST API built with Java 21, PostgreSQL, Docker, Docker Compose, and Swagger/OpenAPI.

---

## Overview

AWS Notes API is an enterprise-style backend application developed for learning and demonstrating:

* Spring Boot REST API development
* PostgreSQL integration
* Docker containerization
* Docker Compose orchestration
* Swagger/OpenAPI documentation
* Cloud-ready backend architecture
* AWS deployment preparation

This project follows layered architecture and modern backend engineering practices.

---

# Tech Stack

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* PostgreSQL
* Docker
* Docker Compose
* Swagger / OpenAPI
* Maven
* Lombok

---

# Architecture

```text
Client
   ↓
Spring Boot REST API
   ↓
PostgreSQL Database
```

---

# Docker Compose Architecture

```text
Docker Compose
 ├── Spring Boot Container
 └── PostgreSQL Container
```

---

# Features

* CRUD Notes REST API
* DTO-based request/response design
* Bean validation
* Global exception handling
* Swagger/OpenAPI documentation
* Dockerized Spring Boot application
* Dockerized PostgreSQL database
* Multi-container orchestration using Docker Compose
* Externalized configuration using environment variables

---

# Project Structure

```text
src/main/java/com/dipak/awsnotesapi

├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── config
└── util
```

---

# API Endpoints

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/notes`      | Create note    |
| GET    | `/api/notes`      | Get all notes  |
| GET    | `/api/notes/{id}` | Get note by ID |
| PUT    | `/api/notes/{id}` | Update note    |
| DELETE | `/api/notes/{id}` | Delete note    |

---

# Swagger UI

After running the application:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8080/v3/api-docs
```

---

# Running Locally

## Prerequisites

* Java 21
* Maven
* Docker Desktop

---

## Clone Repository

```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/aws-notes-api.git
cd aws-notes-api
```

---

## Run Using Maven

```bash
./mvnw spring-boot:run
```

---

# Running with Docker Compose

## Build and Start Containers

```bash
docker compose up --build
```

---

## Stop Containers

```bash
docker compose down
```

---

# Docker Commands

## View Running Containers

```bash
docker ps
```

---

## View Logs

```bash
docker logs aws-notes-api-container
```

---

# Sample Request

## Create Note

```http
POST /api/notes
```

Request Body:

```json
{
  "title": "AWS Interview Preparation",
  "content": "Learning Spring Boot, Docker, PostgreSQL, and AWS."
}
```

---

# Key Concepts Demonstrated

* Layered architecture
* DTO pattern
* Spring Data JPA
* Hibernate ORM
* RESTful API design
* Global exception handling
* Docker containerization
* Multi-container orchestration
* Environment variable configuration
* Cloud-ready backend development

---

# Future Enhancements

* AWS EC2 deployment
* AWS RDS integration
* AWS S3 file upload
* JWT Authentication
* CI/CD Pipeline
* Kubernetes deployment
* Monitoring and logging

---

# Author

Dipak Ghosh

GitHub: https://github.com/YOUR_GITHUB_USERNAME
