package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.News;
import com.wzbc.video.mapper.NewsMapper;
import com.wzbc.video.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    public NewsMapper newsMapper;

    @Override
    public IPage<News> list(Page<News>page,String name){
        return newsMapper.listNews(page,name);
    }

    @Override
    public IPage<News> schoolList(Page<News> page, String name, String school) {
        return newsMapper.schoolListNews(page,name,school);
    }

    @Override
    public int addNew(Long id, String school, String name) {
        return newsMapper.addNew(id,school,name);
    }

    @Override
    public int deleteNew(Long id) {
        return newsMapper.deleteNew(id);
    }

    @Override
    public int updateNew(Long id, String name) {
        return newsMapper.updateNew(id,name);
    }
}
