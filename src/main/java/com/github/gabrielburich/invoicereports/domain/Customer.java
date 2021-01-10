package com.github.gabrielburich.invoicereports.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Customer {

    private String name;
    private String email;

}
