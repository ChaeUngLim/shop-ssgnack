package com.ssgnack.report.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {

    private int totalSale;
    private int totalIncome;
    private String productName;
    private String totalMonth;

}
