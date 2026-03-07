package com.reactive.app.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

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

    public Flux<Tuple2<String,Integer>> ZipExample(){
        return Flux.zip(Flux.just("Robin","Roy","Rohan"),Flux.just(123,2)).log();
    }

    public Flux<String> ZipTransformExample(){
        return Flux.zip(Flux.just("Robin","Roy","Rohan"),Flux.just(123,2),(n1,n2)->{
            return n1+n2;
        }).log();
    }

    public Flux<String> sideEffectExample(){
        return getFlux()
                .doOnNext(data->{
                    System.out.println(data + " On Next");
                })
                .doOnSubscribe(data->{
                    System.out.println(data + " On Subscribe");
                })
                .doOnEach(data->{
                    System.out.println(data + " On Each");
                })
                .doOnComplete(()->{
                    System.out.println("completed now");
                    throw new RuntimeException();
                })
                .onErrorResume(e->{
                    return Flux.just("You f up");
                })
                .log();

    }
}
