package com.ecom.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateRequestDto {
    @NotNull(message = "Product Id Should Not Be Null")
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private Integer quantityAvailable;
    //possible values tax,discount
    private String type;
    private Double percentage;
}
