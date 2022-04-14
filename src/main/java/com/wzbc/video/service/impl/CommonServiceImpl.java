package com.wzbc.video.service.impl;

import com.wzbc.video.api.ResponseResult;
import com.wzbc.video.config.OSSConfig;
import com.wzbc.video.service.CommonService;
import com.wzbc.video.utils.OSSBootUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("CommonService")
public class CommonServiceImpl implements CommonService {
    @Autowired
    private OSSConfig ossConfig;
    @Override
    public ResponseResult uploadOSS(MultipartFile file) throws Exception {
        // 格式化时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        // 高依赖版本 oss 上传工具
        String ossFileUrlBoot = null;
        /**
         * ossConfig 配置类
         * file 文件
         * "upload/"+format 上传文件地址 加时间戳
         */
        ossFileUrlBoot = OSSBootUtil.upload(ossConfig, file, "upload/"+format);
        System.out.println("ossFileUrlBoot"+ossFileUrlBoot);
        Map<String, Object> resultMap = new HashMap<>(16);
//        resultMap.put("ossFileUrlSingle", ossFileUrlSingle);
        resultMap.put("ossFileUrlBoot", ossFileUrlBoot);

        return ResponseResult.ok("上传成功~~",ossFileUrlBoot);

    }

    @Override
    public ResponseResult delete(String objectName) {
        ResponseResult delete = OSSBootUtil.delete(objectName, ossConfig);
        return delete;
    }
}
