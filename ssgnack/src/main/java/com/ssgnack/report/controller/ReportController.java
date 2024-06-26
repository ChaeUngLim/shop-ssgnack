package com.ssgnack.report.controller;

import com.ssgnack.report.model.dto.ReportResDTO;
import com.ssgnack.report.model.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ReportController {

    @Autowired
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
    @GetMapping({"","/totalSales"})
    @ResponseBody
    public ReportResDTO totalSales(Model model){
        ReportResDTO reportDTOList = reportService.totalSales();
        System.out.println("reportDTOList.getTotalMonth() = " + reportDTOList.getTotalMonth());
        System.out.println("reportDTOList.getTotalSale() = " + reportDTOList.getTotalSale());
        System.out.println("reportDTOList.getTotalIncome() = " + reportDTOList.getTotalIncome());

        return reportDTOList;
    }

    /***
     * 상품별 매출 현황
     */
    @GetMapping("/productSales")
    @ResponseBody
    public ReportResDTO productSales(Model model, @RequestParam(required = false) String productName){
        log.info("productName {}", productName);
//        List<ReportDTO> reportList = reportService.productSales(productName);


//        for (ReportDTO reportDTO : reportList) {
//            System.out.println("reportDTO.getTotalMonth() + \"/\" +reportDTO.getTotalSale() = " + reportDTO.getTotalMonth() + "/" +reportDTO.getTotalSale());
//        }

        ReportResDTO reportDTOList = reportService.productSales(productName);
        System.out.println("reportDTOList.getTotalMonth() = " + reportDTOList.getTotalMonth());
        System.out.println("reportDTOList.getTotalSale() = " + reportDTOList.getTotalSale());
        System.out.println("reportDTOList.getTotalIncome() = " + reportDTOList.getTotalIncome());

//        model.addAttribute("reportList", reportList);
//         model.addAttribute("reportList", reportDTOList);
        return reportDTOList;
    }

    /***
     * 브랜드별 매출 현황
     */
    @GetMapping("/brandSales")
    @ResponseBody
    public ReportResDTO brandSales(Model model, @RequestParam(required = false) String companyName){
        log.info("companyName {}", companyName);
        ReportResDTO reportDTOList = reportService.brandSales(companyName);
        System.out.println("reportDTOList.getProductName() = " + reportDTOList.getProductName());
        System.out.println("reportDTOList.getTotalSale() = " + reportDTOList.getTotalSale());
        System.out.println("reportDTOList.getTotalIncome() = " + reportDTOList.getTotalIncome());

        return reportDTOList;
    }
}
