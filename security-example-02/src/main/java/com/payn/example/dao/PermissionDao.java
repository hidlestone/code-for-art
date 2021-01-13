package com.payn.example.dao;

import com.payn.example.domain.Permission;

import java.util.List;

public interface PermissionDao {
	List<Permission> findAll();

	List<Permission> findByAdminUserId(int userId);
}
