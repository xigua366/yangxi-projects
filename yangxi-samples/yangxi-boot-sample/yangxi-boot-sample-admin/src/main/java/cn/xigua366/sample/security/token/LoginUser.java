package cn.xigua366.sample.security.token;

import com.yangxi.cloud.framework.web.domain.AbstractLoginUser;
import lombok.Data;

import java.util.Date;

/**
 * 后台管理运营系统登录用户信息
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-23 11:31
 */
@Data
public class LoginUser extends AbstractLoginUser {


    private static final long serialVersionUID = 1940949150597042977L;

    /**
     * 是否管理员
     */
    private boolean admin;
}
