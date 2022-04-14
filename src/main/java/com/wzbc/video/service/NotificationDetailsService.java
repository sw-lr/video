package com.wzbc.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.NotificationDetails;
import com.wzbc.video.params.NoteAndNew;

import java.util.List;

public interface NotificationDetailsService extends IService<NotificationDetails> {
    List<NotificationDetails> list(Long id);
    int addDetails(Long id, NoteAndNew noteAndNew);
    int deleteDetails(Long id);
    int updateDetails(Long id,NoteAndNew noteAndNew);
}
