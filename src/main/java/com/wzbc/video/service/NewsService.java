package com.wzbc.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.News;

import java.util.List;

public interface NewsService extends IService<News> {
    IPage<News> list(Page<News> page,String name);
    IPage<News> schoolList(Page<News>page,String name,String school);
    int addNew(Long id,String school,String name);
    int deleteNew(Long id);
    int updateNew(Long id,String name);
}
