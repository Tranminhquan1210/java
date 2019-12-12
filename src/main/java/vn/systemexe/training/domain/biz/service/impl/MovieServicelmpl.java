package vn.systemexe.training.domain.biz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.MovieDetail;

import vn.systemexe.training.domain.biz.service.MovieService;

import vn.systemexe.training.domain.db.dao.MovieDAO;

import vn.systemexe.training.domain.db.entity.Movie;

public class MovieServicelmpl implements MovieService {

	@Autowired
	private MovieDAO movieDao;

	public Mono<MovieDetail> findById(Long id) {
//		Movie movie = movieDao.findById(id);
//		MovieDetail movieDetail = new MovieDetail();
//		movieDetail.setId(movie.getId());
//		movieDetail.setUsername(movie.getUsername());
//		movieDetail.setPassword(movie.getPassword());
//		movieDetail.setEmail(movie.getEmail());
//		return Mono.just(movieDetail);
   	return null;
	}

	@Override
	public Flux<MovieDetail> findAll() {
		
		  MovieDetail movieDetail = null; List<MovieDetail> resultList = new ArrayList<>(); 
		  List<Movie> movies = movieDao.selectAll(); 
		  for (Movie movie : movies) { movieDetail = new MovieDetail(); movieDetail.setId(movie.getId());
		  movieDetail.setUsername(movie.getUsername());
		  movieDetail.setPassword(movie.getPassword());
		  movieDetail.setEmail(movie.getEmail());
		  movieDetail.setFirstName(movie.getFirstName());
		  movieDetail.setLastName(movie.getLastName()); resultList.add(movieDetail); }
		  return Flux.fromIterable(resultList);
		 

//		List<MovieDetail> resultList = new ArrayList<>();
//		resultList.add(new MovieDetail(1, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(2, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(3, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(4, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(5, "username", "password", "firstName", "lastName", "email", "token"));
//		resultList.add(new MovieDetail(6, "username", "password", "firstName", "lastName", "email", "token"));
//		System.out.println("list movies: " + resultList.size());
//		return Flux.fromIterable(resultList);
	}

	@Override
	public Mono<MovieDetail> save(MovieDetail movieDetail) {
//		Movie movie = new Movie();
//		movie.setUsername(movieDetail.getUsername());
//		movie.setPassword(movieDetail.getPassword());
//		movie.setEmail(movieDetail.getEmail());
//		movie.setFirstName(movieDetail.getFirstName());
//		movie.setLastName(movieDetail.getLastName());
//		movieDao.insert(movie);
//		movieDetail.setId(movie.getId());
		return Mono.just(movieDetail);
	
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return Mono.empty();
//		return null;
	}

	public Mono<MovieDetail> findByUsername(String username) {
//		Movie user = movieDao.findByUsername(username);
//		if (user == null) {
//			return Mono.empty();
//		}
//		MovieDetail movieDetail = new MovieDetail();
//		movieDetail.setId(user.getId());
//		movieDetail.setUsername(username);
//		movieDetail.setEmail(user.getEmail());
//		movieDetail.setPassword(user.getPassword());
//		return Mono.just(movieDetail);
		return null;
	}

}
