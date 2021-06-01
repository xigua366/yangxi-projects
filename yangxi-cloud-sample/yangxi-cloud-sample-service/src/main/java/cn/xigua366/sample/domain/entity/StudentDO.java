package cn.xigua366.sample.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yangxi.cloud.framework.domain.entity.BaseEntity;
import lombok.Data;

/**
 * <P>
 *
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Data
@TableName("t_student")
public class StudentDO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long schoolId;

    private String name;

    private Integer age;

    private Integer sex;
}