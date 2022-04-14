package com.wzbc.video.controller;

import com.wzbc.video.api.CommonResult;
import com.wzbc.video.params.LoginParams;
import com.wzbc.video.params.TokenParams;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    public UserService userService;
    @Autowired
    public TokenUtil tokenUtil;

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginParams loginParams,HttpServletRequest request){
        if(userService.validateUsername(loginParams.username)==0){
            return CommonResult.failed("没有该用户");
        }
        Long uid = userService.validateLogin(loginParams.username, loginParams.password,loginParams.code,request);
        if (uid.equals(0L)) {
            return CommonResult.failed("密码错误");
        }
        String token=tokenUtil.createToken(String.valueOf(uid));
//        System.out.println(tokenUtil.getToken(token));
        return CommonResult.success(token);
    }

    @PostMapping("/backgroundLogin")
    public CommonResult backgroundLogin(@RequestBody LoginParams loginParams){
//        System.out.println(loginParams.username+loginParams.password);
        Long uid = userService.validateBackgroundLogin(loginParams.username, loginParams.password);
        if (uid.equals(0L)) {
            return CommonResult.failed("密码错误");
        }
        String token=tokenUtil.createToken(String.valueOf(uid));
        return CommonResult.success(token);
    }

    @PostMapping("/loginout")
    public CommonResult loginOut(@RequestBody TokenParams token){
        if(!tokenUtil.removeToken(token.getToken())){
            return CommonResult.failed("bad");
        }
        return CommonResult.success("退出成功");
    }
}
