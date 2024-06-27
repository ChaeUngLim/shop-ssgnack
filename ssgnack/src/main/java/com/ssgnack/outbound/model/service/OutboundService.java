package com.ssgnack.outbound.model.service;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.outbound.model.dto.OutboundDTO;

import java.util.List;

public interface OutboundService {
    int selectTotalCount();

    List<OutboundDTO> findAllOrder(SelectCriteria selectCriteria);

    void registNewOrder(OutboundDTO newOrder);

    int selectTotalCountByStatus(String status);

    List<OutboundDTO> findOrderByStatus(String status, SelectCriteria selectCriteria);
}
