package com.ctgu.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.SelectProvider;

import com.ctgu.ssm.dao.provider.Item_typeDynaSqlProvider;

import com.ctgu.ssm.entity.Item_type;

public interface Item_typeDao {
    
    // 动态插入
    @SelectProvider(type=Item_typeDynaSqlProvider.class,method="insertItem_type")
    void insertItem_type(Item_type item_type);
    
    // 动态修改
    @SelectProvider(type=Item_typeDynaSqlProvider.class,method="updateItem_type")
    void updateItem_type(Item_type item_type);
    
    // 查找所有
    @Select("select * from " +  "item_type" )
    List<Item_type> findAllItem_type();
    
    // 动态查询
    @SelectProvider(type=Item_typeDynaSqlProvider.class,method="selectItem_type")
    List<Item_type> findItem_typeBySome(Item_type item_type);
    
    // 根据id查询和删除
    @Select("select * from "+ "item_type" +" where id = #{id}")
    Item_type findById(Integer id);
    
    @Select("delete from "+ "item_type" +" where id = #{id}")
    void deleteById(Integer id);
    
    
    // 根据itemname查询和删除
    @Select("select * from "+ "item_type" +" where itemname = #{itemname}")
    Item_type findByItemname(String itemname);
    
    @Select("delete from "+ "item_type" +" where itemname = #{itemname}")
    void deleteByItemname(String itemname);
    
    
}
