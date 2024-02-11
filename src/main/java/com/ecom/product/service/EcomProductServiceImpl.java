package com.ecom.product.service;

import com.ecom.product.dto.RequestDto;
import com.ecom.product.model.EcomProductModel;
import com.ecom.product.repository.EcomProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcomProductServiceImpl implements EcomProductService{

    @Autowired
    EcomProductDao ecomProductDao;

    @Override
    public Object insertProduct(RequestDto requestDto) {
        EcomProductModel ecomProductModel = EcomProductModel.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .quantityAvailable(requestDto.getQuantityAvailable())
                .build();
      return ecomProductDao.save(ecomProductModel);
    }
}
