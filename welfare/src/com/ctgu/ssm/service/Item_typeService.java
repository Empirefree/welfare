package com.ctgu.ssm.service;

import java.util.List;

import com.ctgu.ssm.entity.Item_type;

public interface Item_typeService {
    
    
    // 添加
    void addItem_type(Item_type item_type);
    
    // 更新
    void updateItem_type(Item_type item_type);
    
    // 找到所有对象
    List<Item_type> findAllItem_type();
    
    // 根据一个抽象对象找到所有符合要求的对象
    List<Item_type> findItem_typeBySome(Item_type item_type);
    
    
    // 根据id查找
    Item_type findById(Integer id);
    
    // 根据id删除
    void deleteById(Integer id);
    
    // 根据itemname查找
    Item_type findByItemname(String itemname);
    
    // 根据itemname删除
    void deleteByItemname(String itemname);
    
    
}
