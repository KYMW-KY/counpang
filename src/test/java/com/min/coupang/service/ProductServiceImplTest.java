package com.min.coupang.service;

import com.min.coupang.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceImplTest {
    private ProductService productService;
    @Autowired
    public ProductServiceImplTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    void addProduct() {
        Product product = new Product();
        productService.addProduct(product);
    }
}