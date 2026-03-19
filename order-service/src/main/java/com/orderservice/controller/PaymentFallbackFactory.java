package com.orderservice.controller;

import com.orderservice.client.PaymentClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackFactory implements FallbackFactory<PaymentClient> {

    @Override
    public PaymentClient create(Throwable cause) {
        return orderId -> {
            // Log the actual root cause
            System.err.println("Payment fallback triggered. Cause: " + cause.getMessage());
            // Return a graceful message — the CB has already recorded the failure
            return "Payment unavailable: " + cause.getMessage();
        };
    }
}
