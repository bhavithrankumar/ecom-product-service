package com.ecom.product.service;

import com.ecom.product.constant.CommonConstant;
import com.ecom.product.dto.InsertRequestDto;
import com.ecom.product.dto.UpdateRequestDto;
import com.ecom.product.model.EcomProductModel;
import com.ecom.product.repository.EcomProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcomProductServiceImpl implements EcomProductService {

    @Autowired
    EcomProductDao ecomProductDao;

    public Object insertProduct(InsertRequestDto requestDto) {
        EcomProductModel ecomProductModel = EcomProductModel.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .quantityAvailable(requestDto.getQuantityAvailable())
                .build();
        return ecomProductDao.save(ecomProductModel);
    }

    public void updateProduct(UpdateRequestDto updateRequestDto) {
        Optional<EcomProductModel> optionalProduct = ecomProductDao.findById(updateRequestDto.getProductId());
        if (optionalProduct.isPresent()) {
            EcomProductModel product = optionalProduct.get();
            if (updateRequestDto.getName() != null) {
                product.setName(updateRequestDto.getName());
            }
            if (updateRequestDto.getDescription() != null) {
                product.setDescription(updateRequestDto.getDescription());
            }
            if (updateRequestDto.getPrice() != null) {
                product.setPrice(updateRequestDto.getPrice());
            }
            if (updateRequestDto.getQuantityAvailable() != null) {
                product.setQuantityAvailable(updateRequestDto.getQuantityAvailable());
            }
            ecomProductDao.save(product);
        } else {
            throw new IllegalArgumentException(CommonConstant.ERROR_ID + updateRequestDto.getProductId() + CommonConstant.NOT_FOUND);
        }
    }

    public Object fetchProduct(Long productId) {
        Optional<EcomProductModel> optionalProduct = ecomProductDao.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct;
        } else {
            throw new IllegalArgumentException(CommonConstant.ERROR_ID + productId + CommonConstant.NOT_FOUND);

        }
    }

    public void deleteProduct(Long productId) {
        if (ecomProductDao.existsById(productId)) {
            ecomProductDao.deleteById(productId);
        } else {
            throw new IllegalArgumentException(CommonConstant.ERROR_ID + productId + CommonConstant.NOT_FOUND);
        }
    }

    public Object updateTaxAndDiscount(UpdateRequestDto updateRequestDto) {
        EcomProductModel ecomProductModel;
        Optional<EcomProductModel> optionalProduct = ecomProductDao.findById(updateRequestDto.getProductId());
        if (optionalProduct.isPresent()) {
            ecomProductModel = optionalProduct.get();
            if (updateRequestDto.getPercentage() == null || updateRequestDto.getPercentage() <= 0 || updateRequestDto.getPercentage() > 100) {
                throw new IllegalArgumentException(CommonConstant.INVALID_PERCENTAGE + updateRequestDto.getPercentage());
            }
            switch (updateRequestDto.getType()) {
                case CommonConstant.TAX:
                    return this.taxUpdate(ecomProductModel, updateRequestDto.getPercentage());
                case CommonConstant.DISCOUNT:
                    return this.discountUpdate(ecomProductModel, updateRequestDto.getPercentage());
                default:
                    throw new IllegalArgumentException(CommonConstant.INVALID_TYPE + updateRequestDto.getType() + CommonConstant.NOT_FOUND);
            }
        } else {
            throw new IllegalArgumentException(CommonConstant.ERROR_ID + updateRequestDto.getProductId() + CommonConstant.NOT_FOUND);

        }
    }

    private EcomProductModel taxUpdate(EcomProductModel ecomProductModel, Double tax) {
        ecomProductModel.setPrice(Double.parseDouble(String.format("%.2f", ecomProductModel.getPrice() + (ecomProductModel.getPrice() * (tax / 100)))));
        return ecomProductDao.save(ecomProductModel);
    }

    private EcomProductModel discountUpdate(EcomProductModel ecomProductModel, Double discount) {
        ecomProductModel.setPrice(Double.parseDouble(String.format("%.2f", ecomProductModel.getPrice() - (ecomProductModel.getPrice() * (discount / 100)))));
        return ecomProductDao.save(ecomProductModel);
    }
}
