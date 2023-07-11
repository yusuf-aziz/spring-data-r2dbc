package com.javaeg.r2dbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaeg.r2dbc.model.User;
import com.javaeg.r2dbc.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Flux<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Mono<User> save(User user) {
		return userRepository.save(user);
	}

	public Flux<User> getUsersByName(String name) {
		return userRepository.findByName(name);
	}

	public Flux<User> getUsersByCity(String city) {
		return userRepository.findByCity(city);
	}

	public Mono<User> getUsersBySsn(String ssn) {
		return userRepository.findBySsn(ssn);
	}

}
