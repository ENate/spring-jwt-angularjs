### A Full Stack spring-angular Application

Contents of the repository:

- A spring (Java) backend application and,
- an Angular based front end application

The following technology stack are used in the project:

+ Spring Boot 3.1.1
+ Spring Security 6.1
+ MySQL
+ Angular 16.0.+
In order to run the project, start by cloning the repo

```git clone <repo-name>```
First spin up the docker-compose to run the MySQL server and automatically create the database

``` docker-compose up -d ```

Then run the spring boot application using 
```mvn spring-boot:run ```

Open and and run the Angular application 
``` 
cd user-ui
ng server 
```

And to use the application, we open the Angular UI home endpoint 
via the defined port:
```http://localhost:8081 ```