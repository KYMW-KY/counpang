package com.min.coupang.service;

import com.min.coupang.entity.Product;
import com.min.coupang.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Override
    public Product getProductByCategoryId(String category) {
        return productRepository.findProductsByProductCategory(category);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
