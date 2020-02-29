package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.AdminDynaSqlProvider;

import com.ctgu.ssm.entity.Admin;

public interface AdminDao {

	// 动态插入
	@SelectProvider(type=AdminDynaSqlProvider.class,method="insertAdmin")
	void insertAdmin(Admin admin);

	// 动态修改
	@SelectProvider(type=AdminDynaSqlProvider.class,method="updateAdmin")
	void updateAdmin(Admin admin);

	// 查找所有
	@Select("select * from " + "admin")
	List<Admin> findAllAdmin();

	// 动态查询
	@SelectProvider(type=AdminDynaSqlProvider.class,method="selectAdmin")
	List<Admin> findAdminBySome(Admin admin);

	// 根据id查询和删除
	@Select("select * from "+"admin"+" where id = #{id}")
	Admin findById(Integer id);

	@Select("delete from "+"admin"+" where id = #{id}")
	void deleteById(Integer id);


	// 根据username查询和删除
	@Select("select * from "+"admin"+" where username = #{username}")
	Admin findByUsername(String username);

	@Select("delete from "+"admin"+" where username = #{username}")
	void deleteByUsername(String username);


	// 根据password查询和删除
	@Select("select * from "+"admin"+" where password = #{password}")
	Admin findByPassword(String password);

	@Select("delete from "+"admin"+" where password = #{password}")
	void deleteByPassword(String password);


	// 根据adminname查询和删除
	@Select("select * from "+"admin"+" where adminname = #{adminname}")
	Admin findByAdminname(String adminname);

	@Select("delete from "+"admin"+" where adminname = #{adminname}")
	void deleteByAdminname(String adminname);


}