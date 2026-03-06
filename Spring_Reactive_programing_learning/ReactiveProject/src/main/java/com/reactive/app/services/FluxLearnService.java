package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

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

    public Flux<String> FlatMapExampleFlux(){
        return Flux.just("Robin","Roy").flatMap(name-> Flux.just(name.split("")));
    }

    public Flux FluxTransfromExample(){
        Function<Flux<String>,Flux<String>> finInterface = (data)->{
            return data.filter(x->x.length()>3);
        };
        return Flux.just("Robin","Roy").transform(finInterface).log();
    }

    public Flux<String> ifExample(int length){
        return Flux.just("Robin","Roy","Rohan")
                .filter(x-> x.length()> length )
                .defaultIfEmpty("Shanker").log();
    }

    public Flux<String> switchIfEmptyExample(int length){
        return Flux.just("Robin","Roy","Rohan")
                .filter(x-> x.length()> length )
                .switchIfEmpty(Flux.just("Tarzen")).log();
    }

    public Flux<String> concatExample(){
        return Flux.concat(getFlux(),fruitsFlux()).log();
    }

    public Flux<String> concatWithExample(){
        return getFlux().concatWith(fruitsFlux()).log();
    }

    public Flux<String> mergeExample(){
        return Flux.merge(getFlux().delayElements(Duration.ofSeconds(1)),fruitsFlux().delayElements(Duration.ofSeconds(1))).log();
    }
}
