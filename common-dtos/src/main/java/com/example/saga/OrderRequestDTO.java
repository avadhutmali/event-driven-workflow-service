package com.example.saga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemDTO> items;
    private double totalAmount;
    private String shippingAddress;
    private String paymentMethod;
}
