package com.ecom.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestDto {
    private String name;
    private String description;
    private double price;
    @NotNull
    private Integer quantityAvailable;
}
