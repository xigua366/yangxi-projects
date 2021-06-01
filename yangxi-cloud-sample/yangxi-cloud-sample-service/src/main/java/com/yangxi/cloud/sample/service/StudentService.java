package com.yangxi.cloud.sample.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yangxi.cloud.sample.domain.dto.PageStudentDTO;
import com.yangxi.cloud.sample.domain.dto.StudentDTO;
import com.yangxi.cloud.sample.domain.query.StudentQuery;
import com.yangxi.cloud.sample.domain.request.AddStudentRequest;
import com.yangxi.cloud.sample.domain.request.UpdateStudentRequest;

/**
 * <p>
 * 学生信息Service组件
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public interface StudentService {

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    StudentDTO getStudentById(Long id);

    /**
     * 新增学生信息
     * @param addStudentRequest
     * @return
     */
    Boolean addStudent(AddStudentRequest addStudentRequest);

    /**
     * 更新学生信息
     * @param updateStudentRequest
     * @return
     */
    Boolean updateStudent(UpdateStudentRequest updateStudentRequest);

    /**
     * 根据ID删除学生信息
     * @param id
     * @return
     */
    Boolean deleteStudent(Long id);

    /**
     * 根据条件分页查询学生的基本信息（包含学校信息）
     * @param studentQuery
     */
    IPage<PageStudentDTO> pageStudent(StudentQuery studentQuery);
}