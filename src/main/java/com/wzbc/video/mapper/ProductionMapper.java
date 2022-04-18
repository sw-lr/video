package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.entity.Production;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProductionMapper extends BaseMapper<Production> {
    IPage<Production> listProduction(Page<Production>page,String name);
    int deleteProduction(Long id);
    int updateJudge(Long id,Long production);
    int judge(Long id);
    IPage<Production>waitJudge(Page<Production>page,String name,String judge);
}
