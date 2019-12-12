package vn.systemexe.training.domain.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import vn.systemexe.training.domain.biz.dto.UserDetail;
import vn.systemexe.training.domain.biz.service.UserService;
import vn.systemexe.training.domain.db.dao.UserDao;
import vn.systemexe.training.domain.db.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Mono<UserDetail> findById(Long id) {
		User user = userDao.findById(id);
		UserDetail userDetail = new UserDetail();
		userDetail.setId(user.getId());
		userDetail.setUsername(user.getUsername());
		userDetail.setPassword(user.getPassword());
		userDetail.setEmail(user.getEmail());
		return Mono.just(userDetail);
	}

	@Override
	public Flux<UserDetail> findAll() {
		UserDetail userDetail = null;
		List<UserDetail> resultList = new ArrayList<>();
		List<User> users = userDao.selectAll();
		for (User user : users) {
			userDetail = new UserDetail();
			userDetail.setId(user.getId());
			userDetail.setUsername(user.getUsername());
			userDetail.setPassword(user.getPassword());
			userDetail.setEmail(user.getEmail());
			userDetail.setFirstName(user.getFirstName());
			userDetail.setLastName(user.getLastName());
			resultList.add(userDetail);
		}
		return Flux.fromIterable(resultList);
	}

	@Override
	public Mono<UserDetail> save(UserDetail userDetail) {
		User user = new User();
		user.setId(userDetail.getId());
		user.setUsername(userDetail.getUsername());
		user.setPassword(userDetail.getPassword());
		user.setEmail(userDetail.getEmail());
		/*
		 * user.setFirstName(userDetail.getFirstName());
		 * user.setLastName(userDetail.getLastName());
		 */
		userDao.insert(user);
		userDetail.setId(user.getId());
		return Mono.just(userDetail);
	}

	@Override
	public Mono<UserDetail> deleteById(Long id) {
		if(Objects.isNull(id)) {
			return Mono.empty();
		}
		User user = userDao.findById(id);
		if(Objects.isNull(user)) {
			return Mono.empty();
		}
		UserDetail userDetail = new UserDetail();
		userDetail.setId(user.getId());
		userDetail.setUsername(user.getUsername());
		userDetail.setPassword(user.getPassword());
		userDetail.setEmail(user.getEmail());
		userDao.deleteById(user);
		return Mono.just(userDetail);
	}

	@Override
	public Mono<UserDetail> findByUsername(String username) {
		User user = userDao.findByUsername(username);
		if (user == null) {
			return Mono.empty();
		}
		UserDetail userDetail = new UserDetail();
		userDetail.setId(user.getId());
		userDetail.setUsername(username);
		userDetail.setEmail(user.getEmail());
		userDetail.setPassword(user.getPassword());
		return Mono.just(userDetail);
	}

	@Override
	public Mono<UserDetail> updateById(UserDetail userDetail) {
     
		User user = userDao.findById(userDetail.getId());
		if (user == null) {
			return Mono.empty();
		}
		user.setUsername(userDetail.getUsername());
		user.setPassword(userDetail.getPassword());
		user.setEmail(userDetail.getEmail());
		userDao.updateById(user);
		return Mono.just(userDetail);
		
	}
	

}
