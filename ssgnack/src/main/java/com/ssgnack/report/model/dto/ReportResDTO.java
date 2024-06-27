package com.ssgnack.report.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportResDTO {

    private List<Integer> totalSale;
    private List<String> productName;
    private List<String> totalMonth;
    private List<Integer> totalIncome;
}
