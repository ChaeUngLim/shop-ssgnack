package com.ssgnack.inboundStock.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InboundDTO {

    private int inboundId;
    private LocalDate inDate;
    private int inAmt;
    private int adminId;
    private int productId;
}
