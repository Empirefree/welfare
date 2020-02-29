package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.AuditType;

public interface AuditTypeService {

	// 添加
	void addAuditType(AuditType auditType);

	// 更新
	void updateAuditType(AuditType auditType);

	// 找到所有对象
	List<AuditType> findAllAuditType();

	// 根据一个抽象对象找到所有符合要求的对象
	List<AuditType> findAuditTypeBySome(AuditType auditType);


	// 根据id查找
	AuditType findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据auditName查找
	AuditType findByAuditName(String auditName);

	// 根据auditName删除
	void deleteByAuditName(String auditName);


}