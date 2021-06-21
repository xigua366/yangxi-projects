package cn.xigua366.sample.dao.impl;

import cn.xigua366.sample.dao.StudentDAO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xigua366.sample.domain.dto.PageSchoolDTO;
import cn.xigua366.sample.domain.dto.PageStudentDTO;
import cn.xigua366.sample.domain.entity.StudentDO;
import cn.xigua366.sample.mapper.StudentMapper;
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
public class StudentDAOImpl extends ServiceImpl<StudentMapper, StudentDO> implements StudentDAO {

    /**
     * 分页查询学生信息
     * @param page 当前页数
     * @param size 每页记录数
     * @param name 学生姓名
     * @return
     */
    @Override
    public IPage<PageStudentDTO> pageStudent(long page, long size, String name) {
        Page<PageSchoolDTO> pageParam = new Page<>(page, size);
        return baseMapper.pageStudent(pageParam, name);
    }
}