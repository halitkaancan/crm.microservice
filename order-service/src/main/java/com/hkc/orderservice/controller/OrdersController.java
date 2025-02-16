package com.hkc.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final RestClient restClient;

    public OrdersController(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:8084").build();
    }

    @GetMapping
    public String order() {
        String response = restClient.get().uri("api/v1/products").retrieve().body(String.class);
        System.out.println("Product serviceden dönen cevap " + response);
        return "Order service is running";
    }
}

