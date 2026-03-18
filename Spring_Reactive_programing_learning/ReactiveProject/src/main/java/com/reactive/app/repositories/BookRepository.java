package com.reactive.app.repositories;

import com.reactive.app.entities.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {

    Mono<Book> findByName(String name);

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByNameAndAuthor(String name, String author);

    @Query("Select * from book where name= :name")
    Flux<Book> getAllBookByAuthor(String name);

    @Query("Select * from book where name= :name")
    Flux<Book> getAllBookByAuthorByDifferentName(@Param("name") String testName);

    @Query("Select * from book where name= :name and author= :author")
    Flux<Book> getAllBookByAuthorAndName(@Param("name") String testName,String author);

    @Query("select * from book where book_desc LIKE :title")
    Flux<Book> searchBookByTitle(String title);
}
