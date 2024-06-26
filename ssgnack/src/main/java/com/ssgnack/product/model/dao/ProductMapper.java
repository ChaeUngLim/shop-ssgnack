package com.ssgnack.product.model.dao;

import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO> selectProductList(String productName);

    boolean insertProduct(ProductDTO product);

    Integer companyIsThere(String company);

    boolean insertCompany(String company);

    String duplicateCheckName(String productName);

    List<CategoryDTO> selectCategoryList();
}
