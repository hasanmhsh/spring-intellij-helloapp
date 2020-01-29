package com.lambdaschool.helloapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    //receive GET methods and send Greeting class getters as JSON response and /greetin is the end point
    //so if you use this url in browser it will get the required JSON object from our pp
    //https://localhost:8080/greeting -> “hello, world!” in JSON
    //https://localhost:8080/greeting/?name=”hassan -> “hello, hassan!” in JSON
    //http://localhost:8080/greeting/?name=hasan%20mohamed -> “hello, hasan mohamed”   %unicode    , %20 = space
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template , name));
    }
}
