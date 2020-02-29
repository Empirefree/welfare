package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Item;

public interface ItemService {

	// 添加
	void addItem(Item item);

	// 更新
	void updateItem(Item item);

	// 找到所有对象
	List<Item> findAllItem();

	// 根据一个抽象对象找到所有符合要求的对象
	List<Item> findItemBySome(Item item);


	// 根据id查找
	Item findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据itemname查找
	Item findByItemname(String itemname);

	// 根据itemname删除
	void deleteByItemname(String itemname);

	// 根据itemimg查找
	Item findByItemimg(String itemimg);

	// 根据itemimg删除
	void deleteByItemimg(String itemimg);

	// 根据itemcount查找
	Item findByItemcount(Integer itemcount);

	// 根据itemcount删除
	void deleteByItemcount(Integer itemcount);

	// 根据introduce查找
	Item findByIntroduce(String introduce);

	// 根据introduce删除
	void deleteByIntroduce(String introduce);

	// 根据userid查找
	Item findByUserid(Integer userid);

	// 根据userid删除
	void deleteByUserid(Integer userid);

	// 根据typeid查找
	Item findByTypeid(Integer typeid);

	// 根据typeid删除
	void deleteByTypeid(Integer typeid);

	// 根据auditid查找
	Item findByAuditid(Integer auditid);

	// 根据auditid删除
	void deleteByAuditid(Integer auditid);

	// 根据createtime查找
	Item findByCreatetime(String createtime);

	// 根据createtime删除
	void deleteByCreatetime(String createtime);


}