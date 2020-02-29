package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.LeaveideaDao;
import com.ctgu.ssm.entity.Leaveidea;
import com.ctgu.ssm.service.LeaveideaService;

@Service("leaveideaService")
public class LeaveideaServiceImpl implements LeaveideaService{

	@Autowired
	private LeaveideaDao leaveideaDao;

	// 添加
	@Override
	public void addLeaveidea(Leaveidea leaveidea){
		leaveideaDao.insertLeaveidea(leaveidea);
	}

	// 更新
	@Override
	public void updateLeaveidea(Leaveidea leaveidea){
		leaveideaDao.updateLeaveidea(leaveidea);
	}

	// 找到所有对象
	@Override
	public List<Leaveidea> findAllLeaveidea(){
		return leaveideaDao.findAllLeaveidea();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Leaveidea> findLeaveideaBySome(Leaveidea leaveidea){
		return leaveideaDao.findLeaveideaBySome(leaveidea);
	}

	// 根据id查找
	@Override
	public Leaveidea findById(Integer id){
		return leaveideaDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		leaveideaDao.deleteById(id);
	}

	// 根据ideaid查找
	@Override
	public Leaveidea findByIdeaid(Integer ideaid){
		return leaveideaDao.findByIdeaid(ideaid);
	}

	// 根据ideaid删除
	@Override
	public void deleteByIdeaid(Integer ideaid){
		leaveideaDao.findByIdeaid(ideaid);
	}

	// 根据user1id查找
	@Override
	public Leaveidea findByUser1id(Integer user1id){
		return leaveideaDao.findByUser1id(user1id);
	}

	// 根据user1id删除
	@Override
	public void deleteByUser1id(Integer user1id){
		leaveideaDao.findByUser1id(user1id);
	}

	// 根据comment查找
	@Override
	public Leaveidea findByComment(String comment){
		return leaveideaDao.findByComment(comment);
	}

	// 根据comment删除
	@Override
	public void deleteByComment(String comment){
		leaveideaDao.findByComment(comment);
	}

	// 根据isSolve查找
	@Override
	public Leaveidea findByIsSolve(Integer isSolve){
		return leaveideaDao.findByIsSolve(isSolve);
	}

	// 根据isSolve删除
	@Override
	public void deleteByIsSolve(Integer isSolve){
		leaveideaDao.findByIsSolve(isSolve);
	}

	// 根据createtime查找
	@Override
	public Leaveidea findByCreatetime(String createtime){
		return leaveideaDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		leaveideaDao.findByCreatetime(createtime);
	}


}