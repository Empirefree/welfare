package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Admin;

public interface AdminService {


	// 添加
	void addAdmin(Admin admin);

	// 更新
	void updateAdmin(Admin admin);

	// 找到所有对象
	List<Admin> findAllAdmin();

	// 根据一个抽象对象找到所有符合要求的对象
	List<Admin> findAdminBySome(Admin admin);


	// 根据id查找
	Admin findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据username查找
	Admin findByUsername(String username);

	// 根据username删除
	void deleteByUsername(String username);

	// 根据password查找
	Admin findByPassword(String password);

	// 根据password删除
	void deleteByPassword(String password);

	// 根据adminname查找
	Admin findByAdminname(String adminname);

	// 根据adminname删除
	void deleteByAdminname(String adminname);


}