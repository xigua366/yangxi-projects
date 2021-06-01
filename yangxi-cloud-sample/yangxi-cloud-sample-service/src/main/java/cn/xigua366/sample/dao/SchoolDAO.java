package cn.xigua366.sample.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.xigua366.sample.domain.dto.PageSchoolDTO;
import cn.xigua366.sample.domain.entity.SchoolDO;

/**
 * <P>
 *
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
public interface SchoolDAO extends IService<SchoolDO> {

    /**
     * 根据学校名称模糊查询
     * @param page 当前页数
     * @param size 每页记录数
     * @param schoolName 查询条件
     * @return
     */
    IPage<PageSchoolDTO> pageSchool2(long page, long size, String schoolName);

}