package com.ssgnack.inboundStock.model.service;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dao.InboundStockMapper;
import com.ssgnack.inboundStock.model.dto.InboundDTO;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
public class InboundStockServiceImpl implements InboundStockService {

    private final InboundStockMapper inboundStockMapper;

    public InboundStockServiceImpl(InboundStockMapper inboundStockMapper) {
        this.inboundStockMapper = inboundStockMapper;
    }

    // 페이징
    @Override
    public int selectTotalCount() {
        return inboundStockMapper.selectTotalCount();
    }

    /***
     * 재고 조회
     * @param selectCriteria
     * @return
     */
    @Override
    public List<StockDTO> findAllStock(SelectCriteria selectCriteria) {
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
        return inboundStockMapper.findAllStock(selectCriteria);
    }

    // 입고 처리

    @Override
    @Transactional
    public void inNewStock(StockDTO newStock) {

        // 1. 입고
        log.info("🐰🐰🐰🐰🐰 {} 🐰🐰🐰🐰🐰", newStock);
        newStock.setWarehouseId(1);
        inboundStockMapper.inNewStock(newStock);

        // 2. 방금 생성된 입고 내역의 ID 가져오기
//        int inboundId = inboundStockMapper.getLastInsertId();
        int adminId = 1;

        // 3. 입고 내역 생성
        InboundDTO history = new InboundDTO();
//        history.setInboundId(inboundId);
        history.setProductId(newStock.getProductId());
        history.setInAmt(newStock.getStockAmt());
        history.setAdminId(adminId);
        history.setInDate(new Timestamp(System.currentTimeMillis()));

        inboundStockMapper.insertInboundHistory(history);
    }

//    @Override
//    public List<StockDTO> selectStockList(String productName) {
//        return inboundStockMapper.selectStockList(productName);
//    }


    @Override
    public int countStockByProductName(int productId) {
        return inboundStockMapper.countStockByProductName(productId);
    }

    @Override
    public List<StockDTO> searchStockByProductName(SelectCriteria selectCriteria, int productId) {
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
        return inboundStockMapper.searchStockByProductName(selectCriteria, productId);

    }
}




