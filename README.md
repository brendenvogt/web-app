# web-app

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

## TODO 
- DB connection
- AWS Spring Cloud https://awspring.io/