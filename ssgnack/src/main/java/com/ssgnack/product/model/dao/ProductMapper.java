package com.ssgnack.product.model.dao;

import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.CompanyDTO;
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

    List<CompanyDTO> selectCompanyList();

    Integer duplicateCheckId(ProductDTO product);

    boolean updateProduct(ProductDTO product);

    boolean insertNewStock();

    Integer selectAllTableByProductId(int productId);

    boolean deleteProduct(int productId);

    boolean deleteStock(int productId);

    void fileNameUpdate(String fileName, int productId);

    int selectMaxProductId();

}
