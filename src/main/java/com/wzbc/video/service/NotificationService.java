package com.wzbc.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.Notification;

import java.util.List;

public interface NotificationService extends IService<Notification> {
    IPage<Notification> list(Page<Notification> page,String name);

    IPage<Notification> schoolList(Page<Notification> page,String name,String school);

    int addNote(Long id,String school,String name);

    int deleteNote(Long id);

    int updateNote(Long id,String name);
}
