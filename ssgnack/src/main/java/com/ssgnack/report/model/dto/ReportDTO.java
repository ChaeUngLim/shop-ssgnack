package com.ssgnack.report.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDTO {

    private String date;
    private int amount;
    private int price;
    private String productName;
    private String companyName;

}
