package cn.xigua366.sample.security.authority;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 基于数据库rbac模型的url权限校验组件
 * @author yangxi
 */
@Slf4j
@Component
public class DbAuthorityChecker {

	private static final String PUBLIC_URI = "/public/";

//	private AuthorityService authorityService;
//
//	@Autowired
//	public DbAuthorityChecker(AuthorityService authorityService) {
//		this.authorityService = authorityService;
//	}

	/**
	 * API权限检查
	 * @param authentication
	 * @param request
	 * @return
	 */
	public boolean check(Authentication authentication, HttpServletRequest request) {

//		if(request != null) {
//			return true;
//		}
//
//		// 请求方式
//		String requestMethod = request.getMethod();
//		// 请求uri eg: /login
//		String requestUri = request.getRequestURI();
//
//		// 如果uri中包含/public/则无需鉴权
//		if(requestUri.contains(PUBLIC_URI)) {
//			return true;
//		}
//
//		// 没有经过认证的用户一律不放行
//		if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//			return false;
//		}
//
//		Long userId;
//		boolean admin;
//		if(authentication.getPrincipal() instanceof MyUserDetails) {
//			// 用户名密码登录认证的时候
//			MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
//			userId = myUserDetails.getUserId();
//			admin = myUserDetails.isAdmin();
//		} else if(authentication.getPrincipal() instanceof UserInfo) {
//			// token令牌认证的时候
//			UserInfo userInfo = (UserInfo) authentication.getPrincipal();
//			userId = userInfo.getUserId();
//			admin = userInfo.isAdmin();
//		} else {
//			userId = null;
//			admin = false;
//		}
//
//
//		// 检查是否管理员，管理员直接放行 TODO
//		if(admin) {
//			return true;
//		}
//
//		// 基于数据库的RBAC数据模型权限校验
//		if(userId != null) {
//			Boolean flag = authorityService.checkUserAuthorizedByUrl(userId, requestMethod, requestUri);
//			log.warn("flag:{}", flag);
//		}


		// FIXME 正常这里应该返回flag的值
		return true;
	}
}