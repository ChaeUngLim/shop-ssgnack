package com.ssgnack.inboundStock.model.service;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dao.InboundStockMapper;
import com.ssgnack.inboundStock.model.dto.InboundDTO;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InboundStockServiceImpl implements InboundStockService {

    private final InboundStockMapper inboundStockMapper;

    public InboundStockServiceImpl(InboundStockMapper inboundStockMapper) {this.inboundStockMapper = inboundStockMapper;}

    @Override
    public int selectTotalCount() {
        return inboundStockMapper.selectTotalCount();
    }

    /***
     *
     * @param selectCriteria
     * @return
     */
    @Override
    public List<StockDTO> findAllStock(SelectCriteria selectCriteria) {
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
        return inboundStockMapper.findAllStock(selectCriteria);
    }

    @Override
    public void inNewStock(InboundDTO newStock) {
        inboundStockMapper.inNewStock(newStock);
    }
}
