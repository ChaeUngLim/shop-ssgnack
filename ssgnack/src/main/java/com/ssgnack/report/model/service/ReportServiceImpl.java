package com.ssgnack.report.model.service;

import com.ssgnack.report.model.dao.ReportMapper;
import com.ssgnack.report.model.dto.ReportDTO;
import com.ssgnack.report.model.dto.ReportResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ReportServiceImpl implements ReportService{

    private final ReportMapper reportMapper;

    @Override
    public ReportResDTO totalSales() {
        List<ReportDTO> reportDTOList = reportMapper.totalSales();

        List<Integer> totalSaleList = new ArrayList<>();
        List<String> productNameList = new ArrayList<>();
        List<String> totalMonthList = new ArrayList<>();
        List<Integer> totalIncomeList = new ArrayList<>();

        for (ReportDTO reportDTO : reportDTOList) {
            totalSaleList.add(reportDTO.getTotalSale());
            productNameList.add(reportDTO.getProductName());
            totalMonthList.add(reportDTO.getTotalMonth());
            totalIncomeList.add(reportDTO.getTotalIncome());

        }

        return new ReportResDTO(totalSaleList, productNameList, totalMonthList, totalIncomeList);
    }

    @Override
    public ReportResDTO productSales(String productName) {

        List<ReportDTO> reportDTOList = reportMapper.productSales(productName);

        List<Integer> totalSaleList = new ArrayList<>();
        List<String> productNameList = new ArrayList<>();
        List<String> totalMonthList = new ArrayList<>();
        List<Integer> totalIncomeList = new ArrayList<>();

        for (ReportDTO reportDTO : reportDTOList) {
            totalSaleList.add(reportDTO.getTotalSale());
            productNameList.add(reportDTO.getProductName());
            totalMonthList.add(reportDTO.getTotalMonth());
            totalIncomeList.add(reportDTO.getTotalIncome());

        }

        return new ReportResDTO(totalSaleList, productNameList, totalMonthList, totalIncomeList);
    }

    @Override
    public ReportResDTO brandSales(String companyName) {
        List<ReportDTO> reportDTOList = reportMapper.brandSales(companyName);

        List<Integer> totalSaleList = new ArrayList<>();
        List<String> productNameList = new ArrayList<>();
        List<String> totalMonthList = new ArrayList<>();
        List<Integer> totalIncomeList = new ArrayList<>();

        for (ReportDTO reportDTO : reportDTOList) {
            totalSaleList.add(reportDTO.getTotalSale());
            productNameList.add(reportDTO.getProductName());
            totalMonthList.add(reportDTO.getTotalMonth());
            totalIncomeList.add(reportDTO.getTotalIncome());

        }

        log.info(productNameList.toString());
        return new ReportResDTO(totalSaleList, productNameList, totalMonthList, totalIncomeList);
    }

    @Override
    public ReportResDTO monthlySales(String start, String end) {
        List<ReportDTO> reportDTOList = reportMapper.monthlySales(start, end);

        List<Integer> totalSaleList = new ArrayList<>();
        List<String> productNameList = new ArrayList<>();
        List<String> totalMonthList = new ArrayList<>();
        List<Integer> totalIncomeList = new ArrayList<>();

        for (ReportDTO reportDTO : reportDTOList) {
            totalSaleList.add(reportDTO.getTotalSale());
            productNameList.add(reportDTO.getProductName());
            totalMonthList.add(reportDTO.getTotalMonth());
            totalIncomeList.add(reportDTO.getTotalIncome());

        }

        log.info(productNameList.toString());
        return new ReportResDTO(totalSaleList, productNameList, totalMonthList, totalIncomeList);
    }
}
