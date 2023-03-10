# **KAFKA TUTORIAL**
## **THE CONTENTS**
1. Introduction
2. How to set kafka image?
3. APIs
4. Useful links about Kafka

## **1. INTRODUCTION**

That application is practicing base for producing and consuming messages using Apache Kafka.

The application already has all essential configuration for sharing messages. 

> To use the application and its APIs: run the docker containers as it described in the point "2.1. Introduction".

## **2. HOW TO SET KAFKA IMAGE**

### **2.1. INTRODUCTION**
The project contains the docker-compose file. That file was taken from [guide-article](https://towardsdatascience.com/how-to-install-apache-kafka-using-docker-the-easy-way-4ceb00817d8b).

**So how to build the docker containers?**

1. Pull the images and create containers:
```
> docker-compose -f docker-compose.yml up -d
```
![image4](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img4.png)

> **NOW EVERYTHING IS READY TO RUN APPLICATION!!! Congratulations!**

![image3](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img3.png)

2. You can execute kafka (the broker) to see available commands to use:
```
> docker exec -it kafka /bin/sh
```
Then will appear the bin/sh mode inside the kafka broker.
```
# cd /opt/kafka_<version>/bin
# ls
```
![image5](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img5.png)

### **2.2. TROUBESHOOTING**

**CASE**: to up the docker containers should use the Linux container mode and disable WSL 2 for docker engine in settings (use Hyper-V engine: is set by default when WSL 2 is disabled).

![image2](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img2.png)

![image1](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img1.png)

That action **will prevent error messages** as follows:

1. *no matching manifest for windows/amd64 in the manifest list entries*

2. *Error response from daemon: open \\.\pipe\docker_engine_windows: The system cannot find the file specified*

3. *requested image platform  (windows/amd64) does not match the detected host platform (linux/amd64) and no specific platform was requested*

## **3. APIs**
That application has 2 endpoints.

**1. [POST]/publish**

**<ins>DESCRIPTION:</ins>**

Publishing ***string*** and consuming it.

**<ins>REQUEST BODY:</ins>**

The request payload has the following structure:
```
@RequestParam(name = "topic") Optional<String> topic;
@RequestParam(name = "message") String message;
```
The field named as "topic" is optinal parameter. If it is not set, it will be set manualy by application by default as ***"stringTopic"***.

![image6](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img6.png)

**<ins>RESPONSE BODY:</ins>**

The response payload has the following structure:
```
ResponseEntity<>(string: message, HttpStatus.CREATED);
```

![image8](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img8.png)

**<ins>LOG OUTPUT:</ins>**

![image7](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img7.png)

**2. [POST]/publishMessage**

**<ins>DESCRIPTION:</ins>**

Publishing ***Message*** and consuming it.

The **Message** object has the following structure:
```
String description;
String type;
```

**<ins>REQUEST BODY:</ins>**

The request payload has the following structure:
```
@RequestParam(name = "topic") Optional<String> topic;
@RequestBody Message message;
```
The field named as "topic" is optinal parameter. If it is not set, it will be set manualy by applications by default as ***"messageTopic"***.

![image9](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img9.png)

**<ins>RESPONSE BODY:</ins>**

The response payload has the following structure:
```
ResponseEntity<>(Message: message, HttpStatus.CREATED);
```

![image10](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img10.png)

**<ins>LOG OUTPUT:</ins>**

![image11](https://github.com/vikavl/spring-boot-tutorials/blob/main/kafka-string-json/src/main/resources/static/img11.png)

## **4. USEFUL LINKS ABOUT KAFKA**

1. How to Install Apache Kafka Using Docker ??? The Easy Way: [https://towardsdatascience.com/how-to-install-apache-kafka-using-docker-the-easy-way-4ceb00817d8b](https://towardsdatascience.com/how-to-install-apache-kafka-using-docker-the-easy-way-4ceb00817d8b)

2. Publishing and consuming of custom data types: [https://www.baeldung.com/spring-kafka](https://www.baeldung.com/spring-kafka)

3. Examples of using and serializing objects while producing and consuming: [https://www.geeksforgeeks.org/spring-boot-kafka-consumer-example/](https://www.geeksforgeeks.org/spring-boot-kafka-consumer-example/)

4. How to run zookeeper and broker locally on your machine: [https://kafka.apache.org/quickstart](https://kafka.apache.org/quickstart)

------

> *Written by Viktoriia Vlasenko 24/01/2023*
