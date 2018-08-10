package com.Demo.service.impl;

import com.Demo.common.ProductStatusEnum;
import com.Demo.dataobject.ProductInfo;
import com.Demo.repository.ProductInfoRepository;
import com.Demo.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {

        return repository.findOne(productId);

    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }



    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return  repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}

