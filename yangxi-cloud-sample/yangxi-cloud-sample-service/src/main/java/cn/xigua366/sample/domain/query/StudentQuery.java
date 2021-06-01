package cn.xigua366.sample.domain.query;

import com.yangxi.cloud.framework.domain.query.BasePageQuery;
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
public class StudentQuery extends BasePageQuery {

    private static final long serialVersionUID = 1L;

    /**
     * 根据学生姓名模糊查询学生信息
     */
    private String name;
}