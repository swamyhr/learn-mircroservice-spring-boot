package com.practice.practice_rest_webservices.user;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class UserDaoService {
//JPA/Hibernate > Database
//  UserDaoService > static List

  private static List<User> users = new ArrayList<>();

  static {
    users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
    users.add(new User(2, "Mark", LocalDate.now().minusYears(20)));
  }

//  findAll

  public List<User> findAll() {
    return users;
  }
//  save
//  findOne
}
