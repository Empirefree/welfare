package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.UserDynaSqlProvider;
import com.ctgu.ssm.entity.User;

public interface UserDao {

	// 动态插入
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void insertUser(User user);

	// 动态修改
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void updateUser(User user);

	// 查找所有
	@Select("select * from " +  "user" )
	List<User> findAllUser();

	// 动态查询
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectUser")
	List<User> findUserBySome(User user);

	// 根据id查询和删除
	@Select("select * from "+ "user" +" where id = #{id}")
	User findById(Integer id);

	@Select("delete from "+ "user" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据username查询和删除
	@Select("select * from "+ "user" +" where username = #{username}")
	User findByUsername(String username);

	@Select("delete from "+ "user" +" where username = #{username}")
	void deleteByUsername(String username);


	// 根据password查询和删除
	@Select("select * from "+ "user" +" where password = #{password}")
	User findByPassword(String password);

	@Select("delete from "+ "user" +" where password = #{password}")
	void deleteByPassword(String password);


	// 根据actualname查询和删除
	@Select("select * from "+ "user" +" where actualname = #{actualname}")
	User findByActualname(String actualname);

	@Select("delete from "+ "user" +" where actualname = #{actualname}")
	void deleteByActualname(String actualname);


	// 根据sex查询和删除
	@Select("select * from "+ "user" +" where sex = #{sex}")
	User findBySex(String sex);

	@Select("delete from "+ "user" +" where sex = #{sex}")
	void deleteBySex(String sex);


	// 根据province查询和删除
	@Select("select * from "+ "user" +" where province = #{province}")
	User findByProvince(String province);

	@Select("delete from "+ "user" +" where province = #{province}")
	void deleteByProvince(String province);


	// 根据city查询和删除
	@Select("select * from "+ "user" +" where city = #{city}")
	User findByCity(String city);

	@Select("delete from "+ "user" +" where city = #{city}")
	void deleteByCity(String city);


	// 根据address查询和删除
	@Select("select * from "+ "user" +" where address = #{address}")
	User findByAddress(String address);

	@Select("delete from "+ "user" +" where address = #{address}")
	void deleteByAddress(String address);


	// 根据phone查询和删除
	@Select("select * from "+ "user" +" where phone = #{phone}")
	User findByPhone(String phone);

	@Select("delete from "+ "user" +" where phone = #{phone}")
	void deleteByPhone(String phone);


	// 根据email查询和删除
	@Select("select * from "+ "user" +" where email = #{email}")
	User findByEmail(String email);

	@Select("delete from "+ "user" +" where email = #{email}")
	void deleteByEmail(String email);


	// 根据introduce查询和删除
	@Select("select * from "+ "user" +" where introduce = #{introduce}")
	User findByIntroduce(String introduce);

	@Select("delete from "+ "user" +" where introduce = #{introduce}")
	void deleteByIntroduce(String introduce);


	// 根据identity查询和删除
	@Select("select * from "+ "user" +" where identity = #{identity}")
	User findByIdentity(String identity);

	@Select("delete from "+ "user" +" where identity = #{identity}")
	void deleteByIdentity(String identity);


	// 根据isActualname查询和删除
	@Select("select * from "+ "user" +" where i_actualname = #{isActualname}")
	User findByIsActualname(Integer isActualname);

	@Select("delete from "+ "user" +" where i_actualname = #{isActualname}")
	void deleteByIsActualname(Integer isActualname);


	// 根据createtime查询和删除
	@Select("select * from "+ "user" +" where createtime = #{createtime}")
	User findByCreatetime(String createtime);

	@Select("delete from "+ "user" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}