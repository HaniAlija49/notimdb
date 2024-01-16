# NotIMDb
<hr>
This app is based on Springboot application with gradle.

For this Java course we wanted to create something different, so we created this MovieApi called NotIMDb. More correctly an app from witch could dbe taken information about movies and their data such as director, actors, genres, reviews.
<ul>
<li>Movies - Where we register all movies.
Data:(Title, Date, Description, Rating, Actors, Director, Genres, reviews)</li>
<li>
We can CRUD on all entities.
</li>
<li>
On movies we can sort by director,actors,genre.
</li>
<li>
Search movie by title.
</li>
<li>Create reviews from user.</li>
</ul>
<h4>Getting Started</h4>
<hr>



### Setup

<h4>Requirements</h4>
<h4>Install these software first:</h4>
<ul>
<li>InteliJ IDEA.</li>
<li>Java SE Development Kit.</li>
<li>Insomnia (For testing apis)</li>
<li>XAMPP (Apache server - that contains MariaDB, PHP)</li>
</ul>

<hr>
<h3>Programming Languages used</h3>

![Java](https://img.shields.io/badge/Language-Java-red)
![SQL](https://img.shields.io/badge/Language-SQL-red)

<hr>

### Installations

Once you clone this project from GitHub or download it in zip, then you need to unzip and open it, in your editor IntelliJ IDEA (make sure
you click on TrustProject also after that let IntelliJ IDEA to install dependencies that we need
to open and run.
<hr>

### Technologies and APIs

![Insomnia](https://img.shields.io/badge/Insomnia-2b0d63?style=for-the-badge&logo=insomnia&logoColor=white)   <p>Insomnia is an API platform for building and using APIs. Insomnia simplifies each step of the API lifecycle and streamlines collaboration so you can create better APIs—faster.</p>  <br>  
![XAMPP](https://img.shields.io/badge/Xampp-F37623?style=for-the-badge&logo=xampp&logoColor=white)  <p>XAMPP is an abbreviation for cross-platform, and it allows you to build projects with API's offline, on a local web server on your computer. </p>

<hr>

## Starting the aplication

1.First thing you have to do for running the project is to turn on APACHE SERVER AND MYSQL on XAMPP, then they will take ports that they need.

2.javaproject.sql => this is the file of database, this one you need to import on your database. ('localhost/phpmyadmin').

3.Also you need to check 'application.properties', for example ...

```properties
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3307/moviedb
spring.datasource.username=root

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
```

### Dependencies

```json
plugins {
  id 'java'
  id 'org.springframework.boot' version '3.2.1'
  id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.notimdb'
version = '0.0.1-SNAPSHOT'

java {
  sourceCompatibility = '17'
}

repositories {
  mavenCentral()
}

dependencies {
  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  implementation 'org.springframework.boot:spring-boot-starter-web'
  runtimeOnly 'com.mysql:mysql-connector-j'
  testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
  useJUnitPlatform()
}

```