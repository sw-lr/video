package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.entity.Notification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotificationMapper extends BaseMapper<Notification> {
    IPage<Notification> listNotification(Page<Notification> page,String name);

    IPage<Notification> schoolListNotification(Page<Notification> page,String name,String school);

    int addNote(Long id,String name,String school);

    int deleteNote(Long id);

    int updateNote(Long id,String name);
}
