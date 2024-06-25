package com.ssgnack.report.controller;

import com.ssgnack.report.model.dto.ReportDTO;
import com.ssgnack.report.model.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    /***
     * 메인페이지
     */
    @GetMapping("")
    public String firstPage(){
        return "common/fragment/main";
    }

    /***
     * MENU버튼 메인페이지 이동
     */
    @GetMapping("/main")
    public String mainPage(){
        return "common/fragment/main";
    }

    /***
     * 상품별 페이지로 이동
     */
    @GetMapping("/productgraph")
    public String productgraphPage(){
        return "common/fragment/productGraph";
    }

    /***
     * 브랜드별 페이지로 이동
     */
    @GetMapping("/brandgraph")
    public String brandgraphPage(){
        return "common/fragment/brandGraph";
    }

    /***
     * 기간별 페이지로 이동
     */
    @GetMapping("/monthlygraph")
    public String monthlygraphPage(){
        return "common/fragment/monthlyGraph";
    }

    @GetMapping("/totalSales")
    public String totalSales(Model model){
        List<ReportDTO> reportList = reportService.totalSales();
        for (ReportDTO reportDTO : reportList) {
            System.out.println("reportDTO.getPrice() = " + reportDTO.getPrice());
        }
        log.info("Total sales report: {}", reportList);
        model.addAttribute("reportList", reportList);
        return "common/fragment/main";
    }

}
