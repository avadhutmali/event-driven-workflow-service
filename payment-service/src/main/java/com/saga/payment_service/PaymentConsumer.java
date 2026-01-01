package com.saga.payment_service;

import com.example.saga.OrderCreatedEventDTO;
import com.example.saga.OrderDTO;
import com.example.saga.StockReservedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @Autowired
    PaymentProducer producer;

    @RabbitListener(queues = "payment-queue")
    public void consume(StockReservedEvent stock){
        System.out.println("stock has come");
        System.out.println("User Id is "+stock.getUserId());
        System.out.println("Order Id is "+stock.getOrderId());
        System.out.println("Order total Amount is "+stock.getTotalAmount());
        System.out.println("Payment is done and send for order service");

        producer.produce(stock);
    }
}
