package com.apirest.webflux.controller;

import java.time.Duration;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api-webflux")
public class PlayListController {

    @Autowired
    PlayListService playListService;

    // Index da API
    @GetMapping("")
    public String index() {
        return "<h1>Exemplo de API WEB-FLUX - Java Spring</h1><span>API Reativa com uso do Webflux e MongoDB</span>"
        + "<hr><table> <thead> <tr> <th>ROTA</th> <th>HTTP (Verbo)</th> <th>Request</th> <th>Return</th> <th>Description</th> </tr> </thead> <tbody> <tr> <td>/api-webflux/</td> <td>GET</td> <td>-</td> <td>HTML</td> <td>API index</td> </tr> <tr> <td>/api-webflux/playlist</td> <td>GET</td> <td>-</td> <td>JSON</td> <td>List playlist</td> </tr> <tr> <td>/api-webflux/playlist</td> <td>POST</td> <td>JSON</td> <td>JSON</td> <td>Create playlist</td> </tr> <tr> <td>/api-webflux/playlist/{id}</td> <td>GET</td> <td>int(id)</td> <td>JSON</td> <td>Get playlist by id</td> </tr> <tr> <td>/api-webflux/playlist/{id}</td> <td>PUT</td> <td>JSON, int(id)</td> <td>JSON</td> <td>Update playlist by id</td> </tr> <tr> <td>/api-webflux/playlist/{id}</td> <td>DELETE</td> <td>JSON, int(id)</td> <td>boolean</td> <td>Delete playlist by id</td> </tr> <tr> <td>/api-webflux/playlist/webflux</td> <td>GET</td> <td>-</td> <td>webflux</td> <td>List playlist by webflux</td> </tr> </tbody> </table>";
    }

    // Salvar playlist
    @PostMapping("/playlist")
    public Mono<PlayList> save(@RequestBody PlayList playList) {
        return this.playListService.save(playList);
    }

    // Listar playlists
    @GetMapping("/playlist")
    public Flux<PlayList> getPlayList() {
        return this.playListService.findAll();
    }

    // Recuperar playlist pelo id
    @GetMapping("/playlist/{id}")
    public Mono<PlayList> getPlayListById(@PathVariable String id) {
        return this.playListService.findById(id);
    }

    // Atualizar playlist pelo id
    @PutMapping("/playlist/{id}")
    public Mono<PlayList> update(@PathVariable String id, @RequestBody PlayList playList) {
        if(!id.equals(playList.getId())){
            return null;
        }
        return this.playListService.save(playList);
    }

    // Remover playlist pelo id
    @DeleteMapping("/playlist/{id}")
    public Mono<Void> delete(@PathVariable String id, @RequestBody PlayList playList) {
        if(!id.equals(playList.getId())){
            return null;
        }
        return this.playListService.delete(playList);
    }

    // Stream de eventos por web flux
    @GetMapping(value = "/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlaylistByWebflux() {
        // Define um intervalo de tempo para enviar as playlists
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        // Consulta as playlists
        Flux<PlayList> playlistFlux = this.playListService.findAll();
        // Retorna o stream de eventos de acordo com o intervalo
        return Flux.zip(interval, playlistFlux);
    }

}
