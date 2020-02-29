package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.ActTypeDynaSqlProvider;
import com.ctgu.ssm.entity.ActType;

public interface ActTypeDao {

	// 动态插入
	@SelectProvider(type=ActTypeDynaSqlProvider.class,method="insertActType")
	void insertActType(ActType actType);

	// 动态修改
	@SelectProvider(type=ActTypeDynaSqlProvider.class,method="updateActType")
	void updateActType(ActType actType);

	// 查找所有
	@Select("select * from " +  "acttype" )
	List<ActType> findAllActType();

	// 动态查询
	@SelectProvider(type=ActTypeDynaSqlProvider.class,method="selectActType")
	List<ActType> findActTypeBySome(ActType actType);

	// 根据id查询和删除
	@Select("select * from "+ "acttype" +" where id = #{id}")
	ActType findById(Integer id);

	@Select("delete from "+ "acttype" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据actname查询和删除
	@Select("select * from "+ "acttype" +" where actname = #{actname}")
	ActType findByActname(String actname);

	@Select("delete from "+ "acttype" +" where actname = #{actname}")
	void deleteByActname(String actname);


}