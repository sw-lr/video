package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.Production;
import com.wzbc.video.mapper.ProductionMapper;
import com.wzbc.video.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductionServiceImpl extends ServiceImpl<ProductionMapper, Production> implements ProductionService {
    @Autowired
    public ProductionMapper productionMapper;

    @Override
    public IPage<Production> getList(Page<Production>page,String name) {
        return productionMapper.listProduction(page,name);
    }

    @Override
    public IPage<Production> waitJudge(Page<Production> page, String name, String judge) {
        return productionMapper.waitJudge(page,name,judge);
    }

    @Override
    public int deleteProduction(Long id) {
        return productionMapper.deleteProduction(id);
    }

    @Override
    public int updateJudge(Long id, Long production) {
        return productionMapper.updateJudge(id,production);
    }

    @Override
    public int judge(Long id) {
        return productionMapper.judge(id);
    }
}
