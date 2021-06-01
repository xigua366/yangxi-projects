package ${package}.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import ${package}.domain.dto.PageStudentDTO;
import ${package}.domain.entity.StudentDO;

/**
 * <P>
 *
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
public interface StudentDAO extends IService<StudentDO> {

    /**
     * 分页查询学生信息
     * @param page 当前页数
     * @param size 每页记录数
     * @param name 学生姓名
     * @return
     */
    IPage<PageStudentDTO> pageStudent(long page, long size, String name);
}