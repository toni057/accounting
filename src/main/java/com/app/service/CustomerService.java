package com.app.service;

import com.app.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    static List<Customer> hardCoded = new ArrayList<>();

    static {
        Customer homer = Customer.builder()
                .customerId(1)
                .firstName("Homer")
                .lastName("Simpson")
                .email("homer@snpp.com")
                .build();

        Customer marge = Customer.builder()
                .customerId(2)
                .firstName("Marge")
                .lastName("Simpson")
                .email("marge@job.com")
                .build();

        Customer mrBurns = Customer.builder()
                .customerId(3)
                .firstName("Charles")
                .middleName("Montgomery")
                .lastName("Burns")
                .email("burns@snpp.com")
                .build();

        hardCoded.addAll(List.of(homer, marge, mrBurns));
    }

    public List<Customer> findCustomerByLastName(String lastName) {
        return hardCoded
                .stream()
                .filter((customer) -> customer.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

}
