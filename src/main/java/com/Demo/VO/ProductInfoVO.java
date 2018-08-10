package com.Demo.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by ${aimimi2015} on 2018/8/10.
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private Integer productId;

    @JsonProperty("name")
    private String productType;
    @JsonProperty("price")
    private Integer productPrice;

    @JsonProperty("decription")
    private String productDecription;

    @JsonProperty("icon")
    private Integer productIcon;

}

