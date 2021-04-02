package com.yangxi.cloud.rocketmq.client;

import com.yangxi.cloud.framework.web.constant.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.apache.rocketmq.common.message.Message;

/**
 * @author yangxi
 * @version 1.0
 */
public class MQMessage extends Message {

    public MQMessage() {
        putTenantId();
    }

    public MQMessage(String topic, byte[] body) {
        super(topic, body);
        putTenantId();
    }

    public MQMessage(String topic, String tags, String keys, int flag, byte[] body, boolean waitStoreMsgOK) {
        super(topic, tags, keys, flag, body, waitStoreMsgOK);
        putTenantId();
    }

    public MQMessage(String topic, String tags, byte[] body) {
        super(topic, tags, body);
        putTenantId();
    }

    public MQMessage(String topic, String tags, String keys, byte[] body) {
        super(topic, tags, keys, body);
        putTenantId();
    }

    private void putTenantId() {
        String tenantId = TenantContext.getTenantId();
        if(tenantId != null && !"".equals(tenantId)) {
            super.putUserProperty(TenantContextConstant.TENANT_ID, tenantId);
        }
    }
}