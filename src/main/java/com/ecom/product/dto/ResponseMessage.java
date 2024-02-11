package com.ecom.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseMessage {
    private String respMsg;
    private String respcode;
    private Map<Object, Object> responseMap;

    public ResponseMessage(String respMsg, String respcode) {
        this.respMsg = respMsg;
        this.respcode = respcode;
    }

    @Override
    public String toString() {
        return "ResponseMessage [respMsg=" + respMsg + ", respcode=" + respcode + ", responseMap=" + responseMap + "]";
    }

    public ResponseMessage() {

    }
}
