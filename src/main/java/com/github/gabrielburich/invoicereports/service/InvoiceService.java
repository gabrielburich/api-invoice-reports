package com.github.gabrielburich.invoicereports.service;

import com.github.gabrielburich.invoicereports.domain.Invoice;
import com.github.gabrielburich.invoicereports.exception.NotFoundException;
import com.github.gabrielburich.invoicereports.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> list() {
        return repository.findAll();
    }

    public Invoice get(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(Invoice.class, id));
    }

    public Invoice add(Invoice invoice) {
        return repository.save(invoice);
    }

    public Invoice update(String id, Invoice invoice) {
        invoice.setId(id);
        return repository.save(invoice);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
