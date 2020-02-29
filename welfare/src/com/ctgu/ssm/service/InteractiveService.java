package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Interactive;

public interface InteractiveService {

	// 添加
	void addInteractive(Interactive interactive);

	// 更新
	void updateInteractive(Interactive interactive);

	// 找到所有对象
	List<Interactive> findAllInteractive();

	// 根据一个抽象对象找到所有符合要求的对象
	List<Interactive> findInteractiveBySome(Interactive interactive);


	// 根据id查找
	Interactive findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据itemid查找
	Interactive findByItemid(Integer itemid);

	// 根据itemid删除
	void deleteByItemid(Integer itemid);

	// 根据donorid查找
	Interactive findByDonorid(Integer donorid);

	// 根据donorid删除
	void deleteByDonorid(Integer donorid);

	// 根据receiveid查找
	Interactive findByReceiveid(Integer receiveid);

	// 根据receiveid删除
	void deleteByReceiveid(Integer receiveid);

	// 根据content查找
	Interactive findByContent(String content);

	// 根据content删除
	void deleteByContent(String content);

	// 根据distin查找
	Interactive findByDistin(Integer distin);

	// 根据distin删除
	void deleteByDistin(Integer distin);

	// 根据createtime查找
	Interactive findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}