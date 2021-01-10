package com.github.gabrielburich.invoicereports.repository;

import com.github.gabrielburich.invoicereports.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, String> {}