# Spring Boot JSF Integration Application
Add, delete and update the viewer information with with the help of JSF and Spring. 


### Prerequisites
- JSF 2.2.9
- Java 8
- Spring Boot 2.0.0.RELEASE 
- Spring boot AOP
- Maven latest
- H2 (With the dev profile you can use H2)
- tomcat

### Getting Started
##### Deployment Process
- Spring Boot (SpringJsfApplication.java)
- mvn clean
- mvn package 
- acess point

#####  Applications :
- Viewer:
    - http://localhost:7070/jsftask/viewerlist.jsf

- Movie:
    - http://localhost:7070/jsftask/movielist.jsf
    
#####   H2 DB Console:
-  http://localhost:7070/jsftask/h2/

- data.sql will insert some viewer information and Movie information in h2 db
