package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

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
				.log();//creates mono of String type since we passed String
		learn.subscribe(data->{
			System.out.println("data is "+ data);
		});
		learn.subscribe(System.out::println);
	}

	@Test
	void workingWithMonoUsingError(){
		Mono<String> errorMono = Mono.error(new RuntimeException("Error Mono"));
		Mono<String> learn = Mono.just("Learn Code")
				.log()
				.then(errorMono);//creates mono of String type since we passed String

//		learn.subscribe(data->{
//			System.out.println("data is "+ data);
//		});
		learn.subscribe(System.out::println);
		//errorMono.subscribe(System.out::println);
	}

}
