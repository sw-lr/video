package com.wzbc.video.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.ObjectMetadata;
import com.wzbc.video.api.ResponseResult;
import com.wzbc.video.config.OSSConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class OSSBootUtil {
    private OSSBootUtil(){}

    /**
     * oss 工具客户端
     */
    private volatile static OSSClient ossClient = null;

    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     * @author jiangpengcheng
     * @param ossConfig oss 配置信息
     * @param file 待上传文件
     * @param fileDir 文件保存目录
     * @return oss 中的相对文件路径
     */

    public static String upload(OSSConfig ossConfig, MultipartFile file, String fileDir){
        initOSS(ossConfig);
//        System.out.println("file:"+file.getOriginalFilename());
        StringBuilder fileUrl = new StringBuilder();
        try {
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String fileName = System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0,18) + suffix;
            if (!fileDir.endsWith("/")) {
                fileDir = fileDir.concat("/");
            }
            fileUrl = fileUrl.append(fileDir + fileName);
            System.out.println(fileUrl+"-----------------");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            System.out.println("suffix"+suffix);

            if(suffix.equals(".ppt")){
                objectMetadata.setContentType("application/vnd.ms-powerpoint");
            }else if(suffix.equals(".docx")){
                objectMetadata.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            }else if(suffix.equals(".doc")){
                objectMetadata.setContentType("application/msword");
            }else if(suffix.equals(".mp4")){
                objectMetadata.setContentType("video/mp4");
            }else{
                objectMetadata.setContentType("image/jpg");
            }


            ossClient.putObject(ossConfig.getBucketName(), fileUrl.toString(), file.getInputStream(),objectMetadata);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        fileUrl = fileUrl.insert(0,ossConfig.getUrl());
        return fileUrl.toString();
    }

    /**
     * 初始化 oss 客户端
     * @param ossConfig
     * @return
     */
    private static OSSClient initOSS(OSSConfig ossConfig) {
        if (ossClient == null ) {
            synchronized (OSSBootUtil.class) {
                if (ossClient == null) {
                    ossClient = new OSSClient(ossConfig.getEndpoint(),
                            new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                            new ClientConfiguration());
                }
            }
        }
        return ossClient;
    }

    /**
     * 根据前台传过来的文件地址 删除文件
     * @author jiangpengcheng
     * @param objectName
     * @param ossConfig
     * @return
     */
    public static ResponseResult delete(String objectName, OSSConfig ossConfig) {
        initOSS(ossConfig);
        //将完整路径替换成 文件地址 因为yml里的url有了地址链接https: //oos-all.oss-cn-shenzhen.aliyuncs.com/
        // 如果再加上地址 那么又拼接了 所以删除不了 要先把地址替换为 jpc/2020-07-16/1594857669731-51d057b0-9778-4aed.png
        String fileName = objectName.replace("https://ysw-video.oss-cn-beijing.aliyuncs.com/upload/", "");
        System.out.println(fileName+"******************************");
        // 根据BucketName,objectName删除文件
        ossClient.deleteObject(ossConfig.getBucketName(), fileName);

        return ResponseResult.ok("删除成功",fileName);
    }

}
