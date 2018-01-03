package com.learning.springfive.controller;

import com.learning.springfive.dao.UserRepository;
import com.learning.springfive.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Created by kumade1 on 1/3/18.
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(consumes = "application/json")
    public Mono<User> addUsers(@RequestBody User user) {

        System.out.println("found user values");

      return  userRepository.save(user);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAllUsers() {
        Flux<User> allUsers = userRepository.findAll();
        return Flux.interval(Duration.ofSeconds(1))
                .zipWith(allUsers, (l, user) -> user );
    }

    @GetMapping(path = "/{userid}", produces = "application/json")
    public Mono<User> getUserByUserId(@PathVariable String userid) {
        return userRepository.findById(userid);
    }

}
