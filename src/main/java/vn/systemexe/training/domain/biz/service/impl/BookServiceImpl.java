package vn.systemexe.training.domain.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.Book;
import vn.systemexe.training.domain.biz.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Mono<Book> findById(String id) {
		Mono<Book> book = Mono.just(new Book());
		return book;
	}

	@Override
	public Flux<Book> findAll() {
		List<Book> books = new ArrayList<>();
		books.add(new Book());
		return Flux.fromIterable(books);
	}

	@Override
	public Mono<Book> save(Book book) {
		Mono<Book> rbook = Mono.just(new Book());
		return rbook;
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return Mono.empty();
	}

}

