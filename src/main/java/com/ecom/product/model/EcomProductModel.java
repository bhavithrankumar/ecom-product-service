package com.ecom.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product_details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EcomProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String name;
    private String description;
    private double price;
    private int quantityAvailable;
}
