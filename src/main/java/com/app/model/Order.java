package com.app.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDateTime;

@Jacksonized
@Value
@Builder
public class Order {

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final long orderId;

    @NotNull
    private final LocalDateTime date;

    @Size(min = 1, max = 50)
    @NotBlank
    private final String customerId;

}
