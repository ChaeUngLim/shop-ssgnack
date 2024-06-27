package com.ssgnack.product.controller;

import com.ssgnack.product.model.service.FileUploadService;
import com.ssgnack.product.model.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ftp")
@Slf4j
public class FileUploadController {

    private final FileUploadService fileUploadService;
    private final ProductService productService;

    public FileUploadController(FileUploadService fileUploadService, ProductService productService) {
        this.fileUploadService = fileUploadService;
        this.productService = productService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();
        log.info("🔥🔥 로깅 🔥🔥");
        String fileName = "default.jpg";
        try {
            fileName = fileUploadService.upload(file);
            response.put("msg", "File uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            response.put("msg", "File upload failed!");
        }

        productService.fileNameUpdate(fileName);

        return ResponseEntity.ok(response);
    }
}
