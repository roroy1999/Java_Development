package com.reactive.app.impl;

import com.reactive.app.entities.Book;
import com.reactive.app.repositories.BookRepository;
import com.reactive.app.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        Mono<Book> book = bookRepository.findById(Mono.just(bookId));
        return book;
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> item = bookRepository.findById(bookId);
        return item.flatMap( bk->{
            book.setBookId(bk.getBookId());
            return bookRepository.save(book);
        });
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
}
