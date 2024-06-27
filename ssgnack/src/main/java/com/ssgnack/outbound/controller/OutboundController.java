package com.ssgnack.outbound.controller;

import com.ssgnack.common.paging.Pagenation;
import com.ssgnack.common.paging.SelectCriteria;
import com.ssgnack.outbound.model.dto.OutboundDTO;
import com.ssgnack.outbound.model.service.OutboundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/outbound")
public class OutboundController {

    private final OutboundService outboundService;

    public OutboundController(OutboundService outboundService) {
        this.outboundService = outboundService;
    }

    // 주문서 조회
    @GetMapping("/order")
    public String findOrderList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int pageNo) {

        log.info("[OutboundController] pageNo: {}", pageNo);
        int totalCount = outboundService.selectTotalCount();
        log.info("[OutboundController] Total count: {}", totalCount);

        int limit = 10;

        int buttonAmount = 10;

        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);

        List<OutboundDTO> orderList = outboundService.findAllOrder(selectCriteria);
        log.info("[OutboundController] Order list: {}", orderList);
        model.addAttribute("orderList", orderList);
        model.addAttribute("selectCriteria", selectCriteria);

        return "outbound/order";
    }

    // 출고 처리
    @GetMapping("/regist")
    public String registPage() {
        return "outbound/outbound";
    }

    @PostMapping("/regist")
    public String registOrder(@ModelAttribute OutboundDTO newOrder
            , RedirectAttributes rttr, Model model) {

        outboundService.registNewOrder(newOrder);
        rttr.addFlashAttribute("successMessage", "출고가 완료되었습니다.");

        return "redirect:/outbound/order";
    }
}
