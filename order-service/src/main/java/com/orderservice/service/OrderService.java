package com.orderservice.service;

import com.orderservice.client.PaymentClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final PaymentClient paymentClient;

    public OrderService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public String placeOrder(Long orderId) {

        String paymentStatus = paymentClient.processPayment(orderId);

        return "Order Placed Successfully : " + paymentStatus;
    }

}
