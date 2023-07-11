package com.javaeg.r2dbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaeg.r2dbc.model.User;
import com.javaeg.r2dbc.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class R2dbcController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public Flux<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/save-user")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<User> createUser(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/users/name/{name}")
	@ResponseStatus(HttpStatus.OK)
	public Flux<User> getUsersByName(@PathVariable("name") String name) {
		return userService.getUsersByName(name);
	}

	@GetMapping("/users/city/{city}")
	@ResponseStatus(HttpStatus.OK)
	public Flux<User> getUsersByCity(@PathVariable("city") String city) {
		return userService.getUsersByCity(city);
	}

	@GetMapping("/users/ssn/{ssn}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<User> getUsersBySsn(@PathVariable("ssn") String ssn) {
		return userService.getUsersBySsn(ssn);
	}
}
