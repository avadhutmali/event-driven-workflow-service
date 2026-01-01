package com.saga.inventory_service;

import com.example.saga.OrderCreatedEventDTO;
import com.example.saga.StockReservedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryProducer {

    @Autowired
    private RabbitTemplate template ;

    public boolean stockReserved(OrderCreatedEventDTO order){
        return true;
    }

    public void produce(OrderCreatedEventDTO order){
        if(stockReserved(order)){
            StockReservedEvent reserved = new StockReservedEvent(order.getOrderId(),order.getUserId(),order.getTotalAmount(),order.getUserEmail(),true);
            template.convertAndSend("saga","payment.initiate",reserved);
        }
    }
}
