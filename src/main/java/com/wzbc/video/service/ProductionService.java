package com.wzbc.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.Production;

import java.util.List;

public interface ProductionService extends IService<Production> {
    IPage<Production> getList(Page<Production>page,String name);
    int deleteProduction(Long id);
    int updateJudge(Long id,Long production);
    int judge(Long id);
    IPage<Production> waitJudge(Page<Production>page,String name,String judge);
}
