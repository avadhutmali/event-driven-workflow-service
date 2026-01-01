package com.example.saga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockReservedEvent {
    private Long orderId;
    private Long userId;
    private double totalAmount;
    private String userEmail;
    private boolean isStockReserved;
}
