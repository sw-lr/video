package com.wzbc.video.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzbc.video.api.CommonResult;
import com.wzbc.video.entity.News;
import com.wzbc.video.entity.User;
import com.wzbc.video.params.NoteAndNew;
import com.wzbc.video.service.NewsDetailsService;
import com.wzbc.video.service.NewsService;
import com.wzbc.video.service.UserService;
import com.wzbc.video.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    public NewsService newsService;
    @Autowired
    public NewsDetailsService newsDetailsService;
    @Autowired
    public UserService userService;
    @Autowired
    public TokenUtil tokenUtil;

    @GetMapping("/list")
    public CommonResult getList(@RequestParam(value = "name")String name,@RequestParam(value = "current")int current,@RequestParam(value = "size")int size){
        Page<News>page=new Page<>(current,size);
        return CommonResult.success(newsService.list(page,name));
    }

    @GetMapping("/schoolList")
    public CommonResult getSchoolList(@RequestParam(value="name")String name,@RequestParam(value="current")int current,@RequestParam(value="size")int size,@RequestParam(value="token")String token){
        Long userId=Long.parseLong(tokenUtil.getToken(token));
        List<User>users=userService.info(userId);
        Page<News>page=new Page<>(current,size);
        if(users.get(0).getRoles().equals("admin")){
            return CommonResult.success(newsService.schoolList(page,name,"admin"));
        }else{
            return CommonResult.success(newsService.schoolList(page,name,users.get(0).getSchool()));
        }
    }

    @GetMapping("/details")
    public CommonResult detailsList(@RequestParam(value = "id") Long id ){
        return CommonResult.success(newsDetailsService.list(id));
    }

    @PostMapping("/addNew")
    public CommonResult addNew(@RequestBody NoteAndNew noteAndNew){
        Long userId=Long.parseLong(tokenUtil.getToken(noteAndNew.getToken()));
        List<User> user=userService.info(userId);
        Long id=new Date().getTime();
        int news=newsService.addNew(id,user.get(0).getSchool(),noteAndNew.getName());
        int details=newsDetailsService.addDetails(id,noteAndNew);
        if(news==1 && details ==1){
            return CommonResult.success("添加成功");
        }
        return CommonResult.failed("添加失败，请联系管理员");
    }

    @GetMapping("/deleteNew")
    public CommonResult deleteNew(@RequestParam(value="id")Long id){
        int news=newsService.deleteNew(id);
        int details=newsDetailsService.deleteDetails(id);
        return CommonResult.success("删除成功");
    }

    @PostMapping("/editNew")
    public CommonResult editNew(@RequestBody NoteAndNew noteAndNew){
        int news=newsService.updateNew(Long.parseLong(noteAndNew.getToken()),noteAndNew.getName());
        int details=newsDetailsService.updateDetails(Long.parseLong(noteAndNew.getToken()),noteAndNew);
        return CommonResult.success("修改成功");
    }
}
