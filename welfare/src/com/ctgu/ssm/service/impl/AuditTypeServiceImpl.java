package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.AuditTypeDao;
import com.ctgu.ssm.entity.AuditType;
import com.ctgu.ssm.service.AuditTypeService;

@Service("auditTypeService")
public class AuditTypeServiceImpl implements AuditTypeService{

	@Autowired
	private AuditTypeDao auditTypeDao;

	// 添加
	@Override
	public void addAuditType(AuditType auditType){
		auditTypeDao.insertAuditType(auditType);
	}

	// 更新
	@Override
	public void updateAuditType(AuditType auditType){
		auditTypeDao.updateAuditType(auditType);
	}

	// 找到所有对象
	@Override
	public List<AuditType> findAllAuditType(){
		return auditTypeDao.findAllAuditType();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<AuditType> findAuditTypeBySome(AuditType auditType){
		return auditTypeDao.findAuditTypeBySome(auditType);
	}

	// 根据id查找
	@Override
	public AuditType findById(Integer id){
		return auditTypeDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		auditTypeDao.deleteById(id);
	}

	// 根据auditName查找
	@Override
	public AuditType findByAuditName(String auditName){
		return auditTypeDao.findByAuditName(auditName);
	}

	// 根据auditName删除
	@Override
	public void deleteByAuditName(String auditName){
		auditTypeDao.findByAuditName(auditName);
	}


}