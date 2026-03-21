package com.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/{orderId}")
    public String processPayment(@PathVariable Long orderId) {

        // Simulate 70% failure
        if(new Random().nextInt(10)<7) {
            throw new RuntimeException("Payment service failed!");
        }
        return "Payment successful for order : " + orderId;

    }
}
