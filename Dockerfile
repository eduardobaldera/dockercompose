FROM openjdk:11-jdk-slim

LABEL maintainer="Eduardo Baldera <20170982@ce.pucmm.edu.do>"

ENV NOMBRE_APP = 'barcamp'

ENV spring.datasource.url='jdbc:mysql://barcamp-db:3306/barcamp?autoReconnect=true&useSSL=false'
ENV spring.datasource.username='root'
ENV spring.datasource.password='123456'

VOLUME /tmp

EXPOSE 80

COPY /build/libs/dockercompose-0.0.1-SNAPSHOT.jar ./docker-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "docker-0.0.1-SNAPSHOT.jar"]