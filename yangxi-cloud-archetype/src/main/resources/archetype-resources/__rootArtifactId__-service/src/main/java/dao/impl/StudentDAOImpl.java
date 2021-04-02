package ${package}.dao.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${package}.dao.StudentDAO;
import ${package}.domain.dto.PageSchoolDTO;
import ${package}.domain.dto.PageStudentDTO;
import ${package}.domain.entity.StudentDO;
import ${package}.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

/**
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