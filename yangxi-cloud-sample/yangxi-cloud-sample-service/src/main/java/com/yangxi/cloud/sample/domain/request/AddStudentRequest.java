package com.yangxi.cloud.sample.domain.request;

import com.yangxi.cloud.framework.domain.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <P>
 * 新增学生信息请求参数
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Data
@ApiModel
public class AddStudentRequest extends BaseRequest {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学校ID", example = "1")
    private Long schoolId;

    @ApiModelProperty(value = "学生名称", example = "张三")
    private String name;

    @ApiModelProperty(value = "年龄", example = "18")
    private Integer age;

    @ApiModelProperty(value = "性别", example = "1")
    private Integer sex;

}