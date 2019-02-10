[![Build Status](https://travis-ci.org/KurtiViktor/qa_portfolio-java-test_engine.svg?branch=master)](https://travis-ci.org/KurtiViktor/qa_portfolio-java-test_engine)
[![codecov](https://codecov.io/gh/KurtiViktor/qa_portfolio-java-test_engine/branch/master/graph/badge.svg)](https://codecov.io/gh/KurtiViktor/qa_portfolio-java-test_engine)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
# 1. Краткое описание
Технологическое демо по автоматизации тестирования.
В демо предлагается автоматизация тестирования графического интерфейса, api и базы данных приложения. 
# 2. Ключевой функционал
* Параллельный запуск из коробки c Junit 5
## 2.1 Web:
* Вся мощь библиотеки Selenide
* Подстветка веб-элементов при локальном запуске
* Видео запись выполнения тестов
* Allure-отчет в качестве репортинга
* Планируется добавить поддержку influxdb + grafana для более наглядного репортинга 
## 2.2 API:
* Работа с api через Retrofit
* Загрузка тестовых данных из json
* Мокирование функционала с помощью Wiremock
## 2.3 DB:
* Работа с бд с помощью ORM через JPA\Hibernate 

# 3. Как работать с проектом
1. Скачать целиком код проекта.
2. Установить параметры запуска:
2.1 concurrentExec -- true/false -- запускать ли тесты параллельно.
2.2 tags -- api, web, db, ext -- теги для запуска через запятую, по умолчанию все.   
3. Выполнить для запуска тестов:
    > ./gradlew test -Ptags=your_value -PconcurentExec=your_value
4. Выполнить для генерации аллюр отчета:
    > ./gradlew copyAllureCategories allureReport
5. Выполнить для генерации javadoc проекта:
    > ./gradlew javadoc
# 4. Структура
* test_engine.api - Пакет, предназначенный для работы с api тестируемого приложения.
* test_engine.db - Пакет, предназначенный для работы с базой данных тестируемого приложения.
* test_engine.out - Пакет, предназначенный для работы с внешними активностями движка автотестов.
* test_engine.ext - Пакет, предназначенный для работы с классами расширений и кастомизации, используемых библиотек. Если класс не попадает в пакеты api, out, db, то он попадает сюда.

Для более детального описания смотрите javadoc.

# 5. Технологический стэк
* система автоматической сборки: gradle 5.x
* java 8: guava, lombok, owner, gson
* web: Selenide, video-recorder
* api: Retrofit 2, Wiremock
* db: Hibernate 5, JPA, SQLITE 3
* test: Junit 5, assertj
* report: slf4j, log4j2, allure 2.x