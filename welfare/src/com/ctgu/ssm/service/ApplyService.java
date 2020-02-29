package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Apply;

public interface ApplyService {

	// 添加
	void addApply(Apply apply);

	// 更新
	void updateApply(Apply apply);

	// 找到所有对象
	List<Apply> findAllApply();

	// 根据一个抽象对象找到所有符合要求的对象
	List<Apply> findApplyBySome(Apply apply);


	// 根据id查找
	Apply findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据itemid查找
	Apply findByItemid(Integer itemid);

	// 根据itemid删除
	void deleteByItemid(Integer itemid);

	// 根据userid查找
	Apply findByUserid(Integer userid);

	// 根据userid删除
	void deleteByUserid(Integer userid);

	// 根据auditid查找
	Apply findByAuditid(Integer auditid);

	// 根据auditid删除
	void deleteByAuditid(Integer auditid);

	// 根据createtime查找
	Apply findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}