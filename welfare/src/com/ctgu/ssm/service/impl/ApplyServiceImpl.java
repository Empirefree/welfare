package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.ApplyDao;
import com.ctgu.ssm.entity.Apply;
import com.ctgu.ssm.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	private ApplyDao applyDao;

	// 添加
	@Override
	public void addApply(Apply apply){
		applyDao.insertApply(apply);
	}

	// 更新
	@Override
	public void updateApply(Apply apply){
		applyDao.updateApply(apply);
	}

	// 找到所有对象
	@Override
	public List<Apply> findAllApply(){
		return applyDao.findAllApply();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Apply> findApplyBySome(Apply apply){
		return applyDao.findApplyBySome(apply);
	}

	// 根据id查找
	@Override
	public Apply findById(Integer id){
		return applyDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		applyDao.deleteById(id);
	}

	// 根据itemid查找
	@Override
	public Apply findByItemid(Integer itemid){
		return applyDao.findByItemid(itemid);
	}

	// 根据itemid删除
	@Override
	public void deleteByItemid(Integer itemid){
		applyDao.findByItemid(itemid);
	}

	// 根据userid查找
	@Override
	public Apply findByUserid(Integer userid){
		return applyDao.findByUserid(userid);
	}

	// 根据userid删除
	@Override
	public void deleteByUserid(Integer userid){
		applyDao.findByUserid(userid);
	}

	// 根据auditid查找
	@Override
	public Apply findByAuditid(Integer auditid){
		return applyDao.findByAuditid(auditid);
	}

	// 根据auditid删除
	@Override
	public void deleteByAuditid(Integer auditid){
		applyDao.findByAuditid(auditid);
	}

	// 根据createtime查找
	@Override
	public Apply findByCreatetime(String createtime){
		return applyDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		applyDao.findByCreatetime(createtime);
	}


}