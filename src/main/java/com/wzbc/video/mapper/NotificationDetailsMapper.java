package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzbc.video.entity.NotificationDetails;
import com.wzbc.video.params.NoteAndNew;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotificationDetailsMapper extends BaseMapper<NotificationDetails> {

    List<NotificationDetails> listNotificationDetails(Long id);
    int addDetails(Long id,String url,String parentName,String name,int num,String type);
    int deleteDetails(Long id);
}
