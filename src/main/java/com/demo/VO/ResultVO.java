package com.demo.VO;

import lombok.Data;

/**
 * http返回对象
 * Created by ${aimimi2015} on 2018/8/9.
 */
@Data
public class ResultVO<T> {


    private T data;
}

