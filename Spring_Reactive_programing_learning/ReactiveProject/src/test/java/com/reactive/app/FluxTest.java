package com.reactive.app;
import com.reactive.app.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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



}
