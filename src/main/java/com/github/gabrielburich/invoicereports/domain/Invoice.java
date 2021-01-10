package com.github.gabrielburich.invoicereports.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Invoice")
public class Invoice {

    @Id
    private String id;
    private User author;
    private Customer customer;
    private List<Item> items;
    private String paymentCondition;
    private String deadlineDescription;
    private Long daysValidity;

    private LocalDate creationDate = LocalDate.now();
}
