package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper extends BaseMapper<News> {

    IPage<News> listNews(Page<News>page,String name);

    IPage<News> schoolListNews(Page<News>page,String name,String school);

    int addNew(Long id, String school, String name);

    int deleteNew(Long id);

    int updateNew(Long id,String name);
}
