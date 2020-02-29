package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.ActTypeDao;
import com.ctgu.ssm.entity.ActType;
import com.ctgu.ssm.service.ActTypeService;

@Service("actTypeService")
public class ActTypeServiceImpl implements ActTypeService{

	@Autowired
	private ActTypeDao actTypeDao;

	// 添加
	@Override
	public void addActType(ActType actType){
		actTypeDao.insertActType(actType);
	}

	// 更新
	@Override
	public void updateActType(ActType actType){
		actTypeDao.updateActType(actType);
	}

	// 找到所有对象
	@Override
	public List<ActType> findAllActType(){
		return actTypeDao.findAllActType();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<ActType> findActTypeBySome(ActType actType){
		return actTypeDao.findActTypeBySome(actType);
	}

	// 根据id查找
	@Override
	public ActType findById(Integer id){
		return actTypeDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		actTypeDao.deleteById(id);
	}

	// 根据actname查找
	@Override
	public ActType findByActname(String actname){
		return actTypeDao.findByActname(actname);
	}

	// 根据actname删除
	@Override
	public void deleteByActname(String actname){
		actTypeDao.findByActname(actname);
	}


}