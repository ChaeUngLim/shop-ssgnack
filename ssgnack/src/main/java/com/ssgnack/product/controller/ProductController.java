package com.ssgnack.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/main")
    public String productMain(Model model) {
        return "product/main";
    }



}
