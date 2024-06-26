package com.ssgnack.report.model.service;

import com.ssgnack.report.model.dto.ReportResDTO;

public interface ReportService {
    ReportResDTO totalSales();

    ReportResDTO productSales(String productName);

    ReportResDTO brandSales(String companyName);

    ReportResDTO monthlySales(String start, String end);
}
