package com.wzbc.video.params;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class PersonalCenter {
    private String token;

    private String name;

    private String gender;

    private String national;

    private String nativePlace;

    private String politicalLandscape;

    private String school;

    private String department;

    private String idType;

    private Date birthday;

    private String email;

    private String idNumberPhoto;

    private String idNumberFront;

    private String idNumberEnd;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
