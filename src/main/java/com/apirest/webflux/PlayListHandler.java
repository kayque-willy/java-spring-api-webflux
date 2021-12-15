package com.apirest.webflux;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

// A PlayListHandler e a PlaylistRoute fazem o roteamente e chamada de métodos via programção funcional
// Para ativar a PlayListHandler é necessário o decorador @Component
// @Component
public class PlayListHandler {

    @Autowired
    PlayListService playListService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playListService.findAll(), PlayList.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playListService.findById(id), PlayList.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<PlayList> playList = request.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playList.flatMap(this.playListService::save), PlayList.class));
    }

}
