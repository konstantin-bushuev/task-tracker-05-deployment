# Task Tracker: Deployment

REST API для управления задачами на Spring Boot с использованием PostgreSQL.

## Цель

Подготовка приложения к production-среде с помощью Docker Compose, Nginx и механизмов резервного копирования.

Стартовое состояние проекта — финальная версия предыдущего этапа.

Предыдущий этап: [task-tracker-04-docker](https://github.com/konstantin-bushuev/task-tracker-04-docker)

## Архитектура

В production-среде приложение состоит из трёх сервисов:

```text
             Client
                |
             HTTP :80
                |
                v
              Nginx
          Reverse Proxy
                |
             HTTP :8080
                |
                v
          Spring Boot
                |
          PostgreSQL :5432
                |
                v
             Database
```

- **Nginx** — единственная точка внешнего доступа, перенаправляет запросы к Spring Boot.
- **Spring Boot** — REST API, работает внутри Docker-сети.
- **PostgreSQL** — хранение данных, доступна только внутри Docker-сети.

В production-конфигурации наружу опубликован только порт Nginx (`80`). Порты приложения и базы данных не доступны напрямую с хоста.

## Технологии

- Java 21
- Spring Boot 4.1.1
- Gradle
- Spring Data JPA
- PostgreSQL 16
- Docker и Docker Compose
- Nginx

## План

* [x] Создать репозиторий на основе финального состояния task-tracker-04-docker
* [x] Настроить Spring Boot Profiles (dev и prod)
* [x] Переработать Dockerfile с использованием Multi-stage Build
* [x] Подготовить Docker Compose для production-среды
* [x] Добавить Nginx в качестве Reverse Proxy
* [x] Настроить резервное копирование и восстановление PostgreSQL
* [x] Проверить работу приложения в production-конфигурации
* [x] Обновить документацию проекта

## Запуск

Создать `.env` на основе шаблона:

```bash
cp .env.example .env
```

Указать необходимые переменные окружения, включая пароль PostgreSQL.

Запустить production-конфигурацию:

```bash
docker compose \
  -f compose.yaml \
  -f compose.prod.yaml \
  up -d --build
```

Проверить состояние сервисов:

```bash
docker compose \
  -f compose.yaml \
  -f compose.prod.yaml \
  ps
```

API доступно по адресу:

```text
http://localhost/api/tasks
```

Проверка состояния приложения:

```text
http://localhost/actuator/health
```

Остановка сервисов без удаления данных PostgreSQL:

```bash
docker compose \
  -f compose.yaml \
  -f compose.prod.yaml \
  down
```

## Результат этапа

Приложение подготовлено к production-среде и успешно протестировано локально.

Реализована архитектура с Nginx Reverse Proxy, Spring Boot и PostgreSQL. Настроены профили окружения, сборка Docker-образа, управление контейнерами и резервное копирование базы данных.

Следующий этап: [task-tracker-06-cicd](https://github.com/konstantin-bushuev/task-tracker-06-cicd) - 
CI/CD с использованием GitHub Actions и развёртывание приложения на VPS
