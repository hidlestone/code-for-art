package com.payn.example.controller;

import com.payn.example.domain.SysUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value = "/login")
	@ResponseBody
	//用户名密码是用base64 加密 原文为 admin:admin 即 用户名:密码  内容是放在request.getHeader 的 "authorization" 中
	public Object login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
		if (logout != null) {
			return null;
		}
		if (loginedUser != null) {
			return loginedUser;
		}
		return null;
	}
}
