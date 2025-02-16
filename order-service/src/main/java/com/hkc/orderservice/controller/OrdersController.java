package com.hkc.orderservice.controller;

import com.hkc.orderservice.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final ProductClient productClient;

    @GetMapping
    public String order() {
        String response = productClient.get();
        System.out.println(response);
        return "Order service is running";
    }
}

