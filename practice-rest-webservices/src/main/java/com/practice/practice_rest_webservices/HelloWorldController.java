package com.practice.practice_rest_webservices;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
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
}
