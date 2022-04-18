package com.wzbc.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzbc.video.entity.User;
import com.wzbc.video.entity.UserAudit;
import com.wzbc.video.entity.UserProduction;
import com.wzbc.video.mapper.MyMatchMapper;
import com.wzbc.video.mapper.UserMapper;
import com.wzbc.video.params.Judge;
import com.wzbc.video.params.MyMatch;
import com.wzbc.video.params.PersonalCenter;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    public UserMapper userMapper;
    @Autowired
    public MyMatchMapper myMatchMapper;
    @Autowired
    public TokenUtil tokenUtil;

    @Override
    public IPage<User> teacherListAdmin(Page<User> page, String name) {
        return userMapper.findAllTeacherAdmin(page,name);
    }

    @Override
    public IPage<User> teacherList(Page<User> page, String name, String school) {
        return userMapper.findAllTeacher(page,name,school);
    }

    @Override
    public IPage<User> schoolList(Page<User> page, String name) {
        return userMapper.findAllSchool(page,name);
    }

    @Override
    public IPage<User> judgeList(Page<User> page, String name) {
        return userMapper.findAllJudge(page,name);
    }

    @Override
    public int deleteTeacher(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int deleteSchool(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int deleteJudge(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int addJudge(Judge judge) {
        User user=new User();
        user.setName(judge.getName());
        user.setUsername(judge.getUsername());
        user.setPassword(judge.getPassword());
        user.setSchool(judge.getSchool());
        user.setRoles("judge");
        user.setDepartment(judge.getDepartment());
        user.setPoliticalLandscape(judge.getPoliticalLandscape());
        user.setBirthday(judge.getBirthday());
        user.setGender(judge.getGender());
        user.setNational(judge.getNational());
        user.setEmail(judge.getEmail());
        return userMapper.addJudge(user);
    }

    @Override
    public IPage<UserAudit> teacherAuditListAdmin(Page<UserAudit> page, String name) {
        return userMapper.findAllTeacherAuditAdmin(page,name);
    }

    @Override
    public IPage<UserAudit> teacherAuditList(Page<UserAudit> page, String name,String school) {
        return userMapper.findAllTeacherAudit(page,name,school);
    }

    @Override
    public IPage<UserAudit> schoolAuditListAdmin(Page<UserAudit> page, String name) {
        return userMapper.findAllSchoolAuditAdmin(page,name);
    }

    @Override
    public int UserPass(int id) {
        UserAudit userAudit=userMapper.findByid(id);
        int result=userMapper.insertUser(userAudit);
        result+=userMapper.deleteUserAudit(id);
        System.out.println(result);
        return result;
    }

    @Override
    public int UserNoPass(int id) {
        return userMapper.UserNoPass(id);
    }

    @Override
    public int deleteUserAudit(int id) {
        return userMapper.deleteUserAudit(id);
    }

    @Override
    public List<User> info(Long id) {
        return userMapper.findById(id);
    }

    //查找用户是否存在
    @Override
    public Integer validateUsername(String username) {
//        System.out.println("用户是否存在"+userMapper.findByUsername(username).size());
        return userMapper.findByUsername(username).size();

    }

    //判断账号、密码、验证码是否正确
    @Override
    public Long validateLogin(String username, String password, String code, HttpServletRequest request) {
        String captcha =(String) request.getSession().getAttribute("captcha");
        System.out.println(captcha);
        System.out.println(code);
        System.out.println(StringUtils.hasLength(code));
        System.out.println(captcha.equals(code));
        if(!StringUtils.hasLength(code) || !captcha.equals(code)){
            System.out.println("验证码错误");
            return 0L;
        }
        List<User> users =userMapper.findByUsernameAndPassowrd(username,password);

        if(users.size()==0){
            return 0L;
        }
        return users.get(0).getUserId();
    }

    @Override
    public Long validateBackgroundLogin(String username, String password) {
        List<User> users =userMapper.findByUsernameAndPassowrd(username,password);

        if(users.size()==0){
            return 0L;
        }
        return users.get(0).getUserId();
    }

    @Override
    public int updateInfo(PersonalCenter personalCenter) {
        User users=new User();
        users.setUserId(Long.parseLong(tokenUtil.getToken(personalCenter.getToken())));
        users.setName(personalCenter.getName());
        users.setGender(personalCenter.getGender());
        users.setNational(personalCenter.getNational());
        users.setNativePlace(personalCenter.getNativePlace());
        users.setPoliticalLandscape(personalCenter.getPoliticalLandscape());
        users.setSchool(personalCenter.getSchool());
        users.setDepartment(personalCenter.getDepartment());
        users.setIdType(personalCenter.getIdType());
        users.setBirthday(personalCenter.getBirthday());
        users.setEmail(personalCenter.getEmail());
        users.setIdNumberPhoto(personalCenter.getIdNumberPhoto());
        users.setIdNumberFront(personalCenter.getIdNumberFront());
        users.setIdNumberEnd(personalCenter.getIdNumberEnd());
        return userMapper.updateById(users);
    }

    @Override
    public int updateMyMatch(MyMatch myMatch) {
        UserProduction userProduction=new UserProduction();
        userProduction.setParentId(Long.parseLong(tokenUtil.getToken(myMatch.getToken())));
        userProduction.setCoursePhoto(myMatch.getCoursePhoto());
        userProduction.setCourseName(myMatch.getCourseName());
        userProduction.setCourseIntroduction(myMatch.getCourseIntroduction());
        userProduction.setCourseBelong(myMatch.getCourseBelong());
        userProduction.setCourseType(myMatch.getCourseType());
        userProduction.setCourseware(myMatch.getCourseware());
        userProduction.setCourseDesign(myMatch.getCourseDesign());
        userProduction.setVideo(myMatch.getVideo());
        return myMatchMapper.updateMyMatch(userProduction);
//        return myMatchMapper.updateMyMatch(Long.parseLong(tokenUtil.getToken(myMatch.getToken())),myMatch.getCoursePhoto(),myMatch.getCourseName(),myMatch.getCourseIntroduction(),myMatch.getCourseBelong(),myMatch.getCourseType(),myMatch.getCourseware(),myMatch.getCourseDesign(),myMatch.getVideo());
    }

    @Override
    public List<UserProduction> infoMyMatch(String token) {
        return myMatchMapper.findByParentId(Long.parseLong(tokenUtil.getToken(token)));
    }

    @Override
    public List<User> judgeList() {
        return userMapper.judgeList();
    }

}
