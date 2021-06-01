package com.yangxi.cloud.sample.utils;

import com.yangxi.cloud.sample.domain.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

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
public class JWTUtil {


    /**
     * 过期时间，一个月
     */
    private  static final long EXPIRE = 60000 * 60 * 24 * 30L;
//    private  static final long EXPIRE = 10 * 60 * 1000;


    /**
     * 加密秘钥
     */
    private  static final String SECRET = "xi.yang";


    /**
     * 令牌前缀
     */
    private  static final String TOKEN_PREFIX = "yx";


    /**
     * subject
     */
    private  static final String SUBJECT = "yx";


    /**
     * 根据用户信息，生成令牌
     * @param loginUser
     * @return
     */
    public static String geneJsonWebToken(LoginUser loginUser){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", loginUser.getHeadImg())
                .claim("id", loginUser.getId())
                .claim("name", loginUser.getName())
                .claim("phone", loginUser.getPhone())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();

        token = TOKEN_PREFIX + token;


        return token;
    }


    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{

            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();

            return claims;

        }catch (Exception e){
            return null;
        }

    }



}
