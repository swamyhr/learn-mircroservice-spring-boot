package com.practice.practice_rest_webservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
  public User getUserById(@PathVariable Integer id) {
    return userDaoService.findOne(id);
  }

}
