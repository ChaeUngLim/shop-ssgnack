package com.ssgnack.product.model.service;

import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> selectProductList(String productName);

    int insertProduct(ProductDTO product);

    List<CategoryDTO> selectCategoryList();

}
