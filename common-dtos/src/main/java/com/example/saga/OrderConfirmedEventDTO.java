package com.example.saga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmedEventDTO {
    private String orderId;
    private String userEmail;
    private String firstName;
    private double totalAmount;
    private String orderDate;
}
