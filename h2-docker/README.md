# **HELLO APP IN DOCKER**
## **THE CONTENTS**
1. INTRODUCTION
2. API
3. DOCKER
4. USEFUL LINKS ABOUT SPRING BOOT AND DOCKER

## **1. INTRODUCTION**
That is a rest app that storing messages in H2 database that is containerized by Docker.

**The goal of that tutorial**: to create a container of the application, run the H2 database inside of the container and try the rest request of that application.

## **2. API**
The application has two endpoints.

**1. [POST]/send**

The request payload is an object of **MessageRequest** and has the following structure:
```
String message;
String type;
```

The response payload is a string of information about the message as follows:
```
//where text in the {} is parameters of the sent message
MessageRequest(message={text of message}, type={type of message}) 
```

**2. [GET]/search**

The request payload is as follows:
```
@RequestParam(name = "type") String type;
```
The *type* - the type of messages that are stored in h2 database.

The response payload is a string of inputted type.

## **3. DOCKER**
### **3.1. CREATE APPLICATION IMAGE**
The text of Dockerfile:
```
FROM adoptopenjdk/openjdk11:ubi
MAINTAINER vikavl
VOLUME /h2DB
ADD target/h2-docker-0.0.1-SNAPSHOT.jar h2-docker-1.0.0.jar
ENTRYPOINT ["java","-jar","/h2-docker-1.0.0.jar"]
```

**Description of the parameters from Dockerfile**:
1. ***adoptopenjdk/openjdk11:ubi*** - the version of java that is used by application (in that case is java 11).
2. ***vikavl*** - opportunity to set the name of the maintainer of the application.
3. ***/h2DB*** - name of the volume where the messages are stored.
4. ***target/h2-docker-0.0.1-SNAPSHOT.jar*** - the path to snapshot (<ins>executable jar file</ins>) of the application. To get the snapshot of the application <ins>install</ins> (*./mvnw install*).
5. ***h2-docker-1.0.0.jar*** - name of the new-created image executable jar file.
6. ***["java","-jar","/h2-docker-1.0.0.jar"]*** - there are CMD arguments that is creating the new-created image executable jar file.

```
// the command to bulid an image
// docker build {name of the new-created image executable jar file}--tag=:latest .
docker build --tag=h2-greetings:latest .
```

![img1](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img1.png)

### **3.2 CREATE THE CONTAINER AND RUN IT**

When the image is built we can create its container:
```
// docker run -p{local port}:{container port} {name of image}:latest
docker run -p8081:8080 h2-greetings:latest
```
There is used *-p* flag to define ports of local machine (the laptop) and container.

![img2](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img2.png)

![img3](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img3.png)

### **3.3. SENDING THE REQUESTS TO DOCKER CONTAINER**

Using the local port to get access to port of container.

**1. Sending messages to database:**

2 messages are sent.

![img4](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img4.png)
![img5](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img5.png)

**2. Searching messages by type "greeting"**

![img6](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img6.png)

**3. The terminal output**

There are 2 strings of sent messages and in line 3 is a type of searching.

![img7](https://github.com/vikavl/spring-boot-tutorials/blob/main/h2-docker/src/main/resources/static/img7.png)

## **4. USEFUL LINKS ABOUT SPRING BOOT AND DOCKER**
There is a set of related links to the topic:
1. Spring Boot and Docker (from spring.io guides): [https://spring.io/guides/topicals/spring-boot-docker/](https://spring.io/guides/topicals/spring-boot-docker/).
2. Dockerizing a Spring Boot Application: [https://www.baeldung.com/dockerizing-spring-boot-application](https://www.baeldung.com/dockerizing-spring-boot-application).

------

> *Written by Viktoriia Vlasenko 02/02/2023*
