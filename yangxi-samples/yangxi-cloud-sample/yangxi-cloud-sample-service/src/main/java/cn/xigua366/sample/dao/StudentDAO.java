package cn.xigua366.sample.dao;

import cn.xigua366.sample.domain.dto.PageSchoolDTO;
import cn.xigua366.sample.domain.dto.PageStudentDTO;
import cn.xigua366.sample.domain.entity.StudentDO;
import cn.xigua366.sample.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class StudentDAO extends BaseDAO<StudentMapper, StudentDO> {

    /**
     * 分页查询学生信息
     * @param page 当前页数
     * @param size 每页记录数
     * @param name 学生姓名
     * @return
     */
    public IPage<PageStudentDTO> pageStudent(long page, long size, String name) {
        Page<PageSchoolDTO> pageParam = new Page<>(page, size);
        return baseMapper.pageStudent(pageParam, name);
    }
}