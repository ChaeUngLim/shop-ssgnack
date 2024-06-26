package com.ssgnack.report.model.service;

import com.ssgnack.report.model.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    List<ReportDTO> totalSales();

    List<ReportDTO> productSales(String productName);

    List<ReportDTO> brandSales(String companyName);
}
