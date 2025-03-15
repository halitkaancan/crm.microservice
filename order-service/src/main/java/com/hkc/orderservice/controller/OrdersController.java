package com.hkc.orderservice.controller;

import com.hkc.orderservice.client.ProductClient;
import com.hkc.orderservice.entitiy.Order;
import io.github.halitkaancan.order.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final ProductClient productClient;
    private final StreamBridge streamBridge;
    public OrdersController(ProductClient productClient, StreamBridge streamBridge) {
        this.productClient = productClient;
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public String get() {
        // Syncİletişim
        //String response = productClient.get();
        //System.out.println(response);

        OrderCreatedEvent orderCreatedEvent = new
                OrderCreatedEvent("abc123", LocalDate.now());

        streamBridge.send("orderCreatedFunction-out-0", orderCreatedEvent);
        return "Order Service";
    }
}

