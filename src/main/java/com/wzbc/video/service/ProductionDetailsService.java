package com.wzbc.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.ProductionDetails;

import java.util.List;

public interface ProductionDetailsService extends IService<ProductionDetails> {
    List<ProductionDetails> list(Long id);
    int deleteDetails(Long id);
    int judge(Long id,String level,String content,String design,String specification,String innovation);
}
