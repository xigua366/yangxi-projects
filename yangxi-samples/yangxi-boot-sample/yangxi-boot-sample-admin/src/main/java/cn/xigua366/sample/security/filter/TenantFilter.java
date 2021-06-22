package cn.xigua366.sample.security.filter;

import com.yangxi.cloud.framework.web.constants.WebConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 租户ID处理过滤器
 *
 * @author yangxi
 * @version 1.0
 * @date 2020-11-20 16:54
 */
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            // 租户ID
            String tenantId = request.getHeader(WebConstant.TENANT_ID);
            if (tenantId == null || "".equals(tenantId)) {
                tenantId = request.getParameter(WebConstant.TENANT_ID);
            }

            // 存储tenantId
            if (tenantId != null && !"".equals(tenantId)) {
                TenantContext.setTenantId(tenantId);
            }

            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }

}