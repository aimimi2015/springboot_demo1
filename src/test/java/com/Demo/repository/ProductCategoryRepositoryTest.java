package com.Demo.repository;

import com.Demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.ls.LSInput;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ${aimimi2015} on 2018/8/8.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {

        ProductCategory productCategory = repository.findOne(1);


    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女神最爱", 3);
//            System.out.println(productCategory.toString());
//            productCategory.setCategoryType(3);
//            productCategory.setCategoryId(2);
//
//            productCategory.setCategoryName("男生最爱");
//            productCategory.setCategoryType(3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);


    }

    @Test
    public void findByCategoryTypeTest() {
        List<Integer> list = Arrays.asList(3, 70);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }


}