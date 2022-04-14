package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.ProductionDetails;
import com.wzbc.video.mapper.ProductionDetailsMapper;
import com.wzbc.video.service.ProductionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionDetailsServiceImpl extends ServiceImpl<ProductionDetailsMapper, ProductionDetails> implements ProductionDetailsService {
    @Autowired
    public ProductionDetailsMapper productionDetailsMapper;

    @Override
    public List<ProductionDetails> list(Long id) {
        return productionDetailsMapper.listProductionDetails(id);
    }
}
