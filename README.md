# web-app

## Deploy setup
- install elastic beanstalk cli
- `eb init` then edit the .elasticbeanstalk/config.yml file to include deploy artifact and point to your jar
- `eb create`
- `eb codesource` - configure as local

## Build 
- `mvn clean package spring-boot:repackage`

## Deploy
- `eb deploy`