package com.example.springconsumer.service;

import com.example.springconsumer.dto.Message;

public interface ConsumerService {
    void action(Message message) throws Exception;
}
