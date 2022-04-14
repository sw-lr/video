package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.NotificationDetails;
import com.wzbc.video.mapper.NotificationDetailsMapper;
import com.wzbc.video.params.NoteAndNew;
import com.wzbc.video.params.Picture;
import com.wzbc.video.service.NotificationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationDetailsServiceImpl extends ServiceImpl<NotificationDetailsMapper, NotificationDetails>implements NotificationDetailsService {
    @Autowired
    public NotificationDetailsMapper notificationDetailsMapper;

    @Override
    public List<NotificationDetails> list(Long id) {
        return notificationDetailsMapper.listNotificationDetails(id);
    }

    @Override
    public int addDetails(Long id, NoteAndNew noteAndNew) {
        List<Picture> picture=noteAndNew.getPicture();
        for(int i=0;i<picture.size();i++){
            notificationDetailsMapper.addDetails(id,picture.get(i).getUrl(),noteAndNew.getName(),picture.get(i).getName(),i+1,"photo");
        }

        List<Picture> file=noteAndNew.getFile();
        for(int i=0;i<file.size();i++){
            notificationDetailsMapper.addDetails(id,file.get(i).getUrl(),noteAndNew.getName(),file.get(i).getName(),i+1,"doc");
        }

        return 1;
    }

    @Override
    public int deleteDetails(Long id) {
        return notificationDetailsMapper.deleteDetails(id);
    }

    @Override
    public int updateDetails(Long id, NoteAndNew noteAndNew) {
        notificationDetailsMapper.deleteDetails(id);
        List<Picture>picture=noteAndNew.getPicture();
        for(int i=0;i<picture.size();i++){
            notificationDetailsMapper.addDetails(id,picture.get(i).getUrl(),noteAndNew.getName(),picture.get(i).getName(),i+1,"photo");
        }
        List<Picture>file=noteAndNew.getFile();
        for(int i=0;i<file.size();i++){
            notificationDetailsMapper.addDetails(id,file.get(i).getUrl(),noteAndNew.getName(),file.get(i).getName(),i+1,"doc");
        }
        return 0;
    }
}
