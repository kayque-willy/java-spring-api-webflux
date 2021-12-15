package com.apirest.webflux.controller;

import java.time.Duration;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@CrossOrigin(origins = "*")
@RestController
public class PlayListController {

    @Autowired
    PlayListService playListService;

    @GetMapping("/playlist")
    public Flux<PlayList> getPlayList() {
        return this.playListService.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<PlayList> getPlayListById(@PathVariable String id) {
        return this.playListService.findById(id);
    }

    @PostMapping("/playlist")
    public Mono<PlayList> save(@RequestBody PlayList playList) {
        return this.playListService.save(playList);
    }

    //Stream de eventos por web flux
    @GetMapping(value = "/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlaylistByWebflux() {
        //Define um intervalo de tempo para enviar as playlists
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        //Consulta as playlists 
        Flux<PlayList> playlistFlux = this.playListService.findAll();
        // Retorna o stream de eventos de acordo com o intervalo
        return Flux.zip(interval, playlistFlux);
    }

}
