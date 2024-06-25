package com.ssgnack.inboundStock.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDTO {

    private int stock_id;
    private int stock_amt;
    private int product_id;
    private int warehouse_id;
}
