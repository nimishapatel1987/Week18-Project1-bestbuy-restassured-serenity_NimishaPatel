package com.bestbuy.constants;

import java.net.URI;

/**
 * Created by Jay
 */
/**
 * This is Endpoints of Authentication api
 */
public class EndPoints {
    //This is Endpoints of PRODUCTS


//    public static final String GET_ALL_PRODUCTS = "/products";
//    public static final String GET_SINGLE_STUDENT_BY_ID = "/{studentID}";
//    public static final String UPDATE_STUDENT_BY_ID = "/{studentID}";
//    public static final String DELETE_STUDENT_BY_ID = "/{studentID}";

    //Store
    public static final String GET_ALL_STORE = "/store";
    public static final String DELETE_STORE_BY_ID = "/store/{id}";
    public static final String GET_SINGLE_STORE_BY_ID = "/store/{id}" ;
    public static final String UPDATE_STORE_BY_ID = "/store/{id}";
    public static final String POST_A_STORE = "/Store/{id}";

    //Product
    public static final String POST_ALL_PRODUCT = "/product";
    public static final String GET_ALL_PRODUCT = "/product";
    public static final String UPDATE_PRODUCT_BY_ID = "/product/{id}";
    public static final String DELETE_PRODUCT_BY_ID = "/product/{id}";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "product/{id}" ;
}
