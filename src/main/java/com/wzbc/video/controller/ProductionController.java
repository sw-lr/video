package com.wzbc.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.api.CommonResult;
import com.wzbc.video.entity.Production;
import com.wzbc.video.entity.User;
import com.wzbc.video.service.ProductionDetailsService;
import com.wzbc.video.service.ProductionService;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    public ProductionService productionService;
    @Autowired
    public ProductionDetailsService productionDetailsService;
    @Autowired
    public UserService userService;
    @Autowired
    public TokenUtil tokenUtil;

    @GetMapping("/updateJudge")
    public CommonResult updateJudge(@RequestParam(value = "id")Long id,@RequestParam(value = "production")Long production){
        int productions=productionService.updateJudge(id,production);
        return CommonResult.success("修改成功");
    }

    @GetMapping("/list")
    public CommonResult getList(@RequestParam(value="name")String name,@RequestParam(value="current")int current,@RequestParam(value="size")int size){
        Page<Production>page=new Page<>(current,size);
        return CommonResult.success(productionService.getList(page,name));
    }

    @GetMapping("/details")
    public CommonResult detailsList(@RequestParam(value = "id") Long id){
        return CommonResult.success(productionDetailsService.list(id));
    }

    @GetMapping("/deleteProduction")
    public CommonResult deleteProduction(@RequestParam(value = "id")Long id){
        int production=productionService.deleteProduction(id);
        int details=productionDetailsService.deleteDetails(id);
        return CommonResult.success("删除成功");
    }

    @GetMapping("/judgeList")
    public CommonResult judgeList(){
        return CommonResult.success(userService.judgeList());
    }


    @GetMapping("/judge")
    public CommonResult judge(@RequestParam(value = "id")Long id,@RequestParam(value = "level")String level,@RequestParam(value = "content")String content,@RequestParam(value="design") String design,@RequestParam(value="specification")String specification,@RequestParam(value = "innovation")String innovation){
        int details=productionDetailsService.judge(id,level,content,design,specification,innovation);
        int judges=productionService.judge(id);
        return CommonResult.success("操作成功");
    }

    @GetMapping("/waitJudge")
    public CommonResult waitJudge(@RequestParam(value = "token")String token,@RequestParam(value = "name")String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
        Long userId=Long.parseLong(tokenUtil.getToken(token));
        List<User>user=userService.info(userId);

        if(user.get(0).getRoles().equals("judge")){
            Page<Production>page=new Page<>(current,size);
            return CommonResult.success(productionService.waitJudge(page,name,String.valueOf(userId)));
        }
        return CommonResult.failed("没有权限访问");
    }
}
