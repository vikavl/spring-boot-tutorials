FROM adoptopenjdk/openjdk11:ubi
MAINTAINER vikavl
VOLUME /h2DB
ADD target/h2-docker-0.0.1-SNAPSHOT.jar h2-docker-1.0.0.jar
ENTRYPOINT ["java","-jar","/h2-docker-1.0.0.jar"]
