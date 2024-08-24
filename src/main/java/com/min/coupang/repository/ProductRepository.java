package com.min.coupang.repository;

import com.min.coupang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);
    public Product findProductsByProductCategory(String productCategory);
}
