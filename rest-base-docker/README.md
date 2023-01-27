# HELLO APP IN DOCKER
## THE CONTENTS
1. INTRODUCTION
2. API
3. DOCKER
4. USEFUL LINKS ABOUT SPRING BOOT AND DOCKER

## **1. INTRODUCTION**
That is the simple rest "Hello, World!" app that is containerized by Docker.

**The goal of that tutorial**: to create a container of the application and try the rest request of that application.

## **2. API**
The application has only one endpoint: **[POST]/hello**.

The request payload as follows:
```
@RequestParam(name = "name") String name;
```

The response payload also has the following structure:
```
Hello, {name}! //"name" parameter will be interpolated into string response
```

## **3. DOCKER**
### **3.1. CREATE APPLICATION IMAGE**
The text of Dockerfile:
```
FROM adoptopenjdk/openjdk11:ubi
MAINTAINER vikavl
COPY target/docker.web-0.0.1-SNAPSHOT.jar hello-app-1.0.0.jar
ENTRYPOINT ["java","-jar","/hello-app-1.0.0.jar"]
```

Description of the parameters from Dockerfile:
1. ***adoptopenjdk/openjdk11:ubi*** - the version of java that is used by application (in that case is java 11).
2. ***vikavl*** - opportunity to set the name of the maintainer of the application.
3. ***target/docker.web-0.0.1-SNAPSHOT.jar*** - the path to snapshot (<ins>executable jar file</ins>) of the application. To get the snapshot of the application <ins>install</ins> (*./mvnw install*).
4. ***hello-app-1.0.0.jar*** - name of the new-created image executable jar file.
5. ***["java","-jar","/hello-app-1.0.0.jar"]*** - there are CMD arguments that is creating the new-created image executable jar file.

```
// the command to bulid an image
// docker build {name of the new-created image executable jar file}--tag=:latest .
docker build hello-app--tag=:latest .
```

### **3.2 CREATE THE CONTAINER AND RUN IT**

When the image is built we can create its container:
```
// docker run -p{local port}:{container port} {name of image}:latest
docker run -p8081:8080 hello-app:latest
```
There is used *-p* flag to define ports of local machine (the laptop) and container.

### **3.3. SENDING THE REQUEST TO DOCKER CONTAINER**


## **4. USEFUL LINKS ABOUT SPRING BOOT AND DOCKER**
There is a set of related links to the topic:
1. Spring Boot and Docker (from spring.io guides): [https://spring.io/guides/topicals/spring-boot-docker/](https://spring.io/guides/topicals/spring-boot-docker/).
2. Dockerizing a Spring Boot Application: [https://www.baeldung.com/dockerizing-spring-boot-application](https://www.baeldung.com/dockerizing-spring-boot-application).

------

> *Written by Viktoriia Vlasenko 27/01/2023*