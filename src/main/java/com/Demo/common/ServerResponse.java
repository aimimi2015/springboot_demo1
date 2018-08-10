package com.Demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by ${aimimi2015} on 2018/8/9.
 */
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    @JsonIgnore  //因为是public所以如果json序列化的时候也会和status;msg;data;一起显示到前端.使之不在json序列化中
//    如果没有的话前端会有一个success:true
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCCESS.getCode();

    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    //成功的响应
    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCCESS.getCode(), data);
    }
    //这里如果传过来一个string如何区分是data还是string呢，通过creatBySuccessMessage(String msg)和creatBySuccess(T data)区分


    public static <T> ServerResponse<T> createBySuccessMessage(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCCESS.getCode(), msg, data);
    }

    //失败的响应
    public static <T> ServerResponse<T> creatByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());

    }
    public static <T> ServerResponse<T> creatByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);

    }



}

