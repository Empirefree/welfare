package com.ctgu.ssm.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.UserDao;
import com.ctgu.ssm.entity.User;
import com.ctgu.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	// 添加
	@Override
	public void addUser(User user){
		userDao.insertUser(user);
	}

	// 更新
	@Override
	public void updateUser(User user){
		userDao.updateUser(user);
	}

	// 找到所有对象
	@Override
	public List<User> findAllUser(){
		return userDao.findAllUser();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<User> findUserBySome(User user){
		return userDao.findUserBySome(user);
	}

	// 根据id查找
	@Override
	public User findById(Integer id){
		return userDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		userDao.deleteById(id);
	}

	// 根据username查找
	@Override
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	// 根据username删除
	@Override
	public void deleteByUsername(String username){
		userDao.findByUsername(username);
	}

	// 根据password查找
	@Override
	public User findByPassword(String password){
		return userDao.findByPassword(password);
	}

	// 根据password删除
	@Override
	public void deleteByPassword(String password){
		userDao.findByPassword(password);
	}

	// 根据actualname查找
	@Override
	public User findByActualname(String actualname){
		return userDao.findByActualname(actualname);
	}

	// 根据actualname删除
	@Override
	public void deleteByActualname(String actualname){
		userDao.findByActualname(actualname);
	}

	// 根据sex查找
	@Override
	public User findBySex(String sex){
		return userDao.findBySex(sex);
	}

	// 根据sex删除
	@Override
	public void deleteBySex(String sex){
		userDao.findBySex(sex);
	}

	// 根据province查找
	@Override
	public User findByProvince(String province){
		return userDao.findByProvince(province);
	}

	// 根据province删除
	@Override
	public void deleteByProvince(String province){
		userDao.findByProvince(province);
	}

	// 根据city查找
	@Override
	public User findByCity(String city){
		return userDao.findByCity(city);
	}

	// 根据city删除
	@Override
	public void deleteByCity(String city){
		userDao.findByCity(city);
	}

	// 根据address查找
	@Override
	public User findByAddress(String address){
		return userDao.findByAddress(address);
	}

	// 根据address删除
	@Override
	public void deleteByAddress(String address){
		userDao.findByAddress(address);
	}

	// 根据phone查找
	@Override
	public User findByPhone(String phone){
		return userDao.findByPhone(phone);
	}

	// 根据phone删除
	@Override
	public void deleteByPhone(String phone){
		userDao.findByPhone(phone);
	}

	// 根据email查找
	@Override
	public User findByEmail(String email){
		return userDao.findByEmail(email);
	}

	// 根据email删除
	@Override
	public void deleteByEmail(String email){
		userDao.findByEmail(email);
	}

	// 根据introduce查找
	@Override
	public User findByIntroduce(String introduce){
		return userDao.findByIntroduce(introduce);
	}

	// 根据introduce删除
	@Override
	public void deleteByIntroduce(String introduce){
		userDao.findByIntroduce(introduce);
	}

	// 根据identity查找
	@Override
	public User findByIdentity(String identity){
		return userDao.findByIdentity(identity);
	}

	// 根据identity删除
	@Override
	public void deleteByIdentity(String identity){
		userDao.findByIdentity(identity);
	}

	// 根据isActualname查找
	@Override
	public User findByIsActualname(Integer isActualname){
		return userDao.findByIsActualname(isActualname);
	}

	// 根据isActualname删除
	@Override
	public void deleteByIsActualname(Integer isActualname){
		userDao.findByIsActualname(isActualname);
	}

	// 根据createtime查找
	@Override
	public User findByCreatetime(String createtime){
		return userDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		userDao.findByCreatetime(createtime);
	}


}