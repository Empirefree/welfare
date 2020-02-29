package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.ItemType;

public interface ItemTypeService {

	// 添加
	void addItemType(ItemType itemType);

	// 更新
	void updateItemType(ItemType itemType);

	// 找到所有对象
	List<ItemType> findAllItemType();

	// 根据一个抽象对象找到所有符合要求的对象
	List<ItemType> findItemTypeBySome(ItemType itemType);


	// 根据id查找
	ItemType findById(Integer id);

	// 根据id删除
	void deleteById(Integer id);

	// 根据itemname查找
	ItemType findByItemname(String itemname);

	// 根据itemname删除
	void deleteByItemname(String itemname);


}