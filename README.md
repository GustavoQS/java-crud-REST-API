# java-crud-REST-API

![Preview-Screens](/img/endpoints.jpg)

API REST with CRUD operations, built with Java and Spring, alongside PostgreSQL for the database, and Maven for build and dependency management.

I developed this repository to practice and improve my skills on Java and learn the main concepts of REST APIs and Spring.

# API Endpoints

```
GET /product - Get a list of all products on the database

POST /product - Register a new product

PUT /product - Alter data on the database

DELETE /product/{id} - Inactivate data
```

# Database

This project was developed using [PostgreSQL](https://www.postgresql.org/) and [Flyway](https://flywaydb.org/) to manage database migrations


# Installation and Usage

1. Clone this repository
   ```
   $ git clone https://github.com/GustavoQS/java-crud-REST-API.git
   ```
2. Install all dependencies at `pom.xml` with Maven

3. Run it using Maven

4. Access it on [localhost:8080](http://localhost:8080)


# Dependencies
From [pom.xml](/api/pom.xml) file
```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
</dependencies>
```





