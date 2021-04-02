package com.yangxi.cloud.rocketmq.client;

import com.yangxi.cloud.framework.web.constant.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Map;

/**
 * @author yangxi
 * @version 1.0
 */
public abstract class AbstractMessageListenerConcurrently implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(final List<MessageExt> msgs, final ConsumeConcurrentlyContext context) {
        try {
            Map<String, String> map = msgs.get(0).getProperties();
            String tenantId = "";
            if(map != null) {
                tenantId = map.get(TenantContextConstant.TENANT_ID);
            }
            if(tenantId == null || "".equals(tenantId)) {
                TenantContext.setTenantId(tenantId);
            }
            return onMessage(msgs, context);
        } finally {
            TenantContext.clear();
        }
    }

    public abstract ConsumeConcurrentlyStatus onMessage(final List<MessageExt> msgs, final ConsumeConcurrentlyContext context);
}