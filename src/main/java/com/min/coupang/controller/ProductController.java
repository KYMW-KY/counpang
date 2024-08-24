package com.min.coupang.controller;

import com.min.coupang.entity.Product;
import com.min.coupang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/{productName}")
    public Product getProductByName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }
    @GetMapping("/product/{productCategory}")
    public List<Product> getProductByCategory(@PathVariable String productCategory) {
        return productService.getProductByCategoryId(productCategory);
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        System.out.println("저장완료");
    }
}
