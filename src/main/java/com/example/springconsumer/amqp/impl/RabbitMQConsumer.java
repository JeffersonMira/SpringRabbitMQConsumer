package com.example.springconsumer.amqp.impl;

import com.example.springconsumer.amqp.AmqpConsumer;
import com.example.springconsumer.dto.Message;
import com.example.springconsumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

    @Autowired
    private ConsumerService service;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}") // needed to be able to consume the rabbit
    public void consumer(Message message) {
        try {
            service.action(message);
        }catch(Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
