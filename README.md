# Java Spring API WebFlux
Exemplo de API Reativa com uso do Java Spring WebFlux e MongoDB

This project was generated with [Java Spring Boot WebFlux](https://spring.io/projects/spring-boot) version 2.6.1

## Development server

Navigate to `http://localhost:8080/api-webflux`. The app will automatically reload if you change any of the source files.

## API REQUESTS: 

ROTA                          |     HTTP(Verbo)   |    Request    |    Return   |    Description           |
----------------------------- | ----------------- | ------------- | ----------- | ------------------------ |
/api-webflux/                 |       GET         |      -        |     HTML    | API index                |
/api-webflux/playlist         |       GET         |      -        |     JSON    | List playlist            |
/api-webflux/playlist         |       POST        |     JSON      |     JSON    | Create playlist          |
/api-webflux/playlist/{id}    |       GET         |    int(id)    |     JSON    | Get playlist by id       |
/api-webflux/playlist/{id}    |       PUT         | JSON, int(id) |     JSON    | Update playlist by id    |
/api-webflux/playlist/{id}    |       DELETE      | JSON, int(id) |    boolean  | Delete playlist by id    |
/api-webflux/playlist/webflux |       GET         |       -       |    webflux  | List playlist by webflux |

## Build

The build artifacts will be stored in the `target/` directory.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-mongodb)

