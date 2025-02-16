package com.hkc.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service", url= "http://localhost:8084")
public interface ProductClient {

    @GetMapping("api/v1/products")
    String get();
}
