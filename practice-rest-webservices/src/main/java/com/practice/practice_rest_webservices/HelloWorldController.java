package com.practice.practice_rest_webservices;

import com.practice.practice_rest_webservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
// REST API
public class HelloWorldController {

//    calling hello-wrold in url gets "Hello World"
//    @RequestMapping(method= RequestMethod.GET, path="hello-world")
    @GetMapping(path="hello-world")
    public String helloWorld() {
        return "Hello-World";
    }

    @GetMapping(path="hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("hello-world");
    }

//    path parameter or path variable
    @GetMapping(path="hello-world/{a}")
    public HelloWorldBean getHelloByPathVariable(@PathVariable("a") String name) {
        return new HelloWorldBean(String.format("Hey, %s", name));
    }
}
