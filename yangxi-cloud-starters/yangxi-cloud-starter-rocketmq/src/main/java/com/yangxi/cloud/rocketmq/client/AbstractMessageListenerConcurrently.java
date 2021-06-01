package com.yangxi.cloud.rocketmq.client;

import com.yangxi.cloud.framework.web.constants.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Apache Rocketmq原生客户端消费者扩展组件
 * 主要用于自动传递多租户TenantId信息
 * </p>
 *
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