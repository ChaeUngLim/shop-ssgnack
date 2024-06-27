package com.ssgnack.inboundStock.model.service;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.InboundDTO;
import com.ssgnack.inboundStock.model.dto.StockDTO;

import java.util.List;

public interface InboundStockService {
    
    int selectTotalCount();

    List<StockDTO> findAllStock(SelectCriteria selectCriteria);

    void inNewStock(StockDTO newStock);

    List<StockDTO> selectStockList(String productName);
}
