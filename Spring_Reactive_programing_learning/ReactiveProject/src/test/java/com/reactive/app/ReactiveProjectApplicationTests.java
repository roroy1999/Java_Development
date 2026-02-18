package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
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
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMonoUsingSubscriber(){
//		Mono ----> Publisher that have 0...1 items
		Mono<String> learn = Mono.just("Learn Code");//creates mono of String type since we passed String
		learn.subscribe(new Subscriber<String>() {
			@Override
			public void onSubscribe(Subscription s) {
				s.request(1);
			}

			@Override
			public void onNext(String s) {
				System.out.println("Hello");
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onComplete() {

			}
		});
		System.out.println("Testing");
	}

	@Test
	void workingWithMonoUsingConsumer(){
//		Mono ----> Publisher that have 0...1 items
		Mono<String> learn = Mono.just("Learn Code")
				.log();//logs all Subscriber activity
		learn.subscribe(data->{
			System.out.println("data is "+ data);
		});
		//learn.subscribe(System.out::println);
	}

	@Test
	void workingWithMonoUsingError(){
		Mono<String> errorMono = Mono.error(new RuntimeException("Error Mono"));
		Mono<String> learn = Mono.just("Learn Code")
				.log()
				.then(errorMono);//throws the errorMono mono which throws error
		learn.subscribe(System.out::println);
		//errorMono.subscribe(System.out::println);
	}

	@Test
	void workingWithMonoUsingZip(){
		Mono<String> m1 = Mono.just("Hello1");
		Mono<String> m2 = Mono.just("Hello2");
		Mono<Integer> m3 = Mono.just(3);

		//Mono<Tuple2<String,String>> comb = Mono.zip(m1,m2).log();
		Mono<Tuple3<String,String,Integer>> comb = Mono.zip(m1,m2,m3).log();
		//comb.subscribe(System.out::println);
		comb.subscribe(data->{
			System.out.println(data.getT1());
			System.out.println(data.getT2());
			System.out.println(data.getT3());
		});
	}

	@Test
	void workingWithMonoUsingZipWith() {
		Mono<String> m1 = Mono.just("Hello1");
		Mono<String> m2 = Mono.just("Hello2");

		Mono<Tuple2<String, String>> comb = m1.zipWith(m2).log();
		comb.subscribe(data -> {
			System.out.println(data.getT1());
			System.out.println(data.getT2());
		});
	}

	@Test
	void workingWithMonoUsingMap() {
		Mono<String> m1 = Mono.just("Hello1");

		Mono<String> result = m1.map(item-> item.toUpperCase()).log();
		result.subscribe(System.out::println);
	}

	@Test
	void workingWithMonoUsingFlatMap() {
		Mono<String> m1 = Mono.just("Hello Robin");

		Mono<String[]> result = m1.flatMap(item-> Mono.just(item.split(" "))).log();
		result.subscribe(r ->{
			System.out.println(r[1]);
		});
	}

	@Test
	void workingWithMonoUsingFlatMapMany() {
		Mono<String> m1 = Mono.just("Hello Robin");

		Flux<String> result = m1.flatMapMany(item-> Flux.just(item.split(" "))).log();
		result.subscribe(r ->{
			System.out.println(r);
		});
	}

	@Test
	void workingWithMonoUsingConcatWith() {
		Mono<String> m1 = Mono.just("Hello1");
		Mono<String> m2 = Mono.just("Hello2");

		Flux<String> result = m1.concatWith(m2).log();
		result.subscribe(System.out::println);
	}

	@Test
	void workingWithMonoUsingDelayElement() throws InterruptedException {
		Mono<String> m1 = Mono.just("Hello1");
		Mono<String> m2 = Mono.just("Hello2");
		System.out.println("Starting : " +Thread.currentThread().getName());

		Flux<String> result = m1.concatWith(m2).log().delayElements(Duration.ofMillis(2000));
		result.subscribe(data->{
			System.out.println("Subscriber : " +Thread.currentThread().getName());
			System.out.println("Data : "+ data);
		});

		Thread.sleep(10000);
		System.out.println("ending : " +Thread.currentThread().getName());
	}

}
