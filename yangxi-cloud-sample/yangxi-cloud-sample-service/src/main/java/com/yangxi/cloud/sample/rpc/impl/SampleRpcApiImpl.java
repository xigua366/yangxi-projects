package com.yangxi.cloud.sample.rpc.impl;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.PageResult;
import com.yangxi.cloud.sample.domain.dto.DemoDTO;
import com.yangxi.cloud.sample.domain.query.DemoQuery;
import com.yangxi.cloud.sample.domain.request.AddDemoRequest;
import com.yangxi.cloud.sample.domain.request.UpdateDemoRequest;
import com.yangxi.cloud.sample.rpc.SampleRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@RestController
public class SampleRpcApiImpl implements SampleRpc {

    @Override
    public JsonData<DemoDTO> getDemo(@PathVariable("demoId") Long demoId) {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(demoId);
        demoDTO.setDemoName("zhangsan");
        return JsonData.buildSuccess(demoDTO);
    }

    @Override
    public JsonData<PageResult<DemoDTO>> pageDemo(@SpringQueryMap DemoQuery demoQuery) {
        List<DemoDTO> list = new ArrayList<>();
        DemoDTO demoDTO1 = new DemoDTO();
        demoDTO1.setId(1L);
        demoDTO1.setDemoName("zhangsan");

        DemoDTO demoDTO2 = new DemoDTO();
        demoDTO2.setId(1L);
        demoDTO2.setDemoName("lisi");

        list.add(demoDTO1);
        list.add(demoDTO2);
        return JsonData.buildSuccess(new PageResult<>(list));
    }

    @Override
    public JsonData<Boolean> addDemo(@RequestBody AddDemoRequest addDemoRequest) {
        return null;
    }

    @Override
    public JsonData<Boolean> updateDemo(@RequestBody UpdateDemoRequest updateDemoRequest) {
        return null;
    }

    @Override
    public JsonData<Boolean> deleteDemo(@PathVariable("demoId") Long demoId) {
        return null;
    }
}