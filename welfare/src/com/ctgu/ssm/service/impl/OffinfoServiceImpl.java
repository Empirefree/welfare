package com.ctgu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.ssm.dao.OffinfoDao;
import com.ctgu.ssm.entity.Offinfo;
import com.ctgu.ssm.service.OffinfoService;

@Service("offinfoService")
public class OffinfoServiceImpl implements OffinfoService{
    
    @Autowired
    private OffinfoDao offinfoDao;
    
    // 添加
    @Override
    public void addOffinfo(Offinfo offinfo){
        offinfoDao.insertOffinfo(offinfo);
    }
    
    // 更新
    @Override
    public void updateOffinfo(Offinfo offinfo){
        offinfoDao.updateOffinfo(offinfo);
    }
    
    // 找到所有对象
    @Override
    public List<Offinfo> findAllOffinfo(){
        return offinfoDao.findAllOffinfo();
    }
    
    // 根据一个抽象对象找到所有符合要求的对象
    @Override
    public List<Offinfo> findOffinfoBySome(Offinfo offinfo){
        return offinfoDao.findOffinfoBySome(offinfo);
    }
    
    // 根据id查找
    @Override
    public Offinfo findById(Integer id){
        return offinfoDao.findById(id);
    }
    
    // 根据id删除
    @Override
    public void deleteById(Integer id){
        offinfoDao.deleteById(id);
    }
    
    // 根据actid查找
    @Override
    public Offinfo findByActid(Integer actid){
        return offinfoDao.findByActid(actid);
    }
    
    // 根据actid删除
    @Override
    public void deleteByActid(Integer actid){
        offinfoDao.findByActid(actid);
    }
    
    // 根据userid查找
    @Override
    public Offinfo findByUserid(Integer userid){
        return offinfoDao.findByUserid(userid);
    }
    
    // 根据userid删除
    @Override
    public void deleteByUserid(Integer userid){
        offinfoDao.findByUserid(userid);
    }
    
    // 根据actimg查找
    @Override
    public Offinfo findByActimg(String actimg){
        return offinfoDao.findByActimg(actimg);
    }
    
    // 根据actimg删除
    @Override
    public void deleteByActimg(String actimg){
        offinfoDao.findByActimg(actimg);
    }
    
    // 根据name查找
    @Override
    public Offinfo findByName(String name){
        return offinfoDao.findByName(name);
    }
    
    // 根据name删除
    @Override
    public void deleteByName(String name){
        offinfoDao.findByName(name);
    }
    
    // 根据introduce查找
    @Override
    public Offinfo findByIntroduce(String introduce){
        return offinfoDao.findByIntroduce(introduce);
    }
    
    // 根据introduce删除
    @Override
    public void deleteByIntroduce(String introduce){
        offinfoDao.findByIntroduce(introduce);
    }
    
    // 根据acttypeid查找
    @Override
    public Offinfo findByActtypeid(String acttypeid){
        return offinfoDao.findByActtypeid(acttypeid);
    }
    
    // 根据acttypeid删除
    @Override
    public void deleteByActtypeid(String acttypeid){
        offinfoDao.findByActtypeid(acttypeid);
    }
    
    // 根据starttime查找
    @Override
    public Offinfo findByStarttime(String starttime){
        return offinfoDao.findByStarttime(starttime);
    }
    
    // 根据starttime删除
    @Override
    public void deleteByStarttime(String starttime){
        offinfoDao.findByStarttime(starttime);
    }
    
    // 根据endtime查找
    @Override
    public Offinfo findByEndtime(String endtime){
        return offinfoDao.findByEndtime(endtime);
    }
    
    // 根据endtime删除
    @Override
    public void deleteByEndtime(String endtime){
        offinfoDao.findByEndtime(endtime);
    }
    
    
}
