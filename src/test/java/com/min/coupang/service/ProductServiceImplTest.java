package com.min.coupang.service;

import com.min.coupang.entity.Product;
import com.min.coupang.entity.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductServiceImplTest {
    private ProductService productService;
    @Autowired
    public ProductServiceImplTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
    @Transactional
    void addProduct() {
        Product product = Product.builder().name("상품")
                .productCategory("카테고리")
                .productRating(1)
                .productDiscount(0.5f)
                .productStatus(ProductStatus.ROCKET_DELIVERY)
                .build()
                ;
        productService.addProduct(product);

        Product productById = productService.getProductById(4L);
        System.out.println("productById = " + productById);
    }
}