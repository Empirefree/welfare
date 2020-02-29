package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.OffinfoDynaSqlProvider;

import com.ctgu.ssm.entity.Offinfo;

public interface OffinfoDao {
    
    // 动态插入
    @SelectProvider(type=OffinfoDynaSqlProvider.class,method="insertOffinfo")
    void insertOffinfo(Offinfo offinfo);
    
    // 动态修改
    @SelectProvider(type=OffinfoDynaSqlProvider.class,method="updateOffinfo")
    void updateOffinfo(Offinfo offinfo);
    
    // 查找所有
    @Select("select * from " +  "offinfo" )
    List<Offinfo> findAllOffinfo();
    
    // 动态查询
    @SelectProvider(type=OffinfoDynaSqlProvider.class,method="selectOffinfo")
    List<Offinfo> findOffinfoBySome(Offinfo offinfo);
    
    // 根据id查询和删除
    @Select("select * from "+ "offinfo" +" where id = #{id}")
    Offinfo findById(Integer id);
    
    @Select("delete from "+ "offinfo" +" where id = #{id}")
    void deleteById(Integer id);
    
    
    // 根据actid查询和删除
    @Select("select * from "+ "offinfo" +" where actid = #{actid}")
    Offinfo findByActid(Integer actid);
    
    @Select("delete from "+ "offinfo" +" where actid = #{actid}")
    void deleteByActid(Integer actid);
    
    
    // 根据userid查询和删除
    @Select("select * from "+ "offinfo" +" where userid = #{userid}")
    Offinfo findByUserid(Integer userid);
    
    @Select("delete from "+ "offinfo" +" where userid = #{userid}")
    void deleteByUserid(Integer userid);
    
    
    // 根据actimg查询和删除
    @Select("select * from "+ "offinfo" +" where actimg = #{actimg}")
    Offinfo findByActimg(String actimg);
    
    @Select("delete from "+ "offinfo" +" where actimg = #{actimg}")
    void deleteByActimg(String actimg);
    
    
    // 根据name查询和删除
    @Select("select * from "+ "offinfo" +" where name = #{name}")
    Offinfo findByName(String name);
    
    @Select("delete from "+ "offinfo" +" where name = #{name}")
    void deleteByName(String name);
    
    
    // 根据introduce查询和删除
    @Select("select * from "+ "offinfo" +" where introduce = #{introduce}")
    Offinfo findByIntroduce(String introduce);
    
    @Select("delete from "+ "offinfo" +" where introduce = #{introduce}")
    void deleteByIntroduce(String introduce);
    
    
    // 根据acttypeid查询和删除
    @Select("select * from "+ "offinfo" +" where acttypeid = #{acttypeid}")
    Offinfo findByActtypeid(String acttypeid);
    
    @Select("delete from "+ "offinfo" +" where acttypeid = #{acttypeid}")
    void deleteByActtypeid(String acttypeid);
    
    
    // 根据starttime查询和删除
    @Select("select * from "+ "offinfo" +" where starttime = #{starttime}")
    Offinfo findByStarttime(String starttime);
    
    @Select("delete from "+ "offinfo" +" where starttime = #{starttime}")
    void deleteByStarttime(String starttime);
    
    
    // 根据endtime查询和删除
    @Select("select * from "+ "offinfo" +" where endtime = #{endtime}")
    Offinfo findByEndtime(String endtime);
    
    @Select("delete from "+ "offinfo" +" where endtime = #{endtime}")
    void deleteByEndtime(String endtime);
    
    
}
