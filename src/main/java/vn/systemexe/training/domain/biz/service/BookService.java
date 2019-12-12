package vn.systemexe.training.domain.biz.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.Book;

public interface BookService {
	Mono<Book> findById(String id);

	Flux<Book> findAll();

	Mono<Book> save(Book book);

	Mono<Void> deleteById(String id);
}
