package vn.systemexe.training.web.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.MovieDetail;

import vn.systemexe.training.domain.biz.service.MovieService;

//@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping(value = "movie/{id}")
	public Mono<MovieDetail> getMovieById(@PathVariable Long id) {
		return movieService.findById(id);
	}

	// test
//	@GetMapping(value = "/movies")
//	public Flux<MovieDetail> getAllMovies() {
//		List<MovieDetail> resultList = new ArrayList<>();
//		resultList.add(new MovieDetail(1, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(2, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(3, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(4, "username", "password", "firstName", "lastName", "email", "token"));///		resultList.add(new MovieDetail(5, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(6, "username", "password", "firstName", "lastName", "email", "token"));
//		return Flux.fromIterable(resultList);
//	}
	@GetMapping(value = "/movies")
	public Flux<MovieDetail> getAlMovie() {
		List<MovieDetail> resultList = new ArrayList<>();
		resultList.add(new MovieDetail(1L, "username", "password", "firstName", "lastName", "email", "token"));
		resultList.add(new MovieDetail(2L, "username", "password", "firstName", "lastName", "email", "token"));
		resultList.add(new MovieDetail(3L, "username", "password", "firstName", "lastName", "email", "token"));
		resultList.add(new MovieDetail(4L, "username", "password", "firstName", "lastName", "email", "token"));
		resultList.add(new MovieDetail(5L, "username", "password", "firstName", "lastName", "email", "token"));
		resultList.add(new MovieDetail(6L, "username", "password", "firstName", "lastName", "email", "token"));
		System.out.println("list movies: " + resultList.size());
		return Flux.fromIterable(resultList);
	}
	@PostMapping(value = "/movie")
	public Mono<MovieDetail> createMovie(@RequestBody MovieDetail movie) {
		return movieService.save(movie);
	}
}
