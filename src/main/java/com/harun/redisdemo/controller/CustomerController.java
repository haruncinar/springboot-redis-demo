package com.harun.redisdemo.controller;

import javax.validation.Valid;

import com.harun.redisdemo.model.Customer;
import com.harun.redisdemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/send")
    public void sendMessage(@Valid @RequestBody Customer customer)
    {
        customerService.sendMessage(customer);
    }
}
