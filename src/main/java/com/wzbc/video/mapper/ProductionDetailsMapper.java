package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzbc.video.entity.ProductionDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductionDetailsMapper extends BaseMapper<ProductionDetails> {
    List<ProductionDetails> listProductionDetails(Long id);

    int deleteDetails(Long id);

    int judge(Long id,String level,String content,String design,String specification,String innovation);
}
