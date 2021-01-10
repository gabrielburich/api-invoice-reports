package com.github.gabrielburich.invoicereports.service;

import com.github.gabrielburich.invoicereports.domain.Invoice;
import com.github.gabrielburich.invoicereports.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> list() {
        return repository.findAll();
    }

    public Optional<Invoice> get(String budgetId) {
        return repository.findById(budgetId);
    }

    public Invoice add(Invoice budget) {
        return repository.save(budget);
    }

    public void update(String id, Invoice invoice) {
        invoice.setId(id);
        repository.save(invoice);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
