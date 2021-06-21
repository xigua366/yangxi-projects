package cn.xigua366.sample.service;


import cn.xigua366.sample.domain.dto.PageSchoolDTO;
import cn.xigua366.sample.domain.dto.SchoolDTO;
import cn.xigua366.sample.domain.query.PageSchoolQuery;
import com.yangxi.cloud.framework.core.PageResult;

/**
 * <p>
 * 学校信息Service组件
 * <p/>
 *
 * @author yangxi
 * @version 1.0
 */
public interface SchoolService {

    /**
     * 根据ID查询学校信息
     * @param id
     * @return
     */
    SchoolDTO getSchoolById(Long id);

    /**
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    PageResult<SchoolDTO> pageSchool(PageSchoolQuery pageSchoolQuery);

    /**
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    PageResult<PageSchoolDTO> pageSchool2(PageSchoolQuery pageSchoolQuery);
}