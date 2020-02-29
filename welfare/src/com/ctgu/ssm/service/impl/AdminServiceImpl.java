package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.AdminDao;
import com.ctgu.ssm.entity.Admin;
import com.ctgu.ssm.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;

	// 添加
	@Override
	public void addAdmin(Admin admin){
		adminDao.insertAdmin(admin);
	}

	// 更新
	@Override
	public void updateAdmin(Admin admin){
		adminDao.updateAdmin(admin);
	}

	// 找到所有对象
	@Override
	public List<Admin> findAllAdmin(){
		return adminDao.findAllAdmin();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Admin> findAdminBySome(Admin admin){
		return adminDao.findAdminBySome(admin);
	}

	// 根据id查找
	@Override
	public Admin findById(Integer id){
		return adminDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		adminDao.deleteById(id);
	}

	// 根据username查找
	@Override
	public Admin findByUsername(String username){
		return adminDao.findByUsername(username);
	}

	// 根据username删除
	@Override
	public void deleteByUsername(String username){
		adminDao.findByUsername(username);
	}

	// 根据password查找
	@Override
	public Admin findByPassword(String password){
		return adminDao.findByPassword(password);
	}

	// 根据password删除
	@Override
	public void deleteByPassword(String password){
		adminDao.findByPassword(password);
	}

	// 根据adminname查找
	@Override
	public Admin findByAdminname(String adminname){
		return adminDao.findByAdminname(adminname);
	}

	// 根据adminname删除
	@Override
	public void deleteByAdminname(String adminname){
		adminDao.findByAdminname(adminname);
	}


}