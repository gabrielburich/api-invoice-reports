package com.github.gabrielburich.invoicereports.controller;

import com.github.gabrielburich.invoicereports.domain.Invoice;
import com.github.gabrielburich.invoicereports.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> list() {
        var list = service.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> get(@PathVariable String id) {
        var item = service.get(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Invoice> add(@RequestBody Invoice invoice) {
        var newItem = service.add(invoice);
        return ResponseEntity.ok(newItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> update(@PathVariable String id, @RequestBody Invoice invoice) {
        var updatedItem = service.update(id, invoice);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok(id);
    }
}
