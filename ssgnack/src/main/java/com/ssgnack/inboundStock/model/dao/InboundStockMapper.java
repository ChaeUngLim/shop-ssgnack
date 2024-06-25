package com.ssgnack.inboundStock.model.dao;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.StockDTO;

import java.util.List;

public interface InboundStockMapper {
    int selectTotalCount();

    List<StockDTO> findAllStock(SelectCriteria selectCriteria);
}
