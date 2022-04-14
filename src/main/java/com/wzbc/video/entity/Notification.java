package com.wzbc.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//赛事公告实体类

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Notification {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
//    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date createtime;
//    private String url;
    @TableField(value = "child_id")
    private Long childId;

    private String school;
}
