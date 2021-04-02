package com.yangxi.cloud.sample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangxi.cloud.sample.domain.dto.PageStudentDTO;
import com.yangxi.cloud.sample.domain.entity.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xi.yang
 * @since 2021-02-27
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentDO> {

    IPage<PageStudentDTO> pageStudent(Page<?> pageInfo, @Param("name") String name);

}
