package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.Audit_typeDynaSqlProvider;

import com.ctgu.ssm.entity.Audit_type;

public interface Audit_typeDao {
    
    // 动态插入
    @SelectProvider(type=Audit_typeDynaSqlProvider.class,method="insertAudit_type")
    void insertAudit_type(Audit_type audit_type);
    
    // 动态修改
    @SelectProvider(type=Audit_typeDynaSqlProvider.class,method="updateAudit_type")
    void updateAudit_type(Audit_type audit_type);
    
    // 查找所有
    @Select("select * from " +  "audit_type" )
    List<Audit_type> findAllAudit_type();
    
    // 动态查询
    @SelectProvider(type=Audit_typeDynaSqlProvider.class,method="selectAudit_type")
    List<Audit_type> findAudit_typeBySome(Audit_type audit_type);
    
    // 根据id查询和删除
    @Select("select * from "+ "audit_type" +" where id = #{id}")
    Audit_type findById(Integer id);
    
    @Select("delete from "+ "audit_type" +" where id = #{id}")
    void deleteById(Integer id);
    
    
    // 根据auditName查询和删除
    @Select("select * from "+ "audit_type" +" where audit_name = #{auditName}")
    Audit_type findByAuditName(String auditName);
    
    @Select("delete from "+ "audit_type" +" where audit_name = #{auditName}")
    void deleteByAuditName(String auditName);
    
    
}
