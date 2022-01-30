package com.app.controller;

import com.app.model.Customer;
import com.app.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
public class CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private static CustomerService customerService = new CustomerService();

    @PostMapping("/customers")
    public Customer customers(@Valid @RequestBody Customer customer) {
        return customer;
    }

    // can you omit null fields?
    // fuzzy search
    // if none found return empty array or a special message?
    @GetMapping(path = "/customers")
    public List<Customer> findByLastName(@RequestParam @NotBlank @Size(max = 50) String lastName) {
        var cust = customerService.findCustomerByLastName(lastName);

        logger.info(cust.toString());

        return cust;
    }
}