package com.ecom.product.controller;

import com.ecom.product.constant.CommonConstant;
import com.ecom.product.dto.InsertRequestDto;
import com.ecom.product.dto.ResponseMessage;
import com.ecom.product.dto.UpdateRequestDto;
import com.ecom.product.repository.EcomProductDao;
import com.ecom.product.service.EcomProductService;
import com.ecom.product.utils.AppResponseUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecom/product/")
@Slf4j
public class EcomProductController {

    @Autowired
    EcomProductDao ecomProductDao;
    @Autowired
    EcomProductService ecomProductService;

    @PostMapping("insert")
    public ResponseEntity<ResponseMessage> insert (@Valid @RequestBody InsertRequestDto insertRequestDto){
        Object responseDetails;
        try {
            responseDetails = ecomProductService.insertProduct(insertRequestDto);
          return ResponseEntity.status(HttpStatus.OK).body(AppResponseUtils.successResponse(responseDetails));
        } catch (Exception e){
            log.error("Exception while Insert :: ",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppResponseUtils.failureResponse(CommonConstant.ERRORCODE, CommonConstant.ERRORMSG, e.getMessage()));
        }
    }
    @PutMapping("update")
    public ResponseEntity<ResponseMessage> update (@Valid @RequestBody UpdateRequestDto updateRequestDto){
        try {
            ecomProductService.updateProduct(updateRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body(AppResponseUtils.successResponse("Success"));
        }catch (Exception e){
            log.error("Exception while Insert :: ",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppResponseUtils.failureResponse(CommonConstant.ERRORCODE, CommonConstant.ERRORMSG, e.getMessage()));
        }
    }
    @GetMapping("fetch")
    public ResponseEntity<ResponseMessage> fetch (@RequestParam("productId") Long productId){
        Object responseDetails;
        try {
            responseDetails = ecomProductService.fetchProduct(productId);
            return ResponseEntity.status(HttpStatus.OK).body(AppResponseUtils.successResponse(responseDetails));
        } catch (Exception e){
            log.error("Exception while Insert :: ",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppResponseUtils.failureResponse(CommonConstant.ERRORCODE, CommonConstant.ERRORMSG, e.getMessage()));
        }
    }
}
