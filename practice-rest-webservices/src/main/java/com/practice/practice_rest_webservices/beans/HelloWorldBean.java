package com.practice.practice_rest_webservices.beans;

public class HelloWorldBean {
  private final String message;
  public HelloWorldBean(String message) {
    this.message=message;
  }

  public String getMessage(){
    return this.message;
  }
}
