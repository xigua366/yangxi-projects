package cn.xigua366.sample.security.encoder;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义加密器，使用 MD5 加密，算法与 deepexi-middle-account 对密码的加密算法一致
 *
 * @author chenjiazhan
 * @date 2019-09-19
 * @since v1.0
 */
@Slf4j
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.generate(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(StringUtils.isEmpty(encodedPassword)) {
            log.warn("Empty encoded password");
            return false;
        }

        return MD5Util.verify(rawPassword.toString(), encodedPassword);
    }

    public static void main(String[] args) {
        String generate = MD5Util.generate("123456");
        System.out.println(generate);
        System.out.println(MD5Util.verify("123456",generate));

    }
}