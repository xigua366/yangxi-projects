package ${package}.domain.request;

import com.yangxi.cloud.framework.domain.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 登录 request
 */
@Data
@ApiModel
public class LoginRequest extends BaseRequest {

    @ApiModelProperty(value = "手机号码", example = "13812345543")
    private String phone;

    @ApiModelProperty(value = "密码", example = "123456")
    private String pwd;
}