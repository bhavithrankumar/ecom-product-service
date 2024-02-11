package com.ecom.product.controller;

import com.ecom.product.constant.CommonConstant;
import com.ecom.product.dto.RequestDto;
import com.ecom.product.repository.EcomProductDao;
import com.ecom.product.service.EcomProductService;
import com.ecom.product.utils.AppResponseUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecom/product/")
@Slf4j
public class EcomProductController {

    @Autowired
    EcomProductDao ecomProductDao;
    @Autowired
    EcomProductService ecomProductService;

    @PostMapping("insert")
    public ResponseEntity<Object> insert (@Valid @RequestBody RequestDto requestDto){
        Object responseDetails;
        try {
            responseDetails = ecomProductService.insertProduct(requestDto);
          return ResponseEntity.status(HttpStatus.OK).body(AppResponseUtils.successResponse(responseDetails));
        }catch (Exception e){
            log.error("Exception while Insert :: ",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppResponseUtils.failureResponse(CommonConstant.ERRORCODE, CommonConstant.ERRORMSG, ""));
        }
    }
}
