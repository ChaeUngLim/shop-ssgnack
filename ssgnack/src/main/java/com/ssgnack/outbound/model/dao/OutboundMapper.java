package com.ssgnack.outbound.model.dao;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import com.ssgnack.outbound.model.dto.OutboundDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OutboundMapper {
    int selectTotalCount();

    List<OutboundDTO> findAllOrder(SelectCriteria selectCriteria);

    void registNewOrder(StockDTO outStock);

    void updateStatus(OutboundDTO newOrder);

    OutboundDTO selectOutbound(OutboundDTO newOrder);

    int selectTotalCountByStatus(@Param("status") String status);

    List<OutboundDTO> findOrderByStatus(@Param("status") String status, @Param("selectCriteria") SelectCriteria selectCriteria);
}
