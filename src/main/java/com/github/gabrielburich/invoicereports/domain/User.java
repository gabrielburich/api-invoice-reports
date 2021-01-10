package com.github.gabrielburich.invoicereports.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User {

    private String id;
    private String name;
    private String email;
    private String password;

}
