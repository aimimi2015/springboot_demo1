package com.demo.Controller;

import com.demo.VO.ProductInfoVO;
import com.demo.VO.ProductVO;
//import com.demo.VO.ResultVO;
import com.demo.common.ResponseCode;
import com.demo.common.ServerResponse;
import com.demo.dataobject.ProductCategory;
import com.demo.dataobject.ProductInfo;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
//import com.demo.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 买家商品
 * Created by ${aimimi2015} on 2018/8/9.
 */
@RestController
@RequestMapping("/buyer/product")
@Api(description = "用户管理")
public class BuyerProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    @Autowired
    public BuyerProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @ApiOperation(value="获取商品详情列表", notes="获取详细信息")
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

                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);

                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);


        }


        return ServerResponse.createBySuccessMessage(ResponseCode.SUCCCESS.getDesc(),productVOList);


    }
}
