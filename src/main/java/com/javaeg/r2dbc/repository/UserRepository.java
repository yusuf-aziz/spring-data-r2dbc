package com.javaeg.r2dbc.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.javaeg.r2dbc.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
	
	@Query("select * from reactive_user where name = :name")
	Flux<User> findByName(String name);
	
	Flux<User> findByCity(String name);
	
	Mono<User> findBySsn(String ssn);

	Mono<User> findById(int id);

	Mono<Void> deleteById(int id);
}
