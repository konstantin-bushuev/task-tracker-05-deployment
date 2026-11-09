# Task Tracker: Deployment

REST API для управления задачами. Приложение построено на Spring Boot и использует PostgreSQL 
в качестве базы данных. 
Приложение и база данных запускаются в Docker-контейнерах с помощью Docker Compose.

## Цель

Подготовить приложение к production-среде.

Стартовое состояние проекта — финальная версия предыдущего этапа.

Предыдущий этап: [task-tracker-04-docker](https://github.com/konstantin-bushuev/task-tracker-04-docker)

## План

* [x] Создать репозиторий на основе финального состояния task-tracker-04-docker
* [x] Настроить Spring Boot Profiles (dev и prod)
* [ ] Переработать Dockerfile с использованием Multi-stage Build.
* [ ] Подготовить Docker Compose для production-среды.
* [ ] Добавить Nginx в качестве Reverse Proxy.
* [ ] Настроить резервное копирование и восстановление PostgreSQL.
* [ ] Проверить работу приложения в production-конфигурации.
* [ ] Обновить документацию проекта.