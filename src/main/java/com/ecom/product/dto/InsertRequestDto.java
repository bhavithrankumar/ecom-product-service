package com.ecom.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertRequestDto {
    @NotNull(message = "Name should not be null")
    private String name;
    @NotNull(message = "Description should not be null")
    private String description;
    @NotNull(message = "Price should not be null")
    private Double price;
    @NotNull(message = "Quantity Available should not be null")
    private Integer quantityAvailable;
}
