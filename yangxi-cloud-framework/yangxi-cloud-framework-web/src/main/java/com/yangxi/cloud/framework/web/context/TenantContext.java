package com.yangxi.cloud.framework.web.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * <p>
 * 租户上下文信息，用于实现多租户
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class TenantContext {

    /**
     * 租户ID
     */
    private static final ThreadLocal<String> TENANT_ID = new TransmittableThreadLocal<>();

    public static void setTenantId(String tenantId) {
        TENANT_ID.set(tenantId);
    }

    public static String getTenantId() {
        return TENANT_ID.get();
    }

    /**
     * 清空上下文信息
     */
    public static void clear() {
        TENANT_ID.remove();
    }
}