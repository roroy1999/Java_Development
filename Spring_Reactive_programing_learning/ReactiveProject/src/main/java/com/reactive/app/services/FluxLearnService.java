package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FluxLearnService {

    public Flux<String> getFlux(){
        return Flux.just("Robin","Roy","Rohan");
    }

    public Flux<String> fruitsFlux(){
        List<String> fruit = List.of("Apple","Bannana");
        return Flux.fromIterable(fruit);
    }

    public Flux<Void> getBlankFlux(){
        return Flux.empty();
    }

    public Flux<String> MapExampleFlux(){

        Flux<String> cap = Flux.just("Robin","Roy").map((data)->{
            return data.toUpperCase();
        });
        return cap;
    }
}
