package com.github.gabrielburich.invoicereports.domain;

import lombok.Data;

@Data
public class Item {

    private Integer quantity;
    private String description;
    private Double value;
    private String room;
}
