package cn.xigua366.sample.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认的系统安全相关处理Controller组件
 * @author yangxi
 * @version 1.0
 * @date 2020-11-20 16:02
 */
@Slf4j
@RestController
public class DefaultSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @GetMapping("/loginPage")
    public Map<String, Object> loginPage(HttpServletRequest request, HttpServletResponse response) {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.warn("引发跳转的请求是:" + targetUrl);
        }

        Map<String, Object> returnObj = new HashMap<>();
        returnObj.put("code", "301");
        returnObj.put("msg", "请先登录");
        return returnObj;
    }

}
