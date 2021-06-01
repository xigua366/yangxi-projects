package com.yangxi.cloud.sample.rpc;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.PageResult;
import com.yangxi.cloud.sample.domain.dto.DemoDTO;
import com.yangxi.cloud.sample.domain.query.DemoQuery;
import com.yangxi.cloud.sample.domain.request.AddDemoRequest;
import com.yangxi.cloud.sample.domain.request.UpdateDemoRequest;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 服务间内部调用的Rpc接口示例
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@RequestMapping("/rpc/v1/demo")
public interface SampleRpc {

    /**
     * 根据ID查询信息
     * @param demoId
     * @return
     */
    @GetMapping("/{demoId}")
    JsonData<DemoDTO> getDemo(@PathVariable("demoId") Long demoId);

    /**
     * 分页查询信息
     * @param demoQuery
     * @return
     */
    @GetMapping("/page")
    JsonData<PageResult<DemoDTO>> pageDemo(@SpringQueryMap DemoQuery demoQuery);

    /**
     * 新增
     * @param addDemoRequest
     * @return
     */
    @PostMapping
    JsonData<Boolean> addDemo(@RequestBody AddDemoRequest addDemoRequest);

    /**
     * 修改
     * @param updateDemoRequest
     * @return
     */
    @PutMapping
    JsonData<Boolean> updateDemo(@RequestBody UpdateDemoRequest updateDemoRequest);

    /**
     * 删除
     * @param demoId
     * @return
     */
    @DeleteMapping("/{demoId}")
    JsonData<Boolean> deleteDemo(@PathVariable("demoId") Long demoId);

}