package com.harun.redisdemo.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harun.redisdemo.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.io.IOException;

@Slf4j
public class CustomMessageSubscriber implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            Customer customer = new ObjectMapper().readValue(message.toString(), Customer.class);
            log.info("Received >> " + customer.toString() +  ", " + Thread.currentThread().getName() + ", channel: " + new String((message).getChannel()));
        }
        catch (IOException exception){
            log.error(String.format("Error occurred while convertion bytes to object :  %s", exception.getMessage()));
        }
    }
}
