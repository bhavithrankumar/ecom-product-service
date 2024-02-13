package com.ecom.product.constant;

public class CommonConstant {
    public static final String SUCCESS = "Success";
    public static final String MYSQL_DATASOURCE = "mysql.datasource";
    public static final String MYSQL_DRIVER = "${mysql.datasource.driver-class-name}";
    public static final String MYSQL_PASSWORD = "${mysql.datasource.password}";
    public static final String MYSQL_USERNAME = "${mysql.datasource.username}";
    public static final String MYSQL_URL = "${mysql.datasource.url}";
    public static final String SUCCESS_CODE = "00";
    public static final String ERROR_CODE = "500";
    public static final String ERROR_MSG = "Opps! something went wrong";
    public static final String EXCEPTION = "Exception :: ";
    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String PRICE_UPDATE = "price/update";
    public static final String FETCH = "fetch";
    public static final String DELETE = "delete";
    public static final String PRODUCT_ID = "productId";
    public static final String REQUEST_MAPPING = "/ecom/product/";
    public static final String ERROR_ID = "Product with ID ";
    public static final String NOT_FOUND = " not found";
    public static final String INVALID_TYPE = "Type ";
    public static final String INVALID_PERCENTAGE = "Invalid Percentage ";
    public static final String DISCOUNT = "discount";
    public static final String TAX = "tax";
}
