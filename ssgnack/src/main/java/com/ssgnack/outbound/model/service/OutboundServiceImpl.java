package com.ssgnack.outbound.model.service;

import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.outbound.model.dao.OutboundMapper;
import com.ssgnack.outbound.model.dto.OutboundDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OutboundServiceImpl implements OutboundService {

    private final OutboundMapper outboundMapper;

    public OutboundServiceImpl(OutboundMapper outboundMapper) {this.outboundMapper = outboundMapper;}

    /***
     * 총 게시글 수
     * @return
     */
    @Override
    public int selectTotalCount() {
        return outboundMapper.selectTotalCount();
    }

    /***
     * 페이징 처리
     * @param selectCriteria
     * @return
     */
    @Override
    public List<OutboundDTO> findAllOrder(SelectCriteria selectCriteria) {
        selectCriteria.setStartRow(selectCriteria.getStartRow() - 1);
        return outboundMapper.findAllOrder(selectCriteria);
    }
}
