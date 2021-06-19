package ${package}.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 上传文件服务Service接口
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public interface FileService {

    String uploadUserHeadImg(MultipartFile file);
}