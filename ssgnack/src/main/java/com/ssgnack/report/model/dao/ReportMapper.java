package com.ssgnack.report.model.dao;

import com.ssgnack.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportDTO> totalSales();
}
