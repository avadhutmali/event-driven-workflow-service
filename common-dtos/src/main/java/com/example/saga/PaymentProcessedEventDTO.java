package com.example.saga;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessedEventDTO {
    private long orderId;
    private String paymentId;
    private String userEmail;
    private String status;
//    private LocalDateTime timestamp;
}
