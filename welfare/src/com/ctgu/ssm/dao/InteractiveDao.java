package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.InteractiveDynaSqlProvider;
import com.ctgu.ssm.entity.Interactive;

public interface InteractiveDao {

	// 动态插入
	@SelectProvider(type=InteractiveDynaSqlProvider.class,method="insertInteractive")
	void insertInteractive(Interactive interactive);

	// 动态修改
	@SelectProvider(type=InteractiveDynaSqlProvider.class,method="updateInteractive")
	void updateInteractive(Interactive interactive);

	// 查找所有
	@Select("select * from " +  "interactive" )
	List<Interactive> findAllInteractive();

	// 动态查询
	@SelectProvider(type=InteractiveDynaSqlProvider.class,method="selectInteractive")
	List<Interactive> findInteractiveBySome(Interactive interactive);

	// 根据id查询和删除
	@Select("select * from "+ "interactive" +" where id = #{id}")
	Interactive findById(Integer id);

	@Select("delete from "+ "interactive" +" where id = #{id}")
	void deleteById(Integer id);


	// 根据itemid查询和删除
	@Select("select * from "+ "interactive" +" where itemid = #{itemid}")
	Interactive findByItemid(Integer itemid);

	@Select("delete from "+ "interactive" +" where itemid = #{itemid}")
	void deleteByItemid(Integer itemid);


	// 根据donorid查询和删除
	@Select("select * from "+ "interactive" +" where donorid = #{donorid}")
	Interactive findByDonorid(Integer donorid);

	@Select("delete from "+ "interactive" +" where donorid = #{donorid}")
	void deleteByDonorid(Integer donorid);


	// 根据receiveid查询和删除
	@Select("select * from "+ "interactive" +" where receiveid = #{receiveid}")
	Interactive findByReceiveid(Integer receiveid);

	@Select("delete from "+ "interactive" +" where receiveid = #{receiveid}")
	void deleteByReceiveid(Integer receiveid);


	// 根据content查询和删除
	@Select("select * from "+ "interactive" +" where content = #{content}")
	Interactive findByContent(String content);

	@Select("delete from "+ "interactive" +" where content = #{content}")
	void deleteByContent(String content);


	// 根据distin查询和删除
	@Select("select * from "+ "interactive" +" where distin = #{distin}")
	Interactive findByDistin(Integer distin);

	@Select("delete from "+ "interactive" +" where distin = #{distin}")
	void deleteByDistin(Integer distin);


	// 根据createtime查询和删除
	@Select("select * from "+ "interactive" +" where createtime = #{createtime}")
	Interactive findByCreatetime(String createtime);

	@Select("delete from "+ "interactive" +" where createtime = #{createtime}")
	void deleteByCreatetime(String createtime);


}