package com.Demo.common;

import lombok.Getter;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
