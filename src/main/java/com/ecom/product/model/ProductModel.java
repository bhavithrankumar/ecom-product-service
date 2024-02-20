package com.ecom.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "view_product_details")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private String description;
    private Double price;
    @Column(name = "quantity_available")
    private Integer quantityAvailable;
}
