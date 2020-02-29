package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.LeaveideaDynaSqlProvider;
import com.ctgu.ssm.entity.Leaveidea;

public interface LeaveideaDao {

	// 动态插入
	@SelectProvider(type=LeaveideaDynaSqlProvider.class,method="insertLeaveidea")
	void insertLeaveidea(Leaveidea leaveidea);

	// 动态修改
	@SelectProvider(type=LeaveideaDynaSqlProvider.class,method="updateLeaveidea")
	void updateLeaveidea(Leaveidea leaveidea);

	// 查找所有
	@Select("select * from " +  "leaveidea" )
	List<Leaveidea> findAllLeaveidea();

	// 动态查询
	@SelectProvider(type=LeaveideaDynaSqlProvider.class,method="selectLeaveidea")
	List<Leaveidea> findLeaveideaBySome(Leaveidea leaveidea);

	// 根据id查询和删除
	@Select("select * from "+ "leaveidea" +" where id = #{id}")
	Leaveidea findById(Integer id);

	@Select("delete from "+ "leaveidea" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据ideaid查询和删除
	@Select("select * from "+ "leaveidea" +" where ideaid = #{ideaid}")
	Leaveidea findByIdeaid(Integer ideaid);

	@Select("delete from "+ "leaveidea" +" where ideaid = #{ideaid}")
	void deleteByIdeaid(Integer ideaid);


	// 根据user1id查询和删除
	@Select("select * from "+ "leaveidea" +" where user1id = #{user1id}")
	Leaveidea findByUser1id(Integer user1id);

	@Select("delete from "+ "leaveidea" +" where user1id = #{user1id}")
	void deleteByUser1id(Integer user1id);


	// 根据comment查询和删除
	@Select("select * from "+ "leaveidea" +" where comment = #{comment}")
	Leaveidea findByComment(String comment);

	@Select("delete from "+ "leaveidea" +" where comment = #{comment}")
	void deleteByComment(String comment);


	// 根据isSolve查询和删除
	@Select("select * from "+ "leaveidea" +" where is_solve = #{isSolve}")
	Leaveidea findByIsSolve(Integer isSolve);

	@Select("delete from "+ "leaveidea" +" where is_solve = #{isSolve}")
	void deleteByIsSolve(Integer isSolve);


	// 根据createtime查询和删除
	@Select("select * from "+ "leaveidea" +" where createtime = #{createtime}")
	Leaveidea findByCreatetime(String createtime);

	@Select("delete from "+ "leaveidea" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}