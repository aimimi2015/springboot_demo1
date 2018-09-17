package com.demo.repository;

import com.demo.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo ,String>{   //泛型中，第二个是第一个类中主键的类型

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
