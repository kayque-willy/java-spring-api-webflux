# Java Spring API WebFlux
Exemplo de API Reativa com uso do Java Spring WebFlux e MongoDB

This project was generated with [Java Spring Boot WebFlux](https://spring.io/projects/spring-boot) version 2.6.1

## Development server

Navigate to `http://localhost:8080/api-webflux`. The app will automatically reload if you change any of the source files.

## API REQUESTS: 

# Get playlist
GET (json) -> return (json)
`http://localhost:8080/api-webflux/playlist`

# Get playlist by id
GET (id = `bd540341-e8c4-4994-82ee-a75eb53bfa0e`) -> return (json)
`http://localhost:8080/api-webflux/playlist/bd540341-e8c4-4994-82ee-a75eb53bfa0e`

# Save playlist 
POST (json) -> return (json)
`http://localhost:8080/api-webflux/playlist`

# Delete playlist
DELETE (json) -> return boolean
`http://localhost:8080/api-webflux/playlist`

# Web-flux playlist
DELETE (json) -> return boolean
`http://localhost:8080/api-webflux/playlist/webflux`

## Build

The build artifacts will be stored in the `target/` directory.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/maven-plugin/reference/html/#build-image)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-mongodb)

