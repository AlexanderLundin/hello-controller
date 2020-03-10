package com.galvanize.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

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
