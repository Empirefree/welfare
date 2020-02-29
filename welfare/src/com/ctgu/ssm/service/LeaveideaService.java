package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Leaveidea;

public interface LeaveideaService {

	// 添加
	void addLeaveidea(Leaveidea leaveidea);

	// 更新
	void updateLeaveidea(Leaveidea leaveidea);

	// 找到所有对象
	List<Leaveidea> findAllLeaveidea();

	// 根据一个抽象对象找到所有符合要求的对象
	List<Leaveidea> findLeaveideaBySome(Leaveidea leaveidea);


	// 根据id查找
	Leaveidea findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据ideaid查找
	Leaveidea findByIdeaid(Integer ideaid);

	// 根据ideaid删除
	void deleteByIdeaid(Integer ideaid);

	// 根据user1id查找
	Leaveidea findByUser1id(Integer user1id);

	// 根据user1id删除
	void deleteByUser1id(Integer user1id);

	// 根据comment查找
	Leaveidea findByComment(String comment);

	// 根据comment删除
	void deleteByComment(String comment);

	// 根据isSolve查找
	Leaveidea findByIsSolve(Integer isSolve);

	// 根据isSolve删除
	void deleteByIsSolve(Integer isSolve);

	// 根据createtime查找
	Leaveidea findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}