package com.harun.redisdemo.service;

import com.harun.redisdemo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import org.json.JSONObject;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final RedisTemplate<String, Object> redisTemplate;

    private final ChannelTopic topic;

    public void sendMessage(Customer customer)
    {
        redisTemplate.convertAndSend(topic.getTopic(), new JSONObject(customer).toString());
    }
}
