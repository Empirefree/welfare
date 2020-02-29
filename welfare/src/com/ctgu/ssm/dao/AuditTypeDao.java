package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.AuditTypeDynaSqlProvider;
import com.ctgu.ssm.entity.AuditType;

public interface AuditTypeDao {

	// 动态插入
	@SelectProvider(type=AuditTypeDynaSqlProvider.class,method="insertAuditType")
	void insertAuditType(AuditType auditType);

	// 动态修改
	@SelectProvider(type=AuditTypeDynaSqlProvider.class,method="updateAuditType")
	void updateAuditType(AuditType auditType);

	// 查找所有
	@Select("select * from " +  "audit_type" )
	List<AuditType> findAllAuditType();

	// 动态查询
	@SelectProvider(type=AuditTypeDynaSqlProvider.class,method="selectAuditType")
	List<AuditType> findAuditTypeBySome(AuditType auditType);

	// 根据id查询和删除
	@Select("select * from "+ "audit_type" +" where id = #{id}")
	AuditType findById(Integer id);

	@Select("delete from "+ "audit_type" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据auditName查询和删除
	@Select("select * from "+ "audit_type" +" where audi_name = #{auditName}")
	AuditType findByAuditName(String auditName);

	@Select("delete from "+ "audit_type" +" where audi_name = #{auditName}")
	void deleteByAuditName(String auditName);


}