package com.hkc.orderservice.controller;

import com.hkc.orderservice.client.ProductClient;
import com.hkc.orderservice.entitiy.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    @GetMapping
    public String order() {
//        String response = productClient.get();
//        System.out.println(response);

        Order order = new Order();
        order.setId("abc123");
        streamBridge.send("orderCreatedFunction-out-0","Mesaj iletildi...");
        return "Order service is running";
    }
}

