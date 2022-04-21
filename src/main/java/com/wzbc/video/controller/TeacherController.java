package com.wzbc.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.api.CommonResult;
import com.wzbc.video.entity.Notification;
import com.wzbc.video.entity.User;
import com.wzbc.video.entity.UserAudit;
import com.wzbc.video.params.AddUser;
import com.wzbc.video.params.Judge;
import com.wzbc.video.params.MyMatch;
import com.wzbc.video.params.PersonalCenter;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    public UserService userService;
    @Autowired
    public TokenUtil tokenUtil;

    @GetMapping("/teacherList")
    public CommonResult teacherList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size,@RequestParam(value = "token")String token){
        Page<User> page=new Page<>(current,size);
        Long id=Long.parseLong(tokenUtil.getToken(token));
        List<User> user=userService.info(id);
        if(user.get(0).getRoles().equals("admin")){
            return CommonResult.success(userService.teacherListAdmin(page,name));
        }else{
            return CommonResult.success(userService.teacherList(page,name,user.get(0).getSchool()));
        }

    }

    @GetMapping("/schoolList")
    public CommonResult schoolList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
        Page<User> page=new Page<>(current,size);
        return CommonResult.success(userService.schoolList(page,name));
    }

    @GetMapping("/judgeList")
    public CommonResult judgeList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
        Page<User> page=new Page<>(current,size);
        return CommonResult.success(userService.judgeList(page,name));
    }

    @GetMapping("/deleteTeacher")
    public CommonResult deleteTeacher(@RequestParam(value = "id")int id){
        return CommonResult.success(userService.deleteTeacher(id));
    }

    @GetMapping("/deleteSchool")
    public CommonResult deleteSchool(@RequestParam(value = "id")int id){
        return CommonResult.success(userService.deleteSchool(id));
    }

    @GetMapping("/deleteJudge")
    public CommonResult deleteJudge(@RequestParam(value = "id")int id){
        return CommonResult.success(userService.deleteJudge(id));
    }

    @PostMapping("/addJudge")
    public CommonResult addJudge(@RequestBody Judge judge){
        return CommonResult.success(userService.addJudge(judge));
    }

    @GetMapping("/teacherAuditList")
    public CommonResult teacherAuditList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size,@RequestParam(value = "token")String token){
        Long id=Long.parseLong(tokenUtil.getToken(token));
        List<User> user=userService.info(id);
        Page<UserAudit> page=new Page<>(current,size);
        System.out.println(user.get(0).getRoles());
        if(user.get(0).getRoles().equals("admin")){
            return CommonResult.success(userService.teacherAuditListAdmin(page,name));
        }else{
            return CommonResult.success(userService.teacherAuditList(page,name,user.get(0).getSchool()));
        }

    }

    @GetMapping("/schoolAuditList")
    public CommonResult schoolAuditList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
        Page<UserAudit> page=new Page<>(current,size);
        return CommonResult.success(userService.schoolAuditListAdmin(page,name));
    }

    @PostMapping("/register")
    public CommonResult register(@RequestBody AddUser addUser){
        userService.addUser(addUser);
        return CommonResult.success("注册成功");
    }

    @GetMapping("/userPass")
    public CommonResult userPass(@RequestParam(value = "id")int id){
        if(userService.UserPass(id)==2){
            return CommonResult.success("账号通过");
        }else{
            return CommonResult.failed("账号通过失败，请联系管理员");
        }

    }

    @GetMapping("/userNoPass")
    public CommonResult userNoPass(@RequestParam(value = "id")int id){
        return CommonResult.success(userService.UserNoPass(id));
    }

    @GetMapping("/deleteUserAudit")
    public CommonResult deleteUserAudit(@RequestParam(value = "id")int id){
        return CommonResult.success(userService.deleteUserAudit(id));
    }


    @GetMapping("/info")
    public CommonResult teacherInfo(@RequestParam(value = "token") String token){
        Long id=Long.parseLong(tokenUtil.getToken(token));
        return CommonResult.success(userService.info(id));
    }

    @PostMapping("/updateInfo")
    public CommonResult teacherUpdate(@RequestBody PersonalCenter personalCenter){
        if(userService.updateInfo(personalCenter)==0){
            return CommonResult.failed("修改失败");
        }
        return CommonResult.success("修改成功");
    }

    @PostMapping("/updateMyMatch")
    public CommonResult myMatchUpdate(@RequestBody MyMatch myMatch){
        if(userService.updateMyMatch(myMatch)!=1){
            return CommonResult.failed("提交失败");
        }
        return CommonResult.success("提交成功");
    }


    @GetMapping("/infoMyMatch")
    public CommonResult myMatchInfo(@RequestParam(value = "token") String token){
        return CommonResult.success(userService.infoMyMatch(token));
    }
}
