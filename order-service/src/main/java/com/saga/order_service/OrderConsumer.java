package com.saga.order_service;

import com.example.saga.OrderDTO;
import com.example.saga.PaymentProcessedEventDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @RabbitListener(queues = "queue-order-generate")
    public void consumer(OrderDTO msg){
        System.out.println(msg.getName()+" "+msg.getOrderId()+" "+msg.getPrice());
    }
    @RabbitListener(queues = "queue-order-success")
    public void consumerSuccess(PaymentProcessedEventDTO payement){
        System.out.println("payment is Successful");
    }
}
