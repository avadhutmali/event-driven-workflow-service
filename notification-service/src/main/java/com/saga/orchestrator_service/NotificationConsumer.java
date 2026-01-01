package com.saga.orchestrator_service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = "notification-queue")
    public void consume(){
        System.out.println();
    }
}
