package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.ActinfoDynaSqlProvider;

import com.ctgu.ssm.entity.Actinfo;

public interface ActinfoDao {
    
    // 动态插入
    @SelectProvider(type=ActinfoDynaSqlProvider.class,method="insertActinfo")
    void insertActinfo(Actinfo actinfo);
    
    // 动态修改
    @SelectProvider(type=ActinfoDynaSqlProvider.class,method="updateActinfo")
    void updateActinfo(Actinfo actinfo);
    
    // 查找所有
    @Select("select * from " +  "actinfo" )
    List<Actinfo> findAllActinfo();
    
    // 动态查询
    @SelectProvider(type=ActinfoDynaSqlProvider.class,method="selectActinfo")
    List<Actinfo> findActinfoBySome(Actinfo actinfo);
    
    // 根据id查询和删除
    @Select("select * from "+ "actinfo" +" where id = #{id}")
    Actinfo findById(Integer id);
    
    @Select("delete from "+ "actinfo" +" where id = #{id}")
    void deleteById(Integer id);
    
    
    // 根据actid查询和删除
    @Select("select * from "+ "actinfo" +" where actid = #{actid}")
    Actinfo findByActid(Integer actid);
    
    @Select("delete from "+ "actinfo" +" where actid = #{actid}")
    void deleteByActid(Integer actid);
    
    
    // 根据userid查询和删除
    @Select("select * from "+ "actinfo" +" where userid = #{userid}")
    Actinfo findByUserid(Integer userid);
    
    @Select("delete from "+ "actinfo" +" where userid = #{userid}")
    void deleteByUserid(Integer userid);
    
    
    // 根据auditid查询和删除
    @Select("select * from "+ "actinfo" +" where auditid = #{auditid}")
    Actinfo findByAuditid(Integer auditid);
    
    @Select("delete from "+ "actinfo" +" where auditid = #{auditid}")
    void deleteByAuditid(Integer auditid);
    
    
    // 根据actimg查询和删除
    @Select("select * from "+ "actinfo" +" where actimg = #{actimg}")
    Actinfo findByActimg(String actimg);
    
    @Select("delete from "+ "actinfo" +" where actimg = #{actimg}")
    void deleteByActimg(String actimg);
    
    
    // 根据name查询和删除
    @Select("select * from "+ "actinfo" +" where name = #{name}")
    Actinfo findByName(String name);
    
    @Select("delete from "+ "actinfo" +" where name = #{name}")
    void deleteByName(String name);
    
    
    // 根据introduce查询和删除
    @Select("select * from "+ "actinfo" +" where introduce = #{introduce}")
    Actinfo findByIntroduce(String introduce);
    
    @Select("delete from "+ "actinfo" +" where introduce = #{introduce}")
    void deleteByIntroduce(String introduce);
    
    
    // 根据acttypeid查询和删除
    @Select("select * from "+ "actinfo" +" where acttypeid = #{acttypeid}")
    Actinfo findByActtypeid(String acttypeid);
    
    @Select("delete from "+ "actinfo" +" where acttypeid = #{acttypeid}")
    void deleteByActtypeid(String acttypeid);
    
    
    // 根据starttime查询和删除
    @Select("select * from "+ "actinfo" +" where starttime = #{starttime}")
    Actinfo findByStarttime(String starttime);
    
    @Select("delete from "+ "actinfo" +" where starttime = #{starttime}")
    void deleteByStarttime(String starttime);
    
    
    // 根据endtime查询和删除
    @Select("select * from "+ "actinfo" +" where endtime = #{endtime}")
    Actinfo findByEndtime(String endtime);
    
    @Select("delete from "+ "actinfo" +" where endtime = #{endtime}")
    void deleteByEndtime(String endtime);
    
    
}
