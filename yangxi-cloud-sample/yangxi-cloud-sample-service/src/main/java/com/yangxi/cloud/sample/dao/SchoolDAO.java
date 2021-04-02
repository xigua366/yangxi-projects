package com.yangxi.cloud.sample.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxi.cloud.sample.domain.dto.PageSchoolDTO;
import com.yangxi.cloud.sample.domain.entity.SchoolDO;

/**
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