package com.practice.practice_rest_webservices.user;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

  private UserDaoService userDaoService;

//  private User user = new User();

  public UserResource(UserDaoService userDaoService) {
    this.userDaoService = userDaoService;
  }

  @GetMapping("/users")
  public List<User> findAll() {
//    user.setId(1);
    return userDaoService.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable int id) {
    return userDaoService.findOne(id);
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@RequestBody User user) {
     User savedUser = userDaoService.save(user);
//    return ResponseEntity.status(HttpStatus.CREATED).build();

//    create a url to send back with new user ID

//    pseudoCode
//    get the current URL
//    get the new userID
//    combine
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
//    get the user id
    return ResponseEntity.created(uri).build();
  }
}
