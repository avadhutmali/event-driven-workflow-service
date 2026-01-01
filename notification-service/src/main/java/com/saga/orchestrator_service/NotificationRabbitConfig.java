package com.saga.orchestrator_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationRabbitConfig {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("saga",true,false);
    }

    @Bean
    public Queue paymentQueue(){
        return new Queue("notification-queue",true);
    }
    @Bean
    public Binding binder(Queue paymentQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(paymentQueue).to(topicExchange).with("notification.#");
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}
