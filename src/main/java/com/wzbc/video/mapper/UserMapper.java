package com.wzbc.video.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.entity.User;
import com.wzbc.video.entity.UserAudit;
import com.wzbc.video.params.Judge;
import com.wzbc.video.params.PersonalCenter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    //根据账号判断账号是否存在
    List<User> findByUsername(String username);

    /*
    * 高校教师微课比赛网站
    * 判断账号密码是否正确
    * */
    List<User> findByUsernameAndPassowrd(String username,String password);

    //登录成功后获得该用户的详细信息
    List<User> findById(Long id);

    //所有教师信息
    IPage<User> findAllTeacherAdmin(Page<User>page,String name);

    IPage<User> findAllTeacher(Page<User>page,String name,String school);

    //所有学校管理员信息
    IPage<User> findAllSchool(Page<User>page,String name);

    //所有评委信息
    IPage<User> findAllJudge(Page<User>page,String name);

    //根据id删除用户
    int deleteUser(int id);


    int addJudge(@Param("judge")User judge);

    //所有教师信息
    IPage<UserAudit> findAllTeacherAuditAdmin(Page<UserAudit>page, String name);

    IPage<UserAudit> findAllTeacherAudit(Page<UserAudit>page, String name,String school);

    IPage<UserAudit> findAllSchoolAuditAdmin(Page<UserAudit>page,String name);

    //通过id查找审核的用户
    UserAudit findByid(int id);

    //通过审核的账号添加到user表中
    int insertUser(@Param("userAudit")UserAudit userAudit);

    //审核通过的账号从审核表中删除
    int deleteUserAudit(int id);

    //审核不通过的账号，修改状态
    int UserNoPass(int id);
}
