package com.saga.inventory_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InventoryRabbitConfig {
    @Bean
    public Queue inventoryQueue(){
        return new Queue("inventory-queue",true);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("saga",true,false);
    }

    @Bean
    public Binding binder(TopicExchange topicExchange,Queue inventoryQueue){
        return BindingBuilder.bind(inventoryQueue).to(topicExchange).with("inventory.#");
    }
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}
