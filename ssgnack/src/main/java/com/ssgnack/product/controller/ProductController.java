package com.ssgnack.product.controller;

import com.ssgnack.product.model.dto.CategoryDTO;
import com.ssgnack.product.model.dto.CompanyDTO;
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
    public String insertPage(Model model) {

        List<CategoryDTO> categoryList = new ArrayList<>();
        categoryList = productService.selectCategoryList();

        log.info("⭐️⭐️⭐️[ProductController] categoryList: {}⭐️⭐️⭐️", categoryList);

        model.addAttribute("categoryList", categoryList);

        return "product/insert";
    }

    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<Map<String, String>> productInsert(@RequestBody ProductDTO productDTO, Model model) {

        Map<String, String> response = new HashMap<>();
//        log.info("⭐️⭐️⭐️[ProductController] productList: {}⭐️⭐️⭐️", productDTO);
//        boolean insertStatus = false;
        int insertStatus = productService.insertProduct(productDTO);

        response = setResponse(response, insertStatus);

//        log.info("⭐️⭐️⭐️[ProductController] Insert Status : " + response + "⭐️⭐️⭐️");

        return ResponseEntity.ok(response);
    }

    @GetMapping("update")
    public String updatePage(Model model) {

        List<ProductDTO> productList = productService.selectProductList("");
        List<CategoryDTO> categoryList = productService.selectCategoryList();
        List<CompanyDTO> companyList = productService.selectCompanyList();

        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("companyList", companyList);

        return "product/update";
    }

    @PostMapping("update")
    public ResponseEntity<Map<String, String>> productUpdate(@RequestBody ProductDTO productDTO, Model model) {
        Map<String, String> response = new HashMap<>();

        log.info("⭐️⭐️⭐️[ProductController] productDTO: {}⭐️⭐️⭐️", productDTO);

        int updateStatus = productService.updateProduct(productDTO);

        response = setResponse(response, updateStatus);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/delete")
    public String deletePage(Model model, @RequestParam(defaultValue = "") String productName) {

        List<ProductDTO> productList = productService.selectProductList("");

        model.addAttribute("productList", productList);

        return "product/delete";
    }

    @PostMapping("/delete")
    public ResponseEntity<Map<String, String>> deleteProduct(@RequestBody String productId, Model model) {
        Map<String, String> response = new HashMap<>();

        log.info("⭐️⭐️⭐️[ProductController] productId: {}⭐️⭐️⭐️", productId);

        int deleteStatus = productService.deleteProduct(Integer.parseInt(productId));

        response = setResponse(response, deleteStatus);

        return ResponseEntity.ok(response);
    }

    public Map<String, String> setResponse(Map<String, String> response, int serviceCode) {

        switch (serviceCode) {
            case 0:
                response.put("msg", "상품 등록 성공했습니다.");
                response.put("returnURL", "/product/main");
                break;
            case 1:
                response.put("msg", "상품 등록 실패했습니다 !! ");
                response.put("returnURL", "/product/main");
                break;
            case 2:
                response.put("msg", "중복된 상품이 존재하여 상품 등록 실패했습니다.");
                response.put("returnURL", "/product/main");
                break;
            case 3:
                response.put("msg", "상품정보 갱신 실패했습니다.");
                response.put("returnURL", "/product/main");
                break;
            case 4:
                response.put("msg", "Product delete failed !!");
                response.put("returnURL", "/product/main");
                break;
            case 5:
                response.put("msg", "판매 기록이 있거나 재고가 남은 물건이므로 삭제 불가능합니다 !!");
                response.put("returnURL", "/product/main");
                break;
            default:
                response.put("msg", "<<ERROR>> 알 수 없는 에러가 발생했습니다 !! ");
                response.put("returnURL", "/product/main");
                break;
        }

        return response;
    }
}
