package com.payn.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

	// private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	// @Autowired
	// private ObjectMapper mapper;

	//自定义登录成功逻辑
	//要改变默认的处理成功逻辑很简单，只需要实现org.springframework.security.web.authentication.AuthenticationSuccessHandler接口的onAuthenticationSuccess方法即可：
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException {
		// response.setContentType("application/json;charset=utf-8");
		// response.getWriter().write(mapper.writeValueAsString(authentication));
		// SavedRequest savedRequest = requestCache.getRequest(request, response);
		// System.out.println(savedRequest.getRedirectUrl());
		// redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
		
		redirectStrategy.sendRedirect(request, response, "/index");
		//通过上面配置，登录成功后页面将跳转回引发跳转的页面。如果想指定跳转的页面，比如跳转到/index，可以将savedRequest.getRedirectUrl()修改为/index：
	}
}
