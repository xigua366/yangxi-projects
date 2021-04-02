package com.yangxi.cloud.sample.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件服务Service接口
 * @author yangxi
 */
public interface FileService {

    String uploadUserHeadImg(MultipartFile file);
}