package com.Demo.service;

import com.Demo.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */
public interface ProductService {

    ProductInfo findOne(String productId);


//
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);

//    加库存
//    减库存


}
