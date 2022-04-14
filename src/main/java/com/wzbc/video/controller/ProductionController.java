package com.wzbc.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.api.CommonResult;
import com.wzbc.video.entity.Production;
import com.wzbc.video.service.ProductionDetailsService;
import com.wzbc.video.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    public ProductionService productionService;
    @Autowired
    public ProductionDetailsService productionDetailsService;

    @GetMapping("/list")
    public CommonResult getList(@RequestParam(value="name")String name,@RequestParam(value="current")int current,@RequestParam(value="size")int size){
        Page<Production>page=new Page<>(current,size);
        return CommonResult.success(productionService.getList(page,name));
    }

    @GetMapping("/details")
    public CommonResult detailsList(@RequestParam(value = "id") Long id){
        return CommonResult.success(productionDetailsService.list(id));
    }
}
