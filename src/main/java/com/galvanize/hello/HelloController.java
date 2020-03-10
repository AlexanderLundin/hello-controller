package com.galvanize.hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    //@RequestMapping(value = "/api", method = RequestMethod.GET)
    @GetMapping("/api")
    public String sayHello(@RequestParam (required = false, defaultValue = "World") String name) {
        return String.format("Hello %s, from sayHello", name);
    }

    @GetMapping("/{name}")
    public String sayHelloPath(@PathVariable (required = false) String name) {
        return String.format("Hello %s, from sayHelloPath 2342", name == null ? "World" : name);
    }

    @PostMapping
    public String sayHelloPost(@RequestBody String name) {
        return String.format("Hello %s, from sayHelloPath", name == null ? "World" : name);
    }


}
