package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.ActType;

public interface ActTypeService {

	// 添加
	void addActType(ActType actType);

	// 更新
	void updateActType(ActType actType);

	// 找到所有对象
	List<ActType> findAllActType();

	// 根据一个抽象对象找到所有符合要求的对象
	List<ActType> findActTypeBySome(ActType actType);


	// 根据id查找
	ActType findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据actname查找
	ActType findByActname(String actname);

	// 根据actname删除
	void deleteByActname(String actname);


}