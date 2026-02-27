package com.reactive.app;
import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@SpringBootTest
public class FluxTest {

    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    void contextLoads() {
    }

    @Test
    public void fluxTest(){
        this.fluxLearnService.getFlux().log().subscribe(data->{
            System.out.println(data);
            System.out.println("done with flux data");
        });
    }

    @Test
    public void fluxFruitTest(){
        this.fluxLearnService.fruitsFlux().log().subscribe(data->{
            System.out.println(data);
        });
    }

    @Test
    public void fluxMapTest(){
        this.fluxLearnService.MapExampleFlux().subscribe(data->{
            System.out.println(data);
        });
    }

    @Test
    public void StepVerifierTest(){
        Flux<String> capFlux =this.fluxLearnService.MapExampleFlux();
        StepVerifier.create(capFlux)
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    public void expectNextTest(){
        Flux<String> capFlux =this.fluxLearnService.MapExampleFlux();
        StepVerifier.create(capFlux)
                .expectNext("ROBIN","ROY")
                .verifyComplete();
    }

    @Test
    public void filterTest(){
        Flux<String> capFlux = this.fluxLearnService.MapExampleFlux().filter(data->data.length()>4);
        StepVerifier.create(capFlux)
                .expectNext("ROBIN")
                .verifyComplete();
    }

    @Test
    void flatMapExampleFlux() {

        Flux<String> stringFlux = fluxLearnService.FlatMapExampleFlux().log();
        StepVerifier.create(stringFlux)
                .expectNextCount(8)
                .verifyComplete();
    }
}
