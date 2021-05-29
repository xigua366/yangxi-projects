package ${package}.domain.request;

import com.yangxi.cloud.framework.domain.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@ApiModel
@Data
public class AddDemoRequest extends BaseRequest {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", example = "test")
    private String demoName;
}