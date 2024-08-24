package com.min.coupang.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    private Long productId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "product_status")
    private ProductStatus productStatus;

    @Column(name = "product_discount")
    private float productDiscount;

    @Column(name = "product_rating")
    private int productRating;

    @Builder
    public Product(String productName, String productCategory, ProductStatus productStatus, float productDiscount, int productRating) {
        this.name = productName;
        this.productCategory = productCategory;
        this.productStatus = productStatus;
        this.productDiscount = productDiscount;
        this.productRating = productRating;
    }
}
