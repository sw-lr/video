package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzbc.video.entity.NewsDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsDetailsMapper extends BaseMapper<NewsDetails> {
    List<NewsDetails> listNewsDeatils(Long id);
    int addDetails(Long id,String url,String parentName,String name,int num,String type);
    int deleteDetails(Long id);
}
