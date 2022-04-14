package com.wzbc.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NewsDetails {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String url;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "parent_id")
    private Long parentId;
    @TableField(value = "parent_name")
    private String parentName;
    @TableField(value = "picture_id")
    private Long pictureId;
    private String type;
    private String name;
}
