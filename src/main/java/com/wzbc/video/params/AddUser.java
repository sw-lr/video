package com.wzbc.video.params;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class AddUser {
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

    @TableField(value = "id_number_photo")
    private String idNumberPhoto;

}
