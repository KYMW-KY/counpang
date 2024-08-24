package com.min.coupang.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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

}
