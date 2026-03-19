package com.orderservice.client;

import com.orderservice.controller.PaymentFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "payment-service",
              url="http://localhost:8081/payment",
              fallbackFactory = PaymentFallbackFactory.class )
public interface PaymentClient {
    @GetMapping("/{orderId}")
    public String processPayment(@PathVariable Long orderId);
}
