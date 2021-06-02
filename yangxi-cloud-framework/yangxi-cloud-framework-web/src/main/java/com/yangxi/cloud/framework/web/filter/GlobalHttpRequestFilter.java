package com.yangxi.cloud.framework.web.filter;

import com.yangxi.cloud.framework.web.support.CustomHttpServletRequestWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 通用全局过滤器
 * 拦截处理HttpServletRequest中的请求参数
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class GlobalHttpRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        CustomHttpServletRequestWrapper requestWrapper = new CustomHttpServletRequestWrapper(request);

        // 给page & size设置默认值
        String page = requestWrapper.getParameter("page");
        if(page != null) {
            if("".equals(page)) {
                requestWrapper.addParameter("page", 1);
            }
            String size = requestWrapper.getParameter("size");
            if(size == null || "".equals(size)) {
                requestWrapper.addParameter("size", 10);
            }
            filterChain.doFilter(requestWrapper, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }
}