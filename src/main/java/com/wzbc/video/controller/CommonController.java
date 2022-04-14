package com.wzbc.video.controller;

import com.wzbc.video.api.ResponseResult;
import com.wzbc.video.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class CommonController {
    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private CommonService commonService;

    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload/oss", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseResult uploadOSS(@RequestParam(value = "file") MultipartFile file) throws Exception {
        System.out.println(file.getInputStream());
        ResponseResult responseResult = commonService.uploadOSS(file);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return ResponseResult.ok("ok",responseResult);
    }

    @RequestMapping("/delete/oss")
    public ResponseResult deltetOss(String objectName){
        System.out.println(objectName+"-------------------------------");
        ResponseResult delete = commonService.delete(objectName);
        return delete;
    }



}
