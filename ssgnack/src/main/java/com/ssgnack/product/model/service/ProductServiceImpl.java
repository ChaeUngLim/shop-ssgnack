package com.ssgnack.product.model.service;

import com.ssgnack.product.model.dao.ProductMapper;
import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;

    public ProductServiceImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> selectProductList(String productName) {
        return mapper.selectProductList(productName);
    }

    @Override
    public int insertProduct(ProductDTO product) {
        boolean bStat = false;
        Integer companyResult = 0;

        companyResult = mapper.companyIsThere(product.getCompany());
        log.info("👀👀👀 [ProductService] companyResult : {} , input : {} 👀👀👀", companyResult, product.getCompany());

        if(companyResult == null || companyResult <= 0) {
            bStat = mapper.insertCompany(product.getCompany());

            if (!bStat) {
                return 1;
            }
        } else {
            String dupCheck = "";
            dupCheck = mapper.duplicateCheckName(product.getProductName());

            if(dupCheck != null
                    && !dupCheck.isEmpty()
                    && dupCheck.equals(product.getProductName())) {

                return 2;
            }
        }

        log.info("👀👀👀 [ProductService] insert : {} 👀👀👀", product.toString() );
        bStat = mapper.insertProduct(product);

        if(!bStat){
            return 1;
        }

        return 0;
    }

    @Override
    public List<CategoryDTO> selectCategoryList() {
        return mapper.selectCategoryList();
    }
}
