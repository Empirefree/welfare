package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Actinfo;

public interface ActinfoService {
    
    
    // 添加
    void addActinfo(Actinfo actinfo);
    
    // 更新
    void updateActinfo(Actinfo actinfo);
    
    // 找到所有对象
    List<Actinfo> findAllActinfo();
    
    // 根据一个抽象对象找到所有符合要求的对象
    List<Actinfo> findActinfoBySome(Actinfo actinfo);
    
    
    // 根据id查找
    Actinfo findById(Integer id);
    
    // 根据id删除
    void deleteById(Integer id);
    
    // 根据actid查找
    Actinfo findByActid(Integer actid);
    
    // 根据actid删除
    void deleteByActid(Integer actid);
    
    // 根据userid查找
    Actinfo findByUserid(Integer userid);
    
    // 根据userid删除
    void deleteByUserid(Integer userid);
    
    // 根据auditid查找
    Actinfo findByAuditid(Integer auditid);
    
    // 根据auditid删除
    void deleteByAuditid(Integer auditid);
    
    // 根据actimg查找
    Actinfo findByActimg(String actimg);
    
    // 根据actimg删除
    void deleteByActimg(String actimg);
    
    // 根据name查找
    Actinfo findByName(String name);
    
    // 根据name删除
    void deleteByName(String name);
    
    // 根据introduce查找
    Actinfo findByIntroduce(String introduce);
    
    // 根据introduce删除
    void deleteByIntroduce(String introduce);
    
    // 根据acttypeid查找
    Actinfo findByActtypeid(String acttypeid);
    
    // 根据acttypeid删除
    void deleteByActtypeid(String acttypeid);
    
    // 根据starttime查找
    Actinfo findByStarttime(String starttime);
    
    // 根据starttime删除
    void deleteByStarttime(String starttime);
    
    // 根据endtime查找
    Actinfo findByEndtime(String endtime);
    
    // 根据endtime删除
    void deleteByEndtime(String endtime);
    
    
}
