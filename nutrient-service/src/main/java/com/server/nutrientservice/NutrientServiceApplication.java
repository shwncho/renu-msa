package com.server.nutrientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NutrientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutrientServiceApplication.class, args);
    }

}
