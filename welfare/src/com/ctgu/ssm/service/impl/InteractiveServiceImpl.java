package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.InteractiveDao;
import com.ctgu.ssm.entity.Interactive;
import com.ctgu.ssm.service.InteractiveService;

@Service("interactiveService")
public class InteractiveServiceImpl implements InteractiveService{

	@Autowired
	private InteractiveDao interactiveDao;

	// 添加
	@Override
	public void addInteractive(Interactive interactive){
		interactiveDao.insertInteractive(interactive);
	}

	// 更新
	@Override
	public void updateInteractive(Interactive interactive){
		interactiveDao.updateInteractive(interactive);
	}

	// 找到所有对象
	@Override
	public List<Interactive> findAllInteractive(){
		return interactiveDao.findAllInteractive();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Interactive> findInteractiveBySome(Interactive interactive){
		return interactiveDao.findInteractiveBySome(interactive);
	}

	// 根据id查找
	@Override
	public Interactive findById(Integer id){
		return interactiveDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		interactiveDao.deleteById(id);
	}

	// 根据itemid查找
	@Override
	public Interactive findByItemid(Integer itemid){
		return interactiveDao.findByItemid(itemid);
	}

	// 根据itemid删除
	@Override
	public void deleteByItemid(Integer itemid){
		interactiveDao.findByItemid(itemid);
	}

	// 根据donorid查找
	@Override
	public Interactive findByDonorid(Integer donorid){
		return interactiveDao.findByDonorid(donorid);
	}

	// 根据donorid删除
	@Override
	public void deleteByDonorid(Integer donorid){
		interactiveDao.findByDonorid(donorid);
	}

	// 根据receiveid查找
	@Override
	public Interactive findByReceiveid(Integer receiveid){
		return interactiveDao.findByReceiveid(receiveid);
	}

	// 根据receiveid删除
	@Override
	public void deleteByReceiveid(Integer receiveid){
		interactiveDao.findByReceiveid(receiveid);
	}

	// 根据content查找
	@Override
	public Interactive findByContent(String content){
		return interactiveDao.findByContent(content);
	}

	// 根据content删除
	@Override
	public void deleteByContent(String content){
		interactiveDao.findByContent(content);
	}

	// 根据distin查找
	@Override
	public Interactive findByDistin(Integer distin){
		return interactiveDao.findByDistin(distin);
	}

	// 根据distin删除
	@Override
	public void deleteByDistin(Integer distin){
		interactiveDao.findByDistin(distin);
	}

	// 根据createtime查找
	@Override
	public Interactive findByCreatetime(String createtime){
		return interactiveDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		interactiveDao.findByCreatetime(createtime);
	}


}