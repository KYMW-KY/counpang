package com.min.coupang.service;

import com.min.coupang.entity.Product;

public interface ProductService {
    public Product getProductById(Long id);
    public Product getProductByName(String productName);
    public Product getProductByCategoryId(String category);
    public void addProduct(Product product);
}
