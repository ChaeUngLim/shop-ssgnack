package com.ssgnack.product.controller;

import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.ProductDTO;
import com.ssgnack.product.model.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String productMain(Model model, @RequestParam(defaultValue = "") String productName) {

        List<ProductDTO> productList = productService.selectProductList(productName);
//        log.info("⭐️⭐️⭐️[ProductController] productList: {}⭐️⭐️⭐️", productList);

        model.addAttribute("productList", productList);

        return "product/main";
    }

    @GetMapping("/insert")
    public String productInsertPage(Model model) {

        List<CategoryDTO> categoryList = new ArrayList<>();
        categoryList = productService.selectCategoryList();

        log.info("⭐️⭐️⭐️[ProductController] categoryList: {}⭐️⭐️⭐️", categoryList);

        model.addAttribute("categoryList", categoryList);

        return "product/insert";
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<Map<String, String>> productInsertPage(@RequestBody ProductDTO productDTO, Model model) {

        Map<String, String> response = new HashMap<>();
//        log.info("⭐️⭐️⭐️[ProductController] productList: {}⭐️⭐️⭐️", productDTO);
//        boolean insertStatus = false;
        int insertStatus = productService.insertProduct(productDTO);

        response = setResponse(response, insertStatus);

//        log.info("⭐️⭐️⭐️[ProductController] Insert Status : " + response + "⭐️⭐️⭐️");

        return ResponseEntity.ok(response);
    }

    @GetMapping("update")
    public String updatePage() {
        return "product/update";
    }

    public Map<String, String> setResponse(Map<String, String> response, int serviceCode) {

        switch (serviceCode){
            case 0:
                response.put("msg","Product inserted successfully !! ");
                response.put("returnURL","/product/main");
                break;
            case 1:
                response.put("msg","Product insert failed !! ");
                response.put("returnURL","/product/main");
                break;
            case 2:
                response.put("msg","Product duplicate insert failed");
                response.put("returnURL","/product/main");
                break;
            default:
                response.put("msg","<<ERROR>> Unknown service code !! ");
                response.put("returnURL","/product/main");
                break;
        }

        return response;
    }
}
