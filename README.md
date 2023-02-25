# web-app

## Development Setup

- define application-dev.properties file and activate the profile by enabling VM options in the run config and adding `-Dspring.profiles.active=dev`
  - https://stackoverflow.com/questions/39738901/how-do-i-activate-a-spring-boot-profile-when-running-from-intellij


## Deploy setup

- install elastic beanstalk cli
- `eb init`
  - then edit the .elasticbeanstalk/config.yml file to include deploy artifact and point to your jar
  - Do not configure a code commit repo
- `eb codesource`
  - configure as local
- `eb create` - this will take a while
  - you can also use `eb create <ENV NAME>` to create a new environment such as prod.
- `eb open`

## Build

- `mvn clean package spring-boot:repackage`

## Deploy

- `eb deploy`


## Guides
- Email https://www.baeldung.com/spring-email
- H2 in memory database for testing https://www.baeldung.com/spring-boot-h2-database
- uses OpenAPI Swagger https://www.baeldung.com/spring-rest-openapi-documentation

## TODO 
- DB connection
  - DynamoDB
  - Postgresql
- AWS Spring Cloud https://awspring.io/
- ElastiCache
- Lambda
  - Scheduled Lambda
  - Recurring (Cron) Lambda