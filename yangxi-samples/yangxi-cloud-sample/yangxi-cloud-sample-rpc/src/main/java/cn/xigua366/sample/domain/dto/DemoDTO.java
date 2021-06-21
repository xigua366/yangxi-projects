package cn.xigua366.sample.domain.dto;

import com.yangxi.cloud.framework.core.AbstractObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@ApiModel
@Data
public class DemoDTO extends AbstractObject {

    /**
     * ID
     */
    @ApiModelProperty(value = "id", example = "1")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称", example = "test")
    private String demoName;

}