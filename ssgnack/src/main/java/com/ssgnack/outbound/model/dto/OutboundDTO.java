package com.ssgnack.outbound.model.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OutboundDTO {

    private int outboundId;
    private Timestamp outDate;
    private int outAmt;
    private String status;
    private int adminId;
    private int productId;
    private int userId;
}
