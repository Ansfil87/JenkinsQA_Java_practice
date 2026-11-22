# JenkinsQA_Java_practice

Учебная копия проекта JenkinsQA_Java_2026_fall: инфраструктура (BaseTest, утилиты, CI) сохранена,
UI-тесты и Page Object'ы удалены — пишутся заново.

## Что осталось от оригинала

- `common/BaseTest` — запуск браузера, очистка Jenkins перед тестом, логин/логаут, скриншоты в CI
- `common/ProjectUtils`, `common/JenkinsUtils` — настройки из `.properties` / переменных окружения, очистка данных через API
- `common/filter`, `common/order` — в PR запускаются только затронутые тесты; порядок для `dependsOnMethods`
- `pages/BaseModel` — базовый класс для страниц (driver + ожидания)
- `.github/workflows/ci.yml` — CI в GitHub Actions

## Локальный запуск

1. Скопировать `src/test/resources/.properties.TEMPLATE` в `src/test/resources/.properties` и заполнить
   (файл в `.gitignore`, в репозиторий не попадает).
2. Запустить локальный Jenkins (тот же, что для основного проекта).
3. `mvn test` или запуск теста из IntelliJ IDEA.

## Работа с заданиями

Каждое задание — отдельная ветка и Pull Request в `main`:

```
git checkout main
git pull
git checkout -b task-01-home-page
# ... пишем код ...
git add .
git commit -m "Add HomePage and create folder test"
git push -u origin task-01-home-page
```

Дальше на GitHub открыть Pull Request — CI прогонит изменённые тесты. Зелёный — мержим.

Ручной прогон всех тестов: вкладка **Actions → CI → Run workflow**.

## Секреты репозитория (Settings → Secrets and variables → Actions)

| Секрет | Обязателен | Значение |
|---|---|---|
| `ADMIN_USERNAME` | да | логин Jenkins из бэкапа (как в `.properties`) |
| `ADMIN_PASSWORD` | да | пароль Jenkins из бэкапа |
| `DOCKER_USERNAME` | нет | логин Docker Hub (если без него упрётся в лимиты скачивания образа) |
| `DOCKER_PASSWORD` | нет | токен Docker Hub |
