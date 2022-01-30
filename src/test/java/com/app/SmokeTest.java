package com.app;

import org.assertj.core.api.Assertions;

import com.app.controller.CustomerController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(customerController).isNotNull();
    }
}