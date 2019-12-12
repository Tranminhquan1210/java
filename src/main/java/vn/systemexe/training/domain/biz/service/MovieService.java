package vn.systemexe.training.domain.biz.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.MovieDetail;
import vn.systemexe.training.domain.biz.dto.UserDetail;


public interface MovieService {
	Mono<MovieDetail> findById(Long id);

	Flux<MovieDetail> findAll();

	Mono<MovieDetail> save(MovieDetail user);

	Mono<Void> deleteById(String id);

	Mono<MovieDetail> findByUsername(String username);

}
