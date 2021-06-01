package ${package}.config;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.web.utils.CommonUtil;
import ${package}.domain.LoginUser;
import ${package}.exception.BizErrorCodeEnum;
import ${package}.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

        String accessToken = request.getHeader("token");
        if(accessToken == null) {
            accessToken = request.getParameter("token");
        }

        if(StringUtils.isNotBlank(accessToken)) {
            //不为空
            Claims claims = JWTUtil.checkJWT(accessToken);
            if(claims == null){
                //未登录
                CommonUtil.sendJsonMessage(response, JsonData.buildError(BizErrorCodeEnum.ACCOUNT_UNLOGIN));
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

        CommonUtil.sendJsonMessage(response, JsonData.buildError(BizErrorCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 每次请求完成后都清空一下
        logUserThreadLocal.remove();
    }
}