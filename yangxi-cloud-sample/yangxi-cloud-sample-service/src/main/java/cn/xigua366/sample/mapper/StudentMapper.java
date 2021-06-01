package cn.xigua366.sample.mapper;

import cn.xigua366.sample.domain.dto.PageStudentDTO;
import cn.xigua366.sample.domain.entity.StudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentDO> {

    IPage<PageStudentDTO> pageStudent(Page<?> pageInfo, @Param("name") String name);

}
