package com.ssgnack.product.model.service;

import com.ssgnack.product.model.dao.ProductMapper;
import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.CompanyDTO;
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

        bStat = mapper.insertNewStock();
        if(!bStat){
            return 1;
        }

        return 0;
    }

    @Override
    public List<CategoryDTO> selectCategoryList() {
        return mapper.selectCategoryList();
    }

    @Override
    public List<CompanyDTO> selectCompanyList() {
        return mapper.selectCompanyList();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        Integer companyResult = 0;
        boolean bStat = false;

        companyResult = mapper.duplicateCheckId(productDTO);

        if(companyResult == null || companyResult <= 0) {
            bStat = mapper.updateProduct(productDTO);
        }else {
            return 2;
        }

        if(!bStat) {
            return 3;
        }

        return 6;
    }

    @Override
    public int deleteProduct(int productId) {
        boolean bStat = false;
        Integer dataCount = 0;

        dataCount = mapper.selectAllTableByProductId(productId);

        if(dataCount == null || dataCount <= 0) {
            bStat = mapper.deleteStock(productId);
        }else{
            return 5;
        }

        if(!bStat) {
            return 4;
        }

        bStat = mapper.deleteProduct(productId);

        if(!bStat) {
            return 4;
        }

        return 7;
    }

    @Override
    public void fileNameUpdate(String fileName) {
        int productId = mapper.selectMaxProductId();
        mapper.fileNameUpdate(fileName, productId);
    }
}
