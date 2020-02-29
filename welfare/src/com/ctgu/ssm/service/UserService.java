package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.User;

public interface UserService {

	// 添加
	void addUser(User user);

	// 更新
	void updateUser(User user);

	// 找到所有对象
	List<User> findAllUser();

	// 根据一个抽象对象找到所有符合要求的对象
	List<User> findUserBySome(User user);


	// 根据id查找
	User findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据username查找
	User findByUsername(String username);

	// 根据username删除
	void deleteByUsername(String username);

	// 根据password查找
	User findByPassword(String password);

	// 根据password删除
	void deleteByPassword(String password);

	// 根据actualname查找
	User findByActualname(String actualname);

	// 根据actualname删除
	void deleteByActualname(String actualname);

	// 根据sex查找
	User findBySex(String sex);

	// 根据sex删除
	void deleteBySex(String sex);

	// 根据province查找
	User findByProvince(String province);

	// 根据province删除
	void deleteByProvince(String province);

	// 根据city查找
	User findByCity(String city);

	// 根据city删除
	void deleteByCity(String city);

	// 根据address查找
	User findByAddress(String address);

	// 根据address删除
	void deleteByAddress(String address);

	// 根据phone查找
	User findByPhone(String phone);

	// 根据phone删除
	void deleteByPhone(String phone);

	// 根据email查找
	User findByEmail(String email);

	// 根据email删除
	void deleteByEmail(String email);

	// 根据introduce查找
	User findByIntroduce(String introduce);

	// 根据introduce删除
	void deleteByIntroduce(String introduce);

	// 根据identity查找
	User findByIdentity(String identity);

	// 根据identity删除
	void deleteByIdentity(String identity);

	// 根据isActualname查找
	User findByIsActualname(Integer isActualname);

	// 根据isActualname删除
	void deleteByIsActualname(Integer isActualname);

	// 根据createtime查找
	User findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}