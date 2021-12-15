package com.apirest.webflux.controller;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlayListController {
    
    @Autowired
    PlayListService playListService;

    @GetMapping("/playlist")
    public Flux<PlayList> getPlayList(){
        return this.playListService.findAll();
    }

    @GetMapping("/playlist/{id}")
    public Mono<PlayList> getPlayListById(@PathVariable String id){
        return this.playListService.findById(id);
    }

    @PostMapping("/playlist")
    public Mono<PlayList> save(@RequestBody PlayList playList){
        return this.playListService.save(playList);
    }
}
