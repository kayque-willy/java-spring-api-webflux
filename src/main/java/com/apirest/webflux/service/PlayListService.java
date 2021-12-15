package com.apirest.webflux.service;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.repository.PlayListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service    
public class PlayListService implements PlayListServiceInterface {

    @Autowired
    private PlayListRepository playListRepository;
    
    @Override
    public Flux<PlayList> findAll() {
        return this.playListRepository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return this.playListRepository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return this.playListRepository.save(playList);
    }
    
    @Override
    public Mono<Void> delete(PlayList playList) {
        return this.playListRepository.delete(playList);
    }
    
}
