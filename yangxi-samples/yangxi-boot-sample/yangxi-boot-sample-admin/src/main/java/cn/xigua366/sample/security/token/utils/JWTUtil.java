package cn.xigua366.sample.security.token.utils;

import cn.xigua366.sample.security.exception.TokenErrorException;
import cn.xigua366.sample.security.exception.TokenExpiredException;
import cn.xigua366.sample.security.token.LoginUser;
import com.yangxi.cloud.framework.utils.JsonUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * Jwt工具类
 *
 * 注意点:
 * 1、生成的token, 是可以通过base64进行解密出明文信息
 * 2、base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3、无法作废已颁布的token，除非改秘钥
 * 4、一般借助redis存储来失效jwt令牌
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JWTUtil {

    /**
     * 过期时间（单位毫秒）
     * 默认是30天
     */
    public static final long EXPIRE = 30 * 24 * 60 * 60 * 1000L;
//    private  static final long EXPIRE = 10 * 60 * 1000;


    /**
     * 加密秘钥
     */
    private  static final String SECRET = "xi.yang";


    /**
     * 令牌前缀
     */
    private  static final String TOKEN_PREFIX = "yangxi";


    /**
     * subject
     */
    private  static final String SUBJECT = "yangxi";

    private final static String JWT_TOKEN_CLAIMS_LOGIN_USER = "login_user";

    /**
     * 创建令牌
     *
     * @param loginUser 登录用户信息
     * @return 令牌字符串
     */
    public static String createToken(LoginUser loginUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JWT_TOKEN_CLAIMS_LOGIN_USER, loginUser);
        return generateToken(loginUser.getUsername(), claims);
    }

    /**
     * 基于用户信息生成一个token
     *
     * @param username 用户名
     * @param claims 令牌附属信息
     * @return
     */
    private static String generateToken(String username, Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString().replace("-", ""))
                .setSubject(SUBJECT)
                .setIssuedAt(new Date())
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes(StandardCharsets.UTF_8))
                .compact();

        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 生成令牌过期时间
     *
     * @return 令牌过期时间
     */
    public static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRE);
    }

    /**
     * 解析令牌
     *
     * @param token 令牌
     * @return 提取的用户信息
     */
    public static LoginUser parseToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            Date expiration = claims.getExpiration();

            Object _loginUser = claims.get(JWT_TOKEN_CLAIMS_LOGIN_USER);
            if(_loginUser != null) {
                LoginUser loginUser = JsonUtil.json2Object(JsonUtil.object2Json(_loginUser), LoginUser.class);
                if(loginUser != null) {
                    loginUser.setExpiration(expiration);
                }
                return loginUser;
            }
        } catch(ExpiredJwtException e) {
            throw new TokenExpiredException("令牌已过期", e);
        } catch(Exception e) {
            throw new TokenErrorException("错误的令牌", e);
        }
        return null;
    }


    // 刷新令牌
    public static String refreshToken() {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(1L);
        loginUser.setUsername("zhangsan");
        loginUser.setRealName("张三");
        loginUser.setHeadImg("1.png");
        loginUser.setPhone("13826431140");
        loginUser.setMail("demo@qq.com");
        loginUser.setAdmin(true);

        String token = createToken(loginUser);
        System.out.println(token);
    }
}