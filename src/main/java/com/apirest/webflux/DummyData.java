package com.apirest.webflux;

import java.util.UUID;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.repository.PlayListRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class DummyData implements CommandLineRunner {

    private final PlayListRepository playlistRepository;

    DummyData(PlayListRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Remove todos os documentos do MongoDB e em seguida, adiciona uma sequencia de
        // registros para popular o banco
        // playlistRepository.deleteAll()
        //         .thenMany(
        //                 Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
        //                         "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
        //                         .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
        //                         .flatMap(playlistRepository::save))
        //         .subscribe(System.out::println);
    }

}