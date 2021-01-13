package com.payn.example.dao;

import com.payn.example.domain.SysUser;

public interface UserDao {
	SysUser findByUserName(String username);
}
