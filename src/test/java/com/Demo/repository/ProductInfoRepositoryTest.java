package com.Demo.repository;

import com.Demo.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(36.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("asd");
        productInfo.setProductIcon("http://asd.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);

        ProductInfo result =repository.save(productInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfolist = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfolist.size());

    }

}