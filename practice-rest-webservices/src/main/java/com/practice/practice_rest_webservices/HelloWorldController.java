package com.practice.practice_rest_webservices;

import com.practice.practice_rest_webservices.beans.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
// REST API
public class HelloWorldController {

//    calling hello-wrold in url gets "Hello World"
//    @RequestMapping(method= RequestMethod.GET, path="hello-world")

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("hello-world-internationalization")
    public String helloFromInternationalization() {

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

//        return "Hello World";
    }
}
