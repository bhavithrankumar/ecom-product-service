package com.ecom.product.service;

import com.ecom.product.dto.InsertRequestDto;
import com.ecom.product.dto.UpdateRequestDto;

public interface EcomProductService {
    Object insertProduct(InsertRequestDto requestDto);

    void updateProduct(UpdateRequestDto updateRequestDto);

    Object fetchProduct(Long productId);
    Object fetchProductV2(String name);

    void deleteProduct(Long productId);
    Object updateTaxAndDiscount(UpdateRequestDto updateRequestDto);
}

