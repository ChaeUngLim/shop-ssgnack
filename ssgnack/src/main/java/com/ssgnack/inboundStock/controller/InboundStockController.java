package com.ssgnack.inboundStock.controller;

import com.ssgnack.common.paging.Pagenation;
import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.inboundStock.model.dto.StockDTO;
import com.ssgnack.inboundStock.model.service.InboundStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/stock")
public class InboundStockController {

    private final InboundStockService inboundStockService;

    public InboundStockController(InboundStockService inboundStockService) {this.inboundStockService = inboundStockService;}

    @GetMapping("/list")
    public String findStockList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int pageNo) {

        int totalCount = inboundStockService.selectTotalCount();
        log.info("[InboundStockController] Total Count: {}", totalCount);

        int limit = 10;

        int buttonAmount = 10;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo,totalCount,limit,buttonAmount);

        List<StockDTO> stockList = inboundStockService.findAllStock(selectCriteria);
        log.info("[InboundStockController] Stock List: {}", stockList);
        model.addAttribute("stockList", stockList);
        model.addAttribute("selectCriteria", selectCriteria);

        return "inboundStock/stock";
    }
}
