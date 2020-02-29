package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.SupportDynaSqlProvider;
import com.ctgu.ssm.entity.Support;

public interface SupportDao {

	// 动态插入
	@SelectProvider(type=SupportDynaSqlProvider.class,method="insertSupport")
	void insertSupport(Support support);

	// 动态修改
	@SelectProvider(type=SupportDynaSqlProvider.class,method="updateSupport")
	void updateSupport(Support support);

	// 查找所有
	@Select("select * from " +  "support" )
	List<Support> findAllSupport();
	
	// 查找所有
	@Select("select * from " +  "support"  + " where donorid = #{id}" )
	List<Support> findAllByDonorid(int id);

	// 动态查询
	@SelectProvider(type=SupportDynaSqlProvider.class,method="selectSupport")
	List<Support> findSupportBySome(Support support);

	// 根据id查询和删除
	@Select("select * from "+ "support" +" where id = #{id}")
	Support findById(Integer id);

	@Select("delete from "+ "support" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据donorid查询和删除
	@Select("select * from "+ "support" +" where donorid = #{donorid}")
	Support findByDonorid(Integer donorid);

	@Select("delete from "+ "support" +" where donorid = #{donorid}")
	void deleteByDonorid(Integer donorid);


	// 根据itemid查询和删除
	@Select("select * from "+ "support" +" where itemid = #{itemid}")
	Support findByItemid(Integer itemid);

	@Select("delete from "+ "support" +" where itemid = #{itemid}")
	void deleteByItemid(Integer itemid);


	// 根据itemnum查询和删除
	@Select("select * from "+ "support" +" where itemnum = #{itemnum}")
	Support findByItemnum(Integer itemnum);

	@Select("delete from "+ "support" +" where itemnum = #{itemnum}")
	void deleteByItemnum(Integer itemnum);


	// 根据receiveid查询和删除
	@Select("select * from "+ "support" +" where receiveid = #{receiveid}")
	Support findByReceiveid(Integer receiveid);
	
	@Select("select * from "+ "support" +" where receiveid = #{receiveid}")
	List<Support> findAllByReceiveid(Integer receiveid);


	@Select("delete from "+ "support" +" where receiveid = #{receiveid}")
	void deleteByReceiveid(Integer receiveid);


	// 根据remarks查询和删除
	@Select("select * from "+ "support" +" where remarks = #{remarks}")
	Support findByRemarks(String remarks);

	@Select("delete from "+ "support" +" where remarks = #{remarks}")
	void deleteByRemarks(String remarks);


	// 根据distin查询和删除
	@Select("select * from "+ "support" +" where distin = #{distin}")
	Support findByDistin(Integer distin);

	@Select("delete from "+ "support" +" where distin = #{distin}")
	void deleteByDistin(Integer distin);


	// 根据createtime查询和删除
	@Select("select * from "+ "support" +" where createtime = #{createtime}")
	Support findByCreatetime(String createtime);

	@Select("delete from "+ "support" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}