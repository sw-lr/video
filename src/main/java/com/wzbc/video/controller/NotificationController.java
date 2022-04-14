package com.wzbc.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.api.CommonResult;
import com.wzbc.video.entity.Notification;
import com.wzbc.video.entity.User;
import com.wzbc.video.params.NoteAndNew;
import com.wzbc.video.service.NotificationDetailsService;
import com.wzbc.video.service.NotificationService;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    public NotificationService notificationService;
    @Autowired
    public NotificationDetailsService notificationDetailsService;
    @Autowired
    public UserService userService;
    @Autowired
    public TokenUtil tokenUtil;

    @GetMapping("/list")
    public CommonResult getList(@RequestParam(value = "name") String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
//        System.out.println(name+current+size);
        Page<Notification> page=new Page<>(current,size);
        return CommonResult.success(notificationService.list(page,name));
    }

    @GetMapping("/schoolList")
    public CommonResult getSchoolList(@RequestParam(value = "name")String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size,@RequestParam(value = "token")String token){
        Long userId=Long.parseLong(tokenUtil.getToken(token));
        List<User> user=userService.info(userId);
        Page<Notification>page=new Page<>(current,size);
        if(user.get(0).getRoles().equals("admin")){
            return CommonResult.success(notificationService.schoolList(page,name,"admin"));
        }else{
            return CommonResult.success(notificationService.schoolList(page,name,user.get(0).getSchool()));
        }
    }

    @GetMapping("/details")
    public CommonResult detailsList(@RequestParam(value = "id") Long id ){
        return CommonResult.success(notificationDetailsService.list(id));
    }

    @PostMapping("/addNote")
    public CommonResult addNote(@RequestBody NoteAndNew noteAndNew){
        Long userId=Long.parseLong(tokenUtil.getToken(noteAndNew.getToken()));
        List<User> user=userService.info(userId);
        Long id=new Date().getTime();
        int note=notificationService.addNote(id,user.get(0).getSchool(),noteAndNew.getName());
        int details=notificationDetailsService.addDetails(id,noteAndNew);
        if(note==1 && details==1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed("添加失败，请联系管理员");
    }

    @GetMapping("/deleteNote")
    public CommonResult deleteNote(@RequestParam(value = "id")Long id){
        int note=notificationService.deleteNote(id);
        int details=notificationDetailsService.deleteDetails(id);
        return CommonResult.success("删除成功");
    }

    @PostMapping("/editNote")
    public CommonResult editNote(@RequestBody NoteAndNew noteAndNew){
//        Long userId=Long.parseLong(tokenUtil.getToken(noteAndNew.getToken()));
//        List<User> user=userService.info(userId);
        int note=notificationService.updateNote(Long.parseLong(noteAndNew.getToken()),noteAndNew.getName());
        int details=notificationDetailsService.updateDetails(Long.parseLong(noteAndNew.getToken()),noteAndNew);
        return CommonResult.success("修改成功");
    }
}
