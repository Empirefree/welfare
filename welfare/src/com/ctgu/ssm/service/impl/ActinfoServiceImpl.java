package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.ActinfoDao;
import com.ctgu.ssm.entity.Actinfo;
import com.ctgu.ssm.service.ActinfoService;

@Service("actinfoService")
public class ActinfoServiceImpl implements ActinfoService{
    
    @Autowired
    private ActinfoDao actinfoDao;
    
    // 添加
    @Override
    public void addActinfo(Actinfo actinfo){
        actinfoDao.insertActinfo(actinfo);
    }
    
    // 更新
    @Override
    public void updateActinfo(Actinfo actinfo){
        actinfoDao.updateActinfo(actinfo);
    }
    
    // 找到所有对象
    @Override
    public List<Actinfo> findAllActinfo(){
        return actinfoDao.findAllActinfo();
    }
    
    // 根据一个抽象对象找到所有符合要求的对象
    @Override
    public List<Actinfo> findActinfoBySome(Actinfo actinfo){
        return actinfoDao.findActinfoBySome(actinfo);
    }
    
    // 根据id查找
    @Override
    public Actinfo findById(Integer id){
        return actinfoDao.findById(id);
    }
    
    // 根据id删除
    @Override
    public void deleteById(Integer id){
        actinfoDao.deleteById(id);
    }
    
    // 根据actid查找
    @Override
    public Actinfo findByActid(Integer actid){
        return actinfoDao.findByActid(actid);
    }
    
    // 根据actid删除
    @Override
    public void deleteByActid(Integer actid){
        actinfoDao.findByActid(actid);
    }
    
    // 根据userid查找
    @Override
    public Actinfo findByUserid(Integer userid){
        return actinfoDao.findByUserid(userid);
    }
    
    // 根据userid删除
    @Override
    public void deleteByUserid(Integer userid){
        actinfoDao.findByUserid(userid);
    }
    
    // 根据auditid查找
    @Override
    public Actinfo findByAuditid(Integer auditid){
        return actinfoDao.findByAuditid(auditid);
    }
    
    // 根据auditid删除
    @Override
    public void deleteByAuditid(Integer auditid){
        actinfoDao.findByAuditid(auditid);
    }
    
    // 根据actimg查找
    @Override
    public Actinfo findByActimg(String actimg){
        return actinfoDao.findByActimg(actimg);
    }
    
    // 根据actimg删除
    @Override
    public void deleteByActimg(String actimg){
        actinfoDao.findByActimg(actimg);
    }
    
    // 根据name查找
    @Override
    public Actinfo findByName(String name){
        return actinfoDao.findByName(name);
    }
    
    // 根据name删除
    @Override
    public void deleteByName(String name){
        actinfoDao.findByName(name);
    }
    
    // 根据introduce查找
    @Override
    public Actinfo findByIntroduce(String introduce){
        return actinfoDao.findByIntroduce(introduce);
    }
    
    // 根据introduce删除
    @Override
    public void deleteByIntroduce(String introduce){
        actinfoDao.findByIntroduce(introduce);
    }
    
    // 根据acttypeid查找
    @Override
    public Actinfo findByActtypeid(String acttypeid){
        return actinfoDao.findByActtypeid(acttypeid);
    }
    
    // 根据acttypeid删除
    @Override
    public void deleteByActtypeid(String acttypeid){
        actinfoDao.findByActtypeid(acttypeid);
    }
    
    // 根据starttime查找
    @Override
    public Actinfo findByStarttime(String starttime){
        return actinfoDao.findByStarttime(starttime);
    }
    
    // 根据starttime删除
    @Override
    public void deleteByStarttime(String starttime){
        actinfoDao.findByStarttime(starttime);
    }
    
    // 根据endtime查找
    @Override
    public Actinfo findByEndtime(String endtime){
        return actinfoDao.findByEndtime(endtime);
    }
    
    // 根据endtime删除
    @Override
    public void deleteByEndtime(String endtime){
        actinfoDao.findByEndtime(endtime);
    }
    
    
}
