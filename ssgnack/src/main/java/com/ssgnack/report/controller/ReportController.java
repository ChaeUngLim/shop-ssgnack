package com.ssgnack.report.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/productgraph")
    public String productgraphPage(){
        return "common/fragment/productGraph";
    }

    @GetMapping("/brandgraph")
    public String brandgraphPage(){
        return "common/fragment/brandGraph";
    }

    @GetMapping("/monthlygraph")
    public String monthlygraphPage(){
        return "common/fragment/monthlyGraph";
    }

}
