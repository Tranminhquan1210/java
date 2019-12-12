package vn.systemexe.training.domain.biz.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.UserDetail;

public interface UserService {
	Mono<UserDetail> findById(Long id);

	Flux<UserDetail> findAll();

	Mono<UserDetail> save(UserDetail User);

	Mono<UserDetail> deleteById(Long id);

	Mono<UserDetail> findByUsername(String username);
	
	Mono<UserDetail> updateById(UserDetail userDetail);
   
}
