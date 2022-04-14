package com.wzbc.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserProduction {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "course_photo")
    private String coursePhoto;

    @TableField(value = "course_name")
    private String courseName;

    @TableField(value = "course_introduction")
    private String courseIntroduction;

    @TableField(value = "course_belong")
    private String courseBelong;

    @TableField(value = "course_type")
    private String courseType;

    @TableField(value = "courseware")
    private String courseware;

    @TableField(value = "course_design")
    private String courseDesign;

    private String video;

    @TableField(value = "parent_id")
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursePhoto() {
        return coursePhoto;
    }

    public void setCoursePhoto(String coursePhoto) {
        this.coursePhoto = coursePhoto;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    public void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    public String getCourseBelong() {
        return courseBelong;
    }

    public void setCourseBelong(String courseBelong) {
        this.courseBelong = courseBelong;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseware() {
        return courseware;
    }

    public void setCourseware(String courseware) {
        this.courseware = courseware;
    }

    public String getCourseDesign() {
        return courseDesign;
    }

    public void setCourseDesign(String courseDesign) {
        this.courseDesign = courseDesign;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
