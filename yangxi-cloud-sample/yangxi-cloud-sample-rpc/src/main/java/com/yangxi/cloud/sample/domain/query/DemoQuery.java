package com.yangxi.cloud.sample.domain.query;

import com.yangxi.cloud.framework.domain.query.BaseQuery;
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
public class DemoQuery extends BaseQuery {

    /**
     * 按名称进行查询
     */
    @ApiModelProperty(value = "名称", example = "test")
    private String name;

}