package com.practice.practice_rest_webservices.user;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/users/createUser")
  public ResponseEntity<Object> createUser(@RequestBody User user) {
    userDaoService.save(user);
//    return ResponseEntity.status(HttpStatus.CREATED).build();
    return ResponseEntity.created(null).build();
  }
}
