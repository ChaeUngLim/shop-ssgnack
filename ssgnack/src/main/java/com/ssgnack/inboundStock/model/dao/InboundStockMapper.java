package com.ssgnack.inboundStock.model.dao;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.InboundDTO;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InboundStockMapper {

    // 전체 재고 조회
    int selectTotalCount();

    // 선택 기준에 따른 모든 재고 조회
    List<StockDTO> findAllStock(SelectCriteria selectCriteria);

    /***
     * 입고 정보 데이터베이스에 삽입
     * 입고 정보 삽입 후 자동으로 생성된 키 값을 newStock rorcpdml inboundId 필드에 설정
     * @param newStock
     */
    void inNewStock(InboundDTO newStock);

    /***
     * 마지막으로 삽입된 레코드의 자동 생성된 키 값을 조회
     * @return
     */
    int getLastInsertId();
}
