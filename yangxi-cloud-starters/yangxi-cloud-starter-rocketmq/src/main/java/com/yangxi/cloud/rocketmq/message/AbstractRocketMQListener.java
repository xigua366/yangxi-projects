package com.yangxi.cloud.rocketmq.message;

import com.yangxi.cloud.framework.web.constant.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @author yangxi
 * @version 1.0
 */
public abstract class AbstractRocketMQListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        try {
            // mq消费方统一处理header信息
            String tenantId = message.getProperty(TenantContextConstant.TENANT_ID);
            if(tenantId != null && !"".equals(tenantId)) {
                TenantContext.setTenantId(tenantId);
            }

            // 消费业务消息
            handMessage(message);
        } finally {
            // 清空上下文
            TenantContext.clear();
        }
    }

    /**
     * 处理消息
     * @param message
     */
    protected abstract void handMessage(MessageExt message);
}