package com.app.service;

import com.app.controller.CustomerController;
import com.app.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CustomerController.class)
class CustomerServiceTest {

    static List<Customer> hardCoded = new ArrayList<>();
    static Customer homer, marge, mrBurns;

    static {
        homer = Customer.builder()
                .customerId(1)
                .firstName("Homer")
                .lastName("Simpson")
                .email("homer@snpp.com")
                .build();

        marge = Customer.builder()
                .customerId(2)
                .firstName("Marge")
                .lastName("Simpson")
                .email("marge@job.com")
                .build();

        mrBurns = Customer.builder()
                .customerId(3)
                .firstName("Charles")
                .middleName("Montgomery")
                .lastName("Burns")
                .email("burns@snpp.com")
                .build();

        hardCoded.addAll(List.of(homer, marge, mrBurns));
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void findCustomerByLastName() throws Exception {
        when(customerService.findCustomerByLastName("Simpson"))
                .thenReturn(List.of(homer, marge));
        this.mockMvc.perform(
                        get("/customers")
                                .accept("application/json")
                                .queryParam("lastName", "Simpson"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Homer"))
                .andExpect(jsonPath("$[1].firstName").value("Marge"))
        ;
    }
}