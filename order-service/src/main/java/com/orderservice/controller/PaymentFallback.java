package com.orderservice.controller;

import com.orderservice.client.PaymentClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentClient {

        @Override
        public String processPayment(Long orderId) {
            return "Payment Service is currently unavailable. Please try later.";
        }

    }

