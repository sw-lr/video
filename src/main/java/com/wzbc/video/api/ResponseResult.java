package com.wzbc.video.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {
    private Integer code;
    private String  message;
    private Object object;

    public static ResponseResult ok(String message){
        return new ResponseResult(200,message,null);
    }

    public static ResponseResult ok(String message, Object object){
        return new ResponseResult(200,message,object);
    }

    public static  ResponseResult error(String message){
        return new ResponseResult(500,message,null);
    }
    public static  ResponseResult error(String message, Object o){
        return new ResponseResult(500,message,o);
    }

}
