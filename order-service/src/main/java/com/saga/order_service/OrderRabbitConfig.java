package com.saga.order_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderRabbitConfig {

    @Bean
    public Queue orderGenerateQueue(){
        return new Queue("queue-order-generate",true);
    }
    @Bean
    public Queue orderSuccessQueue(){
        return new Queue("queue-order-success",true);
    }

    @Bean
    public TopicExchange orderExchange(){
        return  new TopicExchange("saga",true,false);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindGenerate(Queue orderGenerateQueue,TopicExchange orderExchange){
        return BindingBuilder.bind(orderGenerateQueue)
                            .to(orderExchange)
                            .with("order.generate");
    }
    @Bean
    public Binding bindSuccess(Queue orderSuccessQueue,TopicExchange orderExchange){
        return BindingBuilder.bind(orderSuccessQueue)
                            .to(orderExchange)
                            .with("order.success");
    }
}
