package com.yangxi.cloud.sample.dao.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxi.cloud.sample.dao.SchoolDAO;
import com.yangxi.cloud.sample.domain.dto.PageSchoolDTO;
import com.yangxi.cloud.sample.domain.entity.SchoolDO;
import com.yangxi.cloud.sample.mapper.SchoolMapper;
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
public class SchoolDAOImpl extends ServiceImpl<SchoolMapper, SchoolDO> implements SchoolDAO {

    /**
     * 根据学校名称模糊查询
     * @param page 当前页数
     * @param size 每页记录数
     * @param schoolName 查询条件
     * @return
     */
    @Override
    public IPage<PageSchoolDTO> pageSchool2(long page, long size, String schoolName) {
        Page<PageSchoolDTO> pageParam = new Page<>(page, size);
        return baseMapper.pageSchool2(pageParam, schoolName);
    }
}