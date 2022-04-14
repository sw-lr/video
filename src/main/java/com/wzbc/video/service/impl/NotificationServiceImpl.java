package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.Notification;
import com.wzbc.video.mapper.NotificationMapper;
import com.wzbc.video.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper,Notification> implements NotificationService {
    @Autowired
    public NotificationMapper notificationMapper;

    @Override
    public IPage<Notification> list(Page<Notification> page,String name) {
        return notificationMapper.listNotification(page,name);
    }

    @Override
    public int addNote(Long id,String school, String name) {

        return notificationMapper.addNote(id,name,school);
    }

    @Override
    public int deleteNote(Long id) {
        return notificationMapper.deleteNote(id);
    }

    @Override
    public int updateNote(Long id, String name) {
        return notificationMapper.updateNote(id,name);
    }

    @Override
    public IPage<Notification> schoolList(Page<Notification> page, String name, String school) {
        return notificationMapper.schoolListNotification(page,name,school);
    }
}
