package com.github.gabrielburich.invoicereports.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private String fileName;
    private byte[] bytes;

}
