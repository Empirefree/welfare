package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Support;

public interface SupportService {

	// 添加
	void addSupport(Support support);

	// 更新
	void updateSupport(Support support);

	// 找到所有对象
	List<Support> findAllSupport();
	
	// 通过donorid找到所有对象
	List<Support> findAllByDonorid(int donorid);

	// 根据一个抽象对象找到所有符合要求的对象
	List<Support> findSupportBySome(Support support);


	// 根据id查找
	Support findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据donorid查找
	Support findByDonorid(Integer donorid);

	// 根据donorid删除
	void deleteByDonorid(Integer donorid);

	// 根据itemid查找
	Support findByItemid(Integer itemid);

	// 根据itemid删除
	void deleteByItemid(Integer itemid);

	// 根据itemnum查找
	Support findByItemnum(Integer itemnum);

	// 根据itemnum删除
	void deleteByItemnum(Integer itemnum);

	// 根据receiveid查找
	Support findByReceiveid(Integer receiveid);
	
	// 根据receiveid查找
	List<Support> findAllByReceiveid(Integer receiveid);

	// 根据receiveid删除
	void deleteByReceiveid(Integer receiveid);

	// 根据remarks查找
	Support findByRemarks(String remarks);

	// 根据remarks删除
	void deleteByRemarks(String remarks);

	// 根据distin查找
	Support findByDistin(Integer distin);

	// 根据distin删除
	void deleteByDistin(Integer distin);

	// 根据createtime查找
	Support findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}