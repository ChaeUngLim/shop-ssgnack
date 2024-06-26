package com.ssgnack.product.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ProductDTO {

    private String productName;
    private String company;
    private String category;
    private String price;
    private String orderableStatus;
    private String fileName;
}
