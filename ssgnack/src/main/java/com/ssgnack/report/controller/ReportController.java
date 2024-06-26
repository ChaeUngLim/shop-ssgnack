package com.ssgnack.report.controller;

import com.ssgnack.report.model.dto.ReportDTO;
import com.ssgnack.report.model.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /***
     * 전체 매출 현황
     */
    @GetMapping("/totalSales")
    public String totalSales(Model model){
        List<ReportDTO> reportList = reportService.totalSales();
        for (ReportDTO reportDTO : reportList) {
            System.out.println("reportDTO.getTotalSales/getTotalMonth = " + reportDTO.getTotalSale() + "/" + reportDTO.getTotalMonth());
        }
        log.info("Total sales report: {}", reportList);
        model.addAttribute("reportList", reportList);
        return "common/fragment/main";
    }

    /***
     * 상품별 매출 현황
     */
    @GetMapping("/productSales")
    public String productSales(Model model, @RequestParam(required = false) String productName){
        log.info("productName {}", productName);
        List<ReportDTO> reportList = reportService.productSales(productName);
        for (ReportDTO reportDTO : reportList) {
            System.out.println("reportDTO.getTotalMonth() + \"/\" +reportDTO.getTotalSale() = " + reportDTO.getTotalMonth() + "/" +reportDTO.getTotalSale());
        }
        model.addAttribute("reportList", reportList);
        return "common/fragment/productGraph";
    }

    /***
     * 브랜드별 매출 현황
     */
    @GetMapping("/brandSales")
    public String brandSales(Model model, @RequestParam(required = false) String companyName){
        log.info("brandName {}", companyName);
        List<ReportDTO> reportList = reportService.brandSales(companyName);
        for (ReportDTO reportDTO : reportList) {
            System.out.println("reportDTO.getProductName() + \"/\" +reportDTO.getTotalSale() = " + reportDTO.getProductName() + "/" +reportDTO.getTotalSale());
        }
        model.addAttribute("reportList", reportList);
        return "common/fragment/brandGraph";
    }
}
