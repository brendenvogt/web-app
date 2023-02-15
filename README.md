# web-app

## Deploy setup
- install elastic beanstalk cli
- `eb init` 
  - then edit the .elasticbeanstalk/config.yml file to include deploy artifact and point to your jar
  - Do not configure a code commit repo
- `eb codesource`
  - configure as local
- `eb create` - this will take a while
- `eb open`

## Build 
- `mvn clean package spring-boot:repackage`

## Deploy
- `eb deploy`