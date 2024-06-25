package com.ssgnack.report.model.service;

import com.ssgnack.report.model.dao.ReportMapper;
import com.ssgnack.report.model.dto.ReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService{

    private final ReportMapper reportMapper;

    public ReportServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public List<ReportDTO> totalSales() {
        log.info("totalSales : " + reportMapper.totalSales());
        return reportMapper.totalSales();
    }
}
