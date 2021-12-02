package ${package}.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.dao.SchoolDAO;
import ${package}.domain.dto.PageSchoolDTO;
import ${package}.domain.entity.SchoolDO;
import ${package}.mapper.SchoolMapper;
import com.yangxi.cloud.framework.dao.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * <P>
 *
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Repository
public class SchoolDAO extends BaseDAO<SchoolMapper, SchoolDO> {

    /**
     * 根据学校名称模糊查询
     * @param page 当前页数
     * @param size 每页记录数
     * @param schoolName 查询条件
     * @return
     */
    public IPage<PageSchoolDTO> pageSchool2(long page, long size, String schoolName) {
        Page<PageSchoolDTO> pageParam = new Page<>(page, size);
        return baseMapper.pageSchool2(pageParam, schoolName);
    }
}