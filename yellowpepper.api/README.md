# Swagger Petstore automated tests for Yellowpepper

## Overview
This project has all tests necessary to check Swagger Petstore project using API automated tests.

**Requeriments** 

 - Java 8: https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html.
 - Maven 3.8.1:https://maven.apache.org/docs/3.8.1/release-notes.html.
	 - Configure properly the MVN_HOME and test it before running petstore and automated test projects.
 - Swagger Petstore: https://github.com/swagger-api/swagger-petstore.
 - Internet connection required for Maven to download and install libraries for the petstore and automated test suite projects.
 
 **How to run automated test suite**

 - Install pre requisites.
 - Run Swagger Petstore locally using command:
    ```mvn package jetty:run```
 - Clone this repository locally. Be aware of cloning the ```master ``` branch.
 - Open a command line window.
 - Go to the directory where the repository is located.
 - On the directory where this repository is cloned, run this command:
```mvn test```
Through this command:
	 - Maven will download and install libraries required to execute automated test suite.
	 - Tests will start inmediately. Typical run time is about 10-20 seconds.
