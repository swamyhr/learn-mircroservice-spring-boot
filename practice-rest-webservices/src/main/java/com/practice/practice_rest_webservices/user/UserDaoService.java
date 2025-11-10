package com.practice.practice_rest_webservices.user;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

@Component
public class UserDaoService {
//JPA/Hibernate > Database
//  UserDaoService > static List
private static int userCount = 0;
  private static List<User> users = new ArrayList<>();
//  private List<User> users = new ArrayList<>();

  static {
    users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
    users.add(new User(++userCount, "Mark", LocalDate.now().minusYears(20)));

  }

//  public UserDaoService() {
//    users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
//    users.add(new User(2, "Mark", LocalDate.now().minusYears(20)));
//  }
//  findAll

  public List<User> findAll() {
    return users;
  }
  public void save(User user) {
    user.setId(++userCount);
    users.add(user);
  }
//  save
//  findOne

  public User findOne(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    return users.stream().filter(predicate).findFirst().get();
  }
}
