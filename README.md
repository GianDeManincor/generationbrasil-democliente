# generationbrasil-democliente
Challenge proposed for the students I follow as a mentor at Generation Brasil.

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)
- H2 Database
- JPA + Hibernate

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.generation.brasil.demo.DemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

