package com.learning.springfive.dao;

import com.learning.springfive.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by kumade1 on 1/3/18.
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User , String> {

    @Override
    Flux<User> findAll();

    @Override
    Mono<User> findById(String userid);

    @Override
    Mono<User> save(User s);
}
