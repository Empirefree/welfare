package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.ItemDao;
import com.ctgu.ssm.entity.Item;
import com.ctgu.ssm.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;

	// 添加
	@Override
	public void addItem(Item item){
		itemDao.insertItem(item);
	}

	// 更新
	@Override
	public void updateItem(Item item){
		itemDao.updateItem(item);
	}

	// 找到所有对象
	@Override
	public List<Item> findAllItem(){
		return itemDao.findAllItem();
	}

	// 根据一个抽象对象找到所有符合要求的对象
	@Override
	public List<Item> findItemBySome(Item item){
		return itemDao.findItemBySome(item);
	}

	// 根据id查找
	@Override
	public Item findById(Integer id){
		return itemDao.findById(id);
	}

	// 根据id删除
	@Override
	public void deleteById(Integer id){
		itemDao.deleteById(id);
	}

	// 根据itemname查找
	@Override
	public Item findByItemname(String itemname){
		return itemDao.findByItemname(itemname);
	}

	// 根据itemname删除
	@Override
	public void deleteByItemname(String itemname){
		itemDao.findByItemname(itemname);
	}

	// 根据itemimg查找
	@Override
	public Item findByItemimg(String itemimg){
		return itemDao.findByItemimg(itemimg);
	}

	// 根据itemimg删除
	@Override
	public void deleteByItemimg(String itemimg){
		itemDao.findByItemimg(itemimg);
	}

	// 根据itemcount查找
	@Override
	public Item findByItemcount(Integer itemcount){
		return itemDao.findByItemcount(itemcount);
	}

	// 根据itemcount删除
	@Override
	public void deleteByItemcount(Integer itemcount){
		itemDao.findByItemcount(itemcount);
	}

	// 根据introduce查找
	@Override
	public Item findByIntroduce(String introduce){
		return itemDao.findByIntroduce(introduce);
	}

	// 根据introduce删除
	@Override
	public void deleteByIntroduce(String introduce){
		itemDao.findByIntroduce(introduce);
	}

	// 根据userid查找
	@Override
	public Item findByUserid(Integer userid){
		return itemDao.findByUserid(userid);
	}

	// 根据userid删除
	@Override
	public void deleteByUserid(Integer userid){
		itemDao.findByUserid(userid);
	}

	// 根据typeid查找
	@Override
	public Item findByTypeid(Integer typeid){
		return itemDao.findByTypeid(typeid);
	}

	// 根据typeid删除
	@Override
	public void deleteByTypeid(Integer typeid){
		itemDao.findByTypeid(typeid);
	}

	// 根据auditid查找
	@Override
	public Item findByAuditid(Integer auditid){
		return itemDao.findByAuditid(auditid);
	}

	// 根据auditid删除
	@Override
	public void deleteByAuditid(Integer auditid){
		itemDao.findByAuditid(auditid);
	}

	// 根据createtime查找
	@Override
	public Item findByCreatetime(String createtime){
		return itemDao.findByCreatetime(createtime);
	}

	// 根据createtime删除
	@Override
	public void deleteByCreatetime(String createtime){
		itemDao.findByCreatetime(createtime);
	}


}