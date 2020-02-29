package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.ApplyDynaSqlProvider;
import com.ctgu.ssm.entity.Apply;

public interface ApplyDao {

	// 动态插入
	@SelectProvider(type=ApplyDynaSqlProvider.class,method="insertApply")
	void insertApply(Apply apply);

	// 动态修改
	@SelectProvider(type=ApplyDynaSqlProvider.class,method="updateApply")
	void updateApply(Apply apply);

	// 查找所有
	@Select("select * from " +  "apply" )
	List<Apply> findAllApply();

	// 动态查询
	@SelectProvider(type=ApplyDynaSqlProvider.class,method="selectApply")
	List<Apply> findApplyBySome(Apply apply);

	// 根据id查询和删除
	@Select("select * from "+ "apply" +" where id = #{id}")
	Apply findById(Integer id);

	@Select("delete from "+ "apply" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据itemid查询和删除
	@Select("select * from "+ "apply" +" where itemid = #{itemid}")
	Apply findByItemid(Integer itemid);

	@Select("delete from "+ "apply" +" where itemid = #{itemid}")
	void deleteByItemid(Integer itemid);


	// 根据userid查询和删除
	@Select("select * from "+ "apply" +" where userid = #{userid}")
	Apply findByUserid(Integer userid);

	@Select("delete from "+ "apply" +" where userid = #{userid}")
	void deleteByUserid(Integer userid);


	// 根据auditid查询和删除
	@Select("select * from "+ "apply" +" where auditid = #{auditid}")
	Apply findByAuditid(Integer auditid);

	@Select("delete from "+ "apply" +" where auditid = #{auditid}")
	void deleteByAuditid(Integer auditid);


	// 根据createtime查询和删除
	@Select("select * from "+ "apply" +" where createtime = #{createtime}")
	Apply findByCreatetime(String createtime);

	@Select("delete from "+ "apply" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}