package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.ItemTypeDynaSqlProvider;
import com.ctgu.ssm.entity.ItemType;

public interface ItemTypeDao {

	// 动态插入
	@SelectProvider(type=ItemTypeDynaSqlProvider.class,method="insertItemType")
	void insertItemType(ItemType itemType);

	// 动态修改
	@SelectProvider(type=ItemTypeDynaSqlProvider.class,method="updateItemType")
	void updateItemType(ItemType itemType);

	// 查找所有
	@Select("select * from " +  "item_type" )
	List<ItemType> findAllItemType();

	// 动态查询
	@SelectProvider(type=ItemTypeDynaSqlProvider.class,method="selectItemType")
	List<ItemType> findItemTypeBySome(ItemType itemType);

	// 根据id查询和删除
	@Select("select * from "+ "item_type" +" where id = #{id}")
	ItemType findById(Integer id);

	@Select("delete from "+ "item_type" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据itemname查询和删除
	@Select("select * from "+ "item_type" +" where itemname = #{itemname}")
	ItemType findByItemname(String itemname);

	@Select("delete from "+ "item_type" +" where itemname = #{itemname}")
	void deleteByItemname(String itemname);


}