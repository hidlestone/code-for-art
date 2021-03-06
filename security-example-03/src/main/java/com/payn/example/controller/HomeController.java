package com.payn.example.controller;

import com.payn.example.domain.SysUser;
import com.payn.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class HomeController {
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getUsers() {
		return "getUsers";
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody SysUser user) {
		return userService.create(user);
	}


	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String update() {
		return "updateUser";
	}


	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		return "deleteUser";
	}

}

