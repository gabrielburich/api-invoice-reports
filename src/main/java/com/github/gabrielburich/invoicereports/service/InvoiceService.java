package com.github.gabrielburich.invoicereports.service;

import com.github.gabrielburich.invoicereports.domain.Invoice;
import com.github.gabrielburich.invoicereports.domain.Report;
import com.github.gabrielburich.invoicereports.exception.NotFoundException;
import com.github.gabrielburich.invoicereports.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    private final ReportService reportService;

    public InvoiceService(InvoiceRepository repository, ReportService reportService) {
        this.repository = repository;
        this.reportService = reportService;
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

    public Report getReport(String id) {
        var invoice = get(id);
        var reportParams = new HashMap<String, Object>();
        var reportName = invoice.getCustomer().getName().replaceAll("\\s", "_");

        reportParams.put("customerName", invoice.getCustomer().getName());
        reportParams.put("authorName", invoice.getAuthor().getName());
        reportParams.put("items", invoice.getItems());
        reportParams.put("paymentCondition", invoice.getPaymentCondition());
        reportParams.put("deadlineDescription", invoice.getDeadlineDescription());
        reportParams.put("daysValidity", invoice.getDaysValidity());
        reportParams.put("creationDate", invoice.getCreationDate());

        return reportService.createPdfReport(reportParams, reportName);
    }

}
