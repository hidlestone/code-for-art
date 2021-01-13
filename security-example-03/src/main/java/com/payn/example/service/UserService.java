package com.payn.example.service;

import com.payn.example.dao.UserDao;
import com.payn.example.domain.SysUser;
import com.payn.example.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public SysUser create(SysUser sysUser) {
		//进行加密
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		sysUser.setPassword(encoder.encode(MD5Util.encode(sysUser.getRawPassword().trim())));
		userDao.create(sysUser);
		return sysUser;
	}

}
