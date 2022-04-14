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
public class UserAudit {
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    private String username;

    private String password;

    private String roles;

    private String name;

    private String gender;

    private String national;

    @TableField(value = "native_place")
    private String nativePlace;

    @TableField(value = "political_landscape")
    private String politicalLandscape;

    private String school;

    private String department;

    private String education;

    @TableField(value = "id_type")
    private String idType;

    private Date birthday;

    private String email;

    private String state;

    @TableField(value = "id_number_photo")
    private String idNumberPhoto;

    @TableField(value = "id_number_front")
    private String idNumberFront;

    @TableField(value = "id_number_end")
    private String idNumberEnd;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPoliticalLandscape() {
        return politicalLandscape;
    }

    public void setPoliticalLandscape(String politicalLandscape) {
        this.politicalLandscape = politicalLandscape;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdNumberPhoto() {
        return idNumberPhoto;
    }

    public void setIdNumberPhoto(String idNumberPhoto) {
        this.idNumberPhoto = idNumberPhoto;
    }

    public String getIdNumberFront() {
        return idNumberFront;
    }

    public void setIdNumberFront(String idNumberFront) {
        this.idNumberFront = idNumberFront;
    }

    public String getIdNumberEnd() {
        return idNumberEnd;
    }

    public void setIdNumberEnd(String idNumberEnd) {
        this.idNumberEnd = idNumberEnd;
    }
}
