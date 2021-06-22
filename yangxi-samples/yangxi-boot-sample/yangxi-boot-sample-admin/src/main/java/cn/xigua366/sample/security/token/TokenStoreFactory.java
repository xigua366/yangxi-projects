package cn.xigua366.sample.security.token;

import cn.xigua366.sample.security.SecurityProperties;
import cn.xigua366.sample.security.token.store.*;
import cn.xigua366.sample.security.token.store.impl.JwtTokenStore;
import cn.xigua366.sample.security.token.store.impl.MemoryTokenStore;
import cn.xigua366.sample.security.token.store.impl.MysqlTokenStore;
import cn.xigua366.sample.security.token.store.impl.RedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 15:56
 */
@Component
public class TokenStoreFactory {

    @Autowired
    private JwtTokenStore jwtTokenStore;

    @Autowired
    private MysqlTokenStore mysqlTokenStore;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @Autowired
    private MemoryTokenStore memoryTokenStore;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 生成tokenStore存储
     *
     * @return
     */
    public TokenStore createTokenStore() {
        String tokenType = securityProperties.getTokenType();
        if(TokenType.JWT.name().equalsIgnoreCase(tokenType)) {
            return jwtTokenStore;
        }

        if(TokenType.REDIS.name().equalsIgnoreCase(tokenType)) {
            return redisTokenStore;
        }

        if(TokenType.MYSQL.name().equalsIgnoreCase(tokenType)) {
            return mysqlTokenStore;
        }

        return memoryTokenStore;
    }

}
