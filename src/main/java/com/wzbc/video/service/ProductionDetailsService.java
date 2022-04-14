package com.wzbc.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.ProductionDetails;

import java.util.List;

public interface ProductionDetailsService extends IService<ProductionDetails> {
    List<ProductionDetails> list(Long id);
}
