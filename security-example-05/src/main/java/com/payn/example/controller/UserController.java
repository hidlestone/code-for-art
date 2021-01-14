package com.payn.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/users")
@RestController
public class UserController {


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Object list(HttpServletRequest request) {
		return "Get all User";
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object detail(@PathVariable Integer id) {
		return "Get a user";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object create(HttpServletRequest request) {
		return "POST a user";
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Object update(HttpServletRequest request) {
		return "PUT a user";
	}

}