package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.ItemTypeDao;
import com.ctgu.ssm.entity.ItemType;
import com.ctgu.ssm.service.ItemTypeService;

@Service("itemTypeService")
public class ItemTypeServiceImpl implements ItemTypeService{

	@Autowired
	private ItemTypeDao itemTypeDao;

	// 添加
	@Override
	public void addItemType(ItemType itemType){
		itemTypeDao.insertItemType(itemType);
	}

	// 更新
	@Override
	public void updateItemType(ItemType itemType){
		itemTypeDao.updateItemType(itemType);
	}

	// 找到所有对象
	@Override
	public List<ItemType> findAllItemType(){
		return itemTypeDao.findAllItemType();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<ItemType> findItemTypeBySome(ItemType itemType){
		return itemTypeDao.findItemTypeBySome(itemType);
	}

	// 根据id查找
	@Override
	public ItemType findById(Integer id){
		return itemTypeDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		itemTypeDao.deleteById(id);
	}

	// 根据itemname查找
	@Override
	public ItemType findByItemname(String itemname){
		return itemTypeDao.findByItemname(itemname);
	}

	// 根据itemname删除
	@Override
	public void deleteByItemname(String itemname){
		itemTypeDao.findByItemname(itemname);
	}


}