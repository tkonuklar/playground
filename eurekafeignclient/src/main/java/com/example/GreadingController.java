package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreadingController {
    @Autowired
    private GreedingClient greedingClient;

    @GetMapping("/get-greeting")
    public String greetingFromEurokaClient(){
        return greedingClient.greeting();
    }
}
