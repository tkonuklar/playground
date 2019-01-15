package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "spring-cloud-eureka-client-tugce",
        configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface GreedingClient {
    @GetMapping("/greeting")
    String greeting();
}
