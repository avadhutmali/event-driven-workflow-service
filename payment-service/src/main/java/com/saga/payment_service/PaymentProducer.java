package com.saga.payment_service;

import com.example.saga.PaymentProcessedEventDTO;
import com.example.saga.StockReservedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentProducer {

    @Autowired
    RabbitTemplate template = new RabbitTemplate();

    public boolean isPaymentSuccess(StockReservedEvent stock){
        return true;
    }

    public String getPaymentId(){
        return "190.91/tempid";
    }

    public void produce(StockReservedEvent stock){
        if(isPaymentSuccess(stock)){
            String paymentId = getPaymentId();
            PaymentProcessedEventDTO payment = new PaymentProcessedEventDTO(stock.getOrderId(),paymentId,stock.getUserEmail(),"SUCCESS");
            template.convertAndSend("saga","order.success",payment);
        }
    }
}
