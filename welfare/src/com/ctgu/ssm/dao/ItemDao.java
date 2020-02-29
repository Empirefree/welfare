package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.ItemDynaSqlProvider;
import com.ctgu.ssm.entity.Item;

public interface ItemDao {

	// 动态插入
	@InsertProvider(type=ItemDynaSqlProvider.class,method="insertItem")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insertItem(Item item);

	// 动态修改
	@SelectProvider(type=ItemDynaSqlProvider.class,method="updateItem")
	void updateItem(Item item);

	// 查找所有
	@Select("select * from " +  "item" )
	List<Item> findAllItem();

	// 动态查询
	@SelectProvider(type=ItemDynaSqlProvider.class,method="selectItem")
	List<Item> findItemBySome(Item item);

	// 根据id查询和删除
	@Select("select * from "+ "item" +" where id = #{id}")
	Item findById(Integer id);

	@Select("delete from "+ "item" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据itemname查询和删除
	@Select("select * from "+ "item" +" where itemname = #{itemname}")
	Item findByItemname(String itemname);

	@Select("delete from "+ "item" +" where itemname = #{itemname}")
	void deleteByItemname(String itemname);


	// 根据itemimg查询和删除
	@Select("select * from "+ "item" +" where itemimg = #{itemimg}")
	Item findByItemimg(String itemimg);

	@Select("delete from "+ "item" +" where itemimg = #{itemimg}")
	void deleteByItemimg(String itemimg);


	// 根据itemcount查询和删除
	@Select("select * from "+ "item" +" where itemcount = #{itemcount}")
	Item findByItemcount(Integer itemcount);

	@Select("delete from "+ "item" +" where itemcount = #{itemcount}")
	void deleteByItemcount(Integer itemcount);


	// 根据introduce查询和删除
	@Select("select * from "+ "item" +" where introduce = #{introduce}")
	Item findByIntroduce(String introduce);

	@Select("delete from "+ "item" +" where introduce = #{introduce}")
	void deleteByIntroduce(String introduce);


	// 根据userid查询和删除
	@Select("select * from "+ "item" +" where userid = #{userid}")
	Item findByUserid(Integer userid);

	@Select("delete from "+ "item" +" where userid = #{userid}")
	void deleteByUserid(Integer userid);


	// 根据typeid查询和删除
	@Select("select * from "+ "item" +" where typeid = #{typeid}")
	Item findByTypeid(Integer typeid);

	@Select("delete from "+ "item" +" where typeid = #{typeid}")
	void deleteByTypeid(Integer typeid);


	// 根据auditid查询和删除
	@Select("select * from "+ "item" +" where auditid = #{auditid}")
	Item findByAuditid(Integer auditid);

	@Select("delete from "+ "item" +" where auditid = #{auditid}")
	void deleteByAuditid(Integer auditid);


	// 根据createtime查询和删除
	@Select("select * from "+ "item" +" where createtime = #{createtime}")
	Item findByCreatetime(String createtime);

	@Select("delete from "+ "item" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}