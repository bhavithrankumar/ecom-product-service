package com.ecom.product.utils;

import com.ecom.product.constant.CommonConstant;
import com.ecom.product.dto.ResponseMessage;

import java.util.HashMap;
import java.util.Map;

public class AppResponseUtils {
    public static ResponseMessage successResponse(Object response) {
        ResponseMessage message = new ResponseMessage("Success", CommonConstant.SUCCESSCODE);
        Map<Object, Object> responseMap = new HashMap<>();
        responseMap.put("response", response);
        message.setResponseMap(responseMap);
        return message;
    }


    public static ResponseMessage failureResponse(String errCode, String errMsg, Object response) {
        ResponseMessage message = new ResponseMessage(errMsg,errCode);
        Map<Object, Object> responseMap = new HashMap<>();
        responseMap.put("response", response);
        message.setResponseMap(responseMap);
        return message;
    }
}
