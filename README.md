# spring-boot-gcp-firestore

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-gcp-firestore/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-gcp-firestore/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-6DB33F?logo=springboot)

A reactive REST API built with Spring WebFlux and Spring Cloud GCP that stores data in **Google Cloud Firestore**.

## Tech Stack

- Java 25
- Spring Boot 4.1 (WebFlux)
- Spring Cloud GCP 8.2 (`spring-cloud-gcp-starter-data-firestore`, reactive Firestore repositories)
- Lombok
- Maven (wrapper included)

## Prerequisites

- JDK 25
- A Google Cloud project with Firestore (Native mode) enabled
- A service account key with Firestore access, **or** the Firestore emulator for local development

## Configuration

`src/main/resources/application.properties`:

```properties
spring.application.name=spring-boot-gcp-firestore
spring.cloud.gcp.firestore.project-id=<your-gcp-project-id>
spring.cloud.gcp.credentials.location=file:/path/to/service-account.json
```

> **Do not commit service account keys.** Keep them outside the repository (or git-ignored) and reference them with `file:`, or use
> [Application Default Credentials](https://cloud.google.com/docs/authentication/application-default-credentials) (`gcloud auth application-default login`)
> and leave `spring.cloud.gcp.credentials.location` unset.

### Using the Firestore emulator

```shell
gcloud emulators firestore start --host-port=localhost:8080
```

```properties
spring.cloud.gcp.firestore.emulator.enabled=true
spring.cloud.gcp.firestore.host-port=localhost:8080
```

## Build & Run

```shell
./mvnw clean package     # build and run tests
./mvnw spring-boot:run   # start the app on http://localhost:8080
```

Tests use `src/test/resources/application.properties`, which enables emulator mode so the build does not need real GCP credentials.

## API

Base path: `/api/v1/users`

| Method   | Path                      | Description                 |
|----------|---------------------------|-----------------------------|
| `POST`   | `/api/v1/users`           | Create a user (201 Created) |
| `GET`    | `/api/v1/users`           | List all users              |
| `GET`    | `/api/v1/users/{id}`      | Get a user by id            |
| `GET`    | `/api/v1/users/country/{name}` | List users by country  |
| `PUT`    | `/api/v1/users/{id}`      | Update a user               |
| `DELETE` | `/api/v1/users/{id}`      | Delete a user               |

Example:

```shell
curl -X POST http://localhost:8080/api/v1/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Hendi Santika","email":"hendi@example.com","country":"Indonesia"}'

curl http://localhost:8080/api/v1/users/country/Indonesia
```

## CI & Dependency Updates

- **GitHub Actions** (`.github/workflows/maven.yml`) builds and tests the project on JDK 25 (Temurin) for every push and pull request to `main`.
- **Dependabot** (`.github/dependabot.yml`) checks Maven dependencies and GitHub Actions daily at 05:00 (Asia/Jakarta). Spring, Google Cloud and Maven plugin
  updates are grouped into combined PRs, labeled, and use conventional commit prefixes (`build(deps)`, `ci(deps)`).
