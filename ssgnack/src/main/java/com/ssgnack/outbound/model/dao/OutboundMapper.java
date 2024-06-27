package com.ssgnack.outbound.model.dao;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.outbound.model.dto.OutboundDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutboundMapper {
    int selectTotalCount();

    List<OutboundDTO> findAllOrder(SelectCriteria selectCriteria);
}
