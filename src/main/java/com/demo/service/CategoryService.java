package com.demo.service;

import com.demo.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}

