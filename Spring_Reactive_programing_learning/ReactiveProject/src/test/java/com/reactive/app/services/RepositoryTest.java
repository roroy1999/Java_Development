package com.reactive.app.services;

import com.reactive.app.entities.Book;
import com.reactive.app.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void finderMethodTest(){
        Mono<Book> book =bookRepository.findByName("robin").log();
        StepVerifier.create(book).expectNextCount(1).verifyComplete();

        Flux<Book> books =bookRepository.findByAuthor("roy").log();
        StepVerifier.create(books).expectNextCount(3).verifyComplete();

        Flux<Book> complexBook =bookRepository.findByNameAndAuthor("robin","roy").log();
        StepVerifier.create(complexBook).expectNextCount(1).verifyComplete();
    }

    @Test
    public void queryMethodsTest(){
        bookRepository.getAllBookByAuthor("robin").log()
                .as(StepVerifier::create).expectNextCount(1)
                .verifyComplete();

        bookRepository.getAllBookByAuthorByDifferentName("robin").log()
                .as(StepVerifier::create).expectNextCount(1)
                .verifyComplete();

        bookRepository.getAllBookByAuthorAndName("robin","roy").log()
                .as(StepVerifier::create).expectNextCount(1)
                .verifyComplete();

        bookRepository.searchBookByTitle("%gandu%").log()
                .as(StepVerifier::create).expectNextCount(1)
                .verifyComplete();
    }
}
