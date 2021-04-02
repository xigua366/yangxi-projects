package com.yangxi.cloud.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangxi.cloud.framework.core.PageResult;
import com.yangxi.cloud.framework.utils.ObjectCloneUtil;
import com.yangxi.cloud.sample.dao.SchoolDAO;
import com.yangxi.cloud.sample.domain.dto.PageSchoolDTO;
import com.yangxi.cloud.sample.domain.dto.SchoolDTO;
import com.yangxi.cloud.sample.domain.entity.SchoolDO;
import com.yangxi.cloud.sample.domain.query.PageSchoolQuery;
import com.yangxi.cloud.sample.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangxi
 * @version 1.0
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDAO schoolDAO;

    /**
     * 根据ID查询学校信息
     * @param id
     * @return
     */
    @Override
    public SchoolDTO getSchoolById(Long id) {
        SchoolDO schoolDO = schoolDAO.getById(id);
        if(schoolDO == null) {
            return null;
        }
        return schoolDO.clone(SchoolDTO.class);
    }

    /**
     *
     * 主要演示直接使用BaseMapper的分页查询API进行单表分页查询，以及使用ObjectCloneUtils工具直接clone mybatis plus的IPage对象
     *
     * 分页查询学校列表
     * @param pageSchoolQuery
     * @return
     */
    @Override
    public PageResult<SchoolDTO> pageSchool(PageSchoolQuery pageSchoolQuery) {
        Page<SchoolDO> pageParam = new Page<SchoolDO>(pageSchoolQuery.getPage(), pageSchoolQuery.getSize());
        IPage<SchoolDO> page = schoolDAO.page(pageParam, new QueryWrapper<SchoolDO>().like("name", pageSchoolQuery.getSchoolName()));
        // 可以使用ObjectCloneUtils工具类直接clone IPage对象
        IPage<SchoolDTO> targetPage = ObjectCloneUtil.convertPage(page, SchoolDTO.class);
        // 上面的是浅拷贝操作，如果有深拷贝的需要，使用有cloneDirection参数的方法即可，如下
        // IPage<SchoolDTO> targetPage = ObjectCloneUtils.convertPage(page, SchoolDTO.class, CloneDirection.OPPOSITE);

        PageResult<SchoolDTO> pageResult = new PageResult<>(targetPage);
        return pageResult;
    }

    /**
     *
     * 分页查询可以直接在Mapper.xml文件中指定返回DTO对象。
     *
     * 根据名称模糊查询学校信息并分页
     *
     * @param pageSchoolQuery
     * @return
     */
    @Override
    public PageResult<PageSchoolDTO> pageSchool2(PageSchoolQuery pageSchoolQuery) {
        IPage<PageSchoolDTO> page = schoolDAO.pageSchool2(pageSchoolQuery.getPage(), pageSchoolQuery.getSize(), pageSchoolQuery.getSchoolName());
        return new PageResult<>(page);
    }
}