package com.apirest.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

// A PlayListHandler e a PlaylistRoute fazem o roteamente e chamada de métodos via programção funcional
// Para ativar a PlayListRouter é necessário o decorador @Configuration
// @Configuration
public class PlayListRouter {
    @Bean
    public RouterFunction<ServerResponse> route(PlayListHandler handler) {
        return RouterFunctions.route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
                .andRoute(POST("/playlist").and(accept(MediaType.APPLICATION_JSON)), handler::save);
    }
}
