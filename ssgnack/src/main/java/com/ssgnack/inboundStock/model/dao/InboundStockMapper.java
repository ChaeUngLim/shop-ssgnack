package com.ssgnack.inboundStock.model.dao;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.InboundDTO;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InboundStockMapper {
    int selectTotalCount();

    List<StockDTO> findAllStock(SelectCriteria selectCriteria);

    void inNewStock(InboundDTO newStock);
}
