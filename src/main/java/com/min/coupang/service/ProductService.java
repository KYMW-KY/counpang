package com.min.coupang.service;

import com.min.coupang.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id);
    public Product getProductByName(String productName);
    public List<Product> getProductByCategoryId(String category);
    public void addProduct(Product product);
}
