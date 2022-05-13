package com.harun.redisdemo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Customer implements Serializable {
    private String name;
    private String lastname;
    private int age;
}
