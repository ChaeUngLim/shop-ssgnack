package com.ssgnack.inboundStock.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDTO {

    private int stockId;
    private int stockAmt;
    private int productId;
    private int warehouseId;
}
