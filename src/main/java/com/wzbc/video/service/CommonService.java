package com.wzbc.video.service;

import com.wzbc.video.api.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    /**
     * 上传文件至阿里云 oss
     *
     * @param file
     * @param
     * @return
     * @throws Exception
     */
    ResponseResult uploadOSS(MultipartFile file) throws Exception;

    ResponseResult delete(String objectName);

}
