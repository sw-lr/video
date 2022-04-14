package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.NewsDetails;
import com.wzbc.video.mapper.NewsDetailsMapper;
import com.wzbc.video.params.NoteAndNew;
import com.wzbc.video.params.Picture;
import com.wzbc.video.service.NewsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsDetailsServiceImpl extends ServiceImpl<NewsDetailsMapper, NewsDetails> implements NewsDetailsService {
    @Autowired
    public NewsDetailsMapper newsDetailsMapper;

    @Override
    public List<NewsDetails> list(Long id) {
        return newsDetailsMapper.listNewsDeatils(id);
    }

    @Override
    public int addDetails(Long id, NoteAndNew noteAndNew) {
        List<Picture> picture=noteAndNew.getPicture();
        for (int i=0;i<picture.size();i++){
            newsDetailsMapper.addDetails(id,picture.get(i).getUrl(),noteAndNew.getName(),picture.get(i).getName(),i+1,"photo");
        }
        List<Picture> file=noteAndNew.getFile();
        for(int i=0;i<file.size();i++){
            newsDetailsMapper.addDetails(id,file.get(i).getUrl(),noteAndNew.getName(),file.get(i).getName(),i+1,"doc");
        }
        return 1;
    }

    @Override
    public int deleteDetails(Long id) {
        return newsDetailsMapper.deleteDetails(id);
    }

    @Override
    public int updateDetails(Long id, NoteAndNew noteAndNew) {
        newsDetailsMapper.deleteDetails(id);
        List<Picture>picture=noteAndNew.getPicture();
        for (int i=0;i<picture.size();i++){
            newsDetailsMapper.addDetails(id,picture.get(i).getUrl(),noteAndNew.getName(),picture.get(i).getName(),i+1,"photo");
        }
        List<Picture>file=noteAndNew.getFile();
        for(int i=0;i<file.size();i++){
            newsDetailsMapper.addDetails(id,file.get(i).getUrl(),noteAndNew.getName(),file.get(i).getName(),i+1,"doc");
        }
        return 1;
    }
}
