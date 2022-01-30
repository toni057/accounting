package com.app.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Jacksonized
@Value
@Builder
public class Customer {

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final long customerId;

    @Size(min = 1, max = 50)
    @NotBlank
    private final String firstName;

    @Size(min = 1, max = 50)
    @Nullable
    private final String middleName;

    @Size(min = 1, max = 50)
    @NotBlank
    private final String lastName;

    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private final String email;

}
