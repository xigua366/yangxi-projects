package cn.xigua366.sample.config;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.yangxi.cloud.framework.annotation.AuthIgnore;
import com.yangxi.cloud.framework.core.JsonData;
import cn.xigua366.sample.domain.LoginUser;
import cn.xigua366.sample.exception.BizErrorCodeEnum;
import cn.xigua366.sample.utils.JWTUtil;
import com.yangxi.cloud.framework.web.utils.ServletUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 登录拦截器
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 登录用户上下文信息
     */
    public static ThreadLocal<LoginUser> logUserThreadLocal = new TransmittableThreadLocal<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        AuthIgnore authIgnore = null;
        if(handler instanceof HandlerMethod) {
            authIgnore = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        }

        //如果有@AuthIgnore注解，则也不验证token
        if(authIgnore != null) {
            return true;
        }

        String accessToken = request.getHeader("token");
        if(accessToken == null) {
            accessToken = request.getParameter("token");
        }

        if(StringUtils.isNotBlank(accessToken)) {
            //不为空
            Claims claims = JWTUtil.checkJWT(accessToken);
            if(claims == null){
                //未登录
                ServletUtil.sendJsonMessage(response, JsonData.buildError(BizErrorCodeEnum.ACCOUNT_UNLOGIN));
                return false;
            }

            Long userId = Long.parseLong(claims.get("id").toString());
            String headImg = (String)claims.get("head_img");
            String name = (String)claims.get("name");
            String mail = (String)claims.get("mail");
            String phone = (String)claims.get("phone");

            LoginUser loginUser = new LoginUser();
            loginUser.setName(name);
            loginUser.setHeadImg(headImg);
            loginUser.setId(userId);
            loginUser.setMail(mail);
            loginUser.setPhone(phone);

            logUserThreadLocal.set(loginUser);
            return true;
        }

        ServletUtil.sendJsonMessage(response, JsonData.buildError(BizErrorCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 每次请求完成后都清空一下
        logUserThreadLocal.remove();
    }
}