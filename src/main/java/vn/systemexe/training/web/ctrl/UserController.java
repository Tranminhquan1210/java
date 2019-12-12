package vn.systemexe.training.web.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.UserDetail;
import vn.systemexe.training.domain.biz.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "user/{id}")
	public Mono<UserDetail> getUserById(@PathVariable Long id) {
		System.out.println("id lay dc: " + id);
		return userService.findById(id);
	}

	@GetMapping(value = "/users")
	public Flux<UserDetail> getAllUsers() {

		return userService.findAll();
	}

	@PostMapping(value = "/user")
	public Mono<UserDetail> createUser(@RequestBody UserDetail user) {
		return userService.save(user);
	}

	@PostMapping(value = "/user/{id}")
	public Mono<UserDetail> deleteUser(@PathVariable Long id) {
 
		return userService.deleteById(id);
	}
	
	@PostMapping(value = "/users/{id}")
	public Mono<UserDetail> updateById(@RequestBody UserDetail userDetail, @PathVariable Long id) {
		return userService.updateById(userDetail);
	}

}
