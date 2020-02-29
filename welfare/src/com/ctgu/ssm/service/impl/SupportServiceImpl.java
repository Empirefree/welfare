package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.SupportDao;
import com.ctgu.ssm.entity.Support;
import com.ctgu.ssm.service.SupportService;

@Service("supportService")
public class SupportServiceImpl implements SupportService{

	@Autowired
	private SupportDao supportDao;

	// 添加
	@Override
	public void addSupport(Support support){
		supportDao.insertSupport(support);
	}

	// 更新
	@Override
	public void updateSupport(Support support){
		supportDao.updateSupport(support);
	}

	// 找到所有对象
	@Override
	public List<Support> findAllSupport(){
		return supportDao.findAllSupport();
	}

	// 找到所有对象
	@Override
	public List<Support> findAllByDonorid(int donorid){
		return supportDao.findAllByDonorid(donorid);
	}
	
	
	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Support> findSupportBySome(Support support){
		return supportDao.findSupportBySome(support);
	}

	// 根据id查找
	@Override
	public Support findById(Integer id){
		return supportDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		supportDao.deleteById(id);
	}

	// 根据donorid查找
	@Override
	public Support findByDonorid(Integer donorid){
		return supportDao.findByDonorid(donorid);
	}

	// 根据donorid删除
	@Override
	public void deleteByDonorid(Integer donorid){
		supportDao.findByDonorid(donorid);
	}

	// 根据itemid查找
	@Override
	public Support findByItemid(Integer itemid){
		return supportDao.findByItemid(itemid);
	}

	// 根据itemid删除
	@Override
	public void deleteByItemid(Integer itemid){
		supportDao.findByItemid(itemid);
	}

	// 根据itemnum查找
	@Override
	public Support findByItemnum(Integer itemnum){
		return supportDao.findByItemnum(itemnum);
	}

	// 根据itemnum删除
	@Override
	public void deleteByItemnum(Integer itemnum){
		supportDao.findByItemnum(itemnum);
	}

	// 根据receiveid查找
	@Override
	public Support findByReceiveid(Integer receiveid){
		return supportDao.findByReceiveid(receiveid);
	}

	// 根据receiveid查找
	@Override
	public List<Support> findAllByReceiveid(Integer receiveid){
		return supportDao.findAllByReceiveid(receiveid);
	}

	// 根据receiveid删除
	@Override
	public void deleteByReceiveid(Integer receiveid){
		supportDao.findByReceiveid(receiveid);
	}

	// 根据remarks查找
	@Override
	public Support findByRemarks(String remarks){
		return supportDao.findByRemarks(remarks);
	}

	// 根据remarks删除
	@Override
	public void deleteByRemarks(String remarks){
		supportDao.findByRemarks(remarks);
	}

	// 根据distin查找
	@Override
	public Support findByDistin(Integer distin){
		return supportDao.findByDistin(distin);
	}

	// 根据distin删除
	@Override
	public void deleteByDistin(Integer distin){
		supportDao.findByDistin(distin);
	}

	// 根据createtime查找
	@Override
	public Support findByCreatetime(String createtime){
		return supportDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		supportDao.findByCreatetime(createtime);
	}


}