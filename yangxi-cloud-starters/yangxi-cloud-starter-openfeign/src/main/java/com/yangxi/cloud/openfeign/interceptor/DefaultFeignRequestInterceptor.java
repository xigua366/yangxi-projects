package com.yangxi.cloud.openfeign.interceptor;

import com.yangxi.cloud.framework.web.constant.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 默认的openfeign拦截器组件
 *
 * @author yangxi
 */
public class DefaultFeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        // feign调用下游服务默认增加的header信息
        String tenantId = TenantContext.getTenantId();

        if(tenantId != null && !"".equals(tenantId)) {
            template.header(TenantContextConstant.TENANT_ID, tenantId);
        }
    }

}