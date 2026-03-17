package com.reactive.app.contollers;

import com.reactive.app.entities.Book;
import com.reactive.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/books")
public class BookContoller {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> read(){
        return bookService.getAll().delayElements(Duration.ofSeconds(2)).log();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> get(@PathVariable int bookId){
        System.out.println(Thread.currentThread().getName());
        return bookService.get(bookId).doOnNext( item ->
                {
                    System.out.println(Thread.currentThread().getName());
                }
        );
    }

    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId){
        return bookService.update(book,bookId);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }
}
