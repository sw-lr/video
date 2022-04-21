package com.wzbc.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzbc.video.entity.User;
import com.wzbc.video.entity.UserAudit;
import com.wzbc.video.entity.UserProduction;
import com.wzbc.video.params.AddUser;
import com.wzbc.video.params.Judge;
import com.wzbc.video.params.MyMatch;
import com.wzbc.video.params.PersonalCenter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService<User> {

    //根据账号判断账号是否存在
    Integer validateUsername(String username);

    //根据账号、密码、验证码，判断账号、密码、验证码是否正确
    Long validateLogin(String username, String password, String code, HttpServletRequest request);

    Long validateBackgroundLogin(String username, String password);

    //根据根据教师id，返回教师的个人信息
    List<User> info(Long id);

    //修改教师个人信息
    int updateInfo(PersonalCenter personalCenter);

    //修改教师参赛作品信息
    int updateMyMatch(MyMatch myMatch);

    //根据教师的登录token，返回教师的参赛作品信息
    List<UserProduction> infoMyMatch(String token);

    //教师列表信息
    IPage<User> teacherListAdmin(Page<User> page,String name);

    IPage<User> teacherList(Page<User> page,String name,String school);

    //学校管理员列表信息
    IPage<User> schoolList(Page<User> page,String name);

    //评委列表信息
    IPage<User> judgeList(Page<User> page,String name);

    //通过id删除教师
    int deleteTeacher(int id);

    //通过id删除学校管理员
    int deleteSchool(int id);

    //通过id删除评委
    int deleteJudge(int id);

    int addJudge(Judge judge);

    //教师审核列表信息
    IPage<UserAudit> teacherAuditListAdmin(Page<UserAudit> page, String name);

    IPage<UserAudit> teacherAuditList(Page<UserAudit> page, String name,String school);

    IPage<UserAudit> schoolAuditListAdmin(Page<UserAudit> page,String name);

    //通过id审核通过
    int UserPass(int id);

    //账号审核不通过
    int UserNoPass(int id);

    //删除审核列表
    int deleteUserAudit(int id);

    //评委列表
    List<User> judgeList();

    int addUser(AddUser addUser);
}
