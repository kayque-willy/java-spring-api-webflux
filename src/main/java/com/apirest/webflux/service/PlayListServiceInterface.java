package com.apirest.webflux.service;

import com.apirest.webflux.document.PlayList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListServiceInterface{
    Flux<PlayList> findAll();
    Mono<PlayList> findById(String id);
    Mono<PlayList> save(PlayList playList);
}
