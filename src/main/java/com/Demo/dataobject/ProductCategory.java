package com.Demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ${aimimi2015} on 2018/8/8.
 */

//@Table(name = "product_category")
@Entity
@DynamicUpdate  //动态更新，可以使更新时间updateTime显示正确@DynamicUpdate
@Data   //可以帮助生成getset和tostring
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }




}

