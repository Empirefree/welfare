package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Audit_type;

public interface Audit_typeService {
    
    
    // 添加
    void addAudit_type(Audit_type audit_type);
    
    // 更新
    void updateAudit_type(Audit_type audit_type);
    
    // 找到所有对象
    List<Audit_type> findAllAudit_type();
    
    // 根据一个抽象对象找到所有符合要求的对象
    List<Audit_type> findAudit_typeBySome(Audit_type audit_type);
    
    
    // 根据id查找
    Audit_type findById(Integer id);
    
    // 根据id删除
    void deleteById(Integer id);
    
    // 根据auditName查找
    Audit_type findByAuditName(String auditName);
    
    // 根据auditName删除
    void deleteByAuditName(String auditName);
    
    
}
