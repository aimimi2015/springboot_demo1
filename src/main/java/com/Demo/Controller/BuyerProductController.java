package com.Demo.Controller;

import com.Demo.VO.ProductInfoVO;
import com.Demo.VO.ProductVO;
import com.Demo.VO.ResultVO;
import com.Demo.common.ResponseCode;
import com.Demo.common.ServerResponse;
import com.Demo.dataobject.ProductCategory;
import com.Demo.dataobject.ProductInfo;
import com.Demo.service.CategoryService;
import com.Demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 买家商品
 * Created by ${aimimi2015} on 2018/8/9.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list1")
    public ServerResponse list1() {
        return ServerResponse.creatByError();
    }


    @GetMapping("/list")
    public ServerResponse list() {

//        1查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
//        2 查询类目
        List<Integer> categoryTypeList = new ArrayList<>();

        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

//        shujupinzhuang

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();

            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    productInfoVO.setProductDecription();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);


        }


        return ServerResponse.createBySuccessMessage(ResponseCode.SUCCCESS.getDesc(),productVOList);


    }
}
