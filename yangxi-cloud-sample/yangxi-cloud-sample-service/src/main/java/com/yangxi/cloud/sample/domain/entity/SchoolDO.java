package com.yangxi.cloud.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * @author yangxi
 * @version 1.0
 */
@Data
@TableName("t_school")
public class SchoolDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String address;

}