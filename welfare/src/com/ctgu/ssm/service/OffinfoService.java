package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Offinfo;

public interface OffinfoService {
    
    
    // 添加
    void addOffinfo(Offinfo offinfo);
    
    // 更新
    void updateOffinfo(Offinfo offinfo);
    
    // 找到所有对象
    List<Offinfo> findAllOffinfo();
    
    // 根据一个抽象对象找到所有符合要求的对象
    List<Offinfo> findOffinfoBySome(Offinfo offinfo);
    
    
    // 根据id查找
    Offinfo findById(Integer id);
    
    // 根据id删除
    void deleteById(Integer id);
    
    // 根据actid查找
    Offinfo findByActid(Integer actid);
    
    // 根据actid删除
    void deleteByActid(Integer actid);
    
    // 根据userid查找
    Offinfo findByUserid(Integer userid);
    
    // 根据userid删除
    void deleteByUserid(Integer userid);
    
    // 根据actimg查找
    Offinfo findByActimg(String actimg);
    
    // 根据actimg删除
    void deleteByActimg(String actimg);
    
    // 根据name查找
    Offinfo findByName(String name);
    
    // 根据name删除
    void deleteByName(String name);
    
    // 根据introduce查找
    Offinfo findByIntroduce(String introduce);
    
    // 根据introduce删除
    void deleteByIntroduce(String introduce);
    
    // 根据acttypeid查找
    Offinfo findByActtypeid(String acttypeid);
    
    // 根据acttypeid删除
    void deleteByActtypeid(String acttypeid);
    
    // 根据starttime查找
    Offinfo findByStarttime(String starttime);
    
    // 根据starttime删除
    void deleteByStarttime(String starttime);
    
    // 根据endtime查找
    Offinfo findByEndtime(String endtime);
    
    // 根据endtime删除
    void deleteByEndtime(String endtime);
    
    
}
