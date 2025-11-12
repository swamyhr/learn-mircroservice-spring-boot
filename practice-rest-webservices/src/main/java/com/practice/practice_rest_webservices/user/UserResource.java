package com.practice.practice_rest_webservices.user;

import com.practice.practice_rest_webservices.exceptions.UserNotFoundException;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
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
    User user = userDaoService.findOne(id);

//    check if user is null or not
//    if null throw an exception else return the formatted exception

    if(user == null)
      throw new UserNotFoundException("id: "+id);

    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
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

  @DeleteMapping("/users/{id}")
  public String deleteUserById(@PathVariable int id) {
    return userDaoService.deleteUserById(id);
  }
}
