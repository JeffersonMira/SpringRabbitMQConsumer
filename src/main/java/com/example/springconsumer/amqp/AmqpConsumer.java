package com.example.springconsumer.amqp;

public interface AmqpConsumer <T>{

    public void consumer(T t);
}
