FROM adoptopenjdk/openjdk11:ubi
MAINTAINER vikavl
COPY target/docker.web-0.0.1-SNAPSHOT.jar hello-app-1.0.0.jar
ENTRYPOINT ["java","-jar","/hello-app-1.0.0.jar"]