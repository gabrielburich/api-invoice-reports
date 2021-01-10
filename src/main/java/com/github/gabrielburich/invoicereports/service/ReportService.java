package com.github.gabrielburich.invoicereports.service;

import com.github.gabrielburich.invoicereports.domain.Report;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Slf4j
@Service
public class ReportService {

    @Value("${report.template-path}")
    private String templatePath;

    @Value("${report.name-prefix}")
    private String namePrefix;

    public Report createPdfReport(Map<String, Object> parameters, String fileName) {
        try {
            var print = createReport(parameters);
            var bytes = JasperExportManager.exportReportToPdf(print);
            var reportName = namePrefix + "_" + fileName + ".pdf";
            return new Report(reportName, bytes);
        } catch (JRException ex) {
            ex.printStackTrace();
            log.error("Error on create PDF report");
            return null;
        }
    }

    private JasperPrint createReport(Map<String, Object> parameters) {
        try {
            var template = getReportTemplate();
            parseParameters(parameters);
            return JasperFillManager.fillReport(template, parameters, new JREmptyDataSource());
        } catch (JRException ex) {
            ex.printStackTrace();
            log.error("Error on create report");
            return null;
        }
    }

    private JasperReport getReportTemplate() throws JRException {
        var reportStream = getClass().getResourceAsStream(templatePath);
        return JasperCompileManager.compileReport(reportStream);
    }

    private void parseParameters(Map<String, Object> parameters) {
        parameters.forEach((key, value) -> {
            if (value instanceof Collection) {
                parameters.replace(key, new JRBeanCollectionDataSource((Collection<?>) value));
            }
        });
    }

}
