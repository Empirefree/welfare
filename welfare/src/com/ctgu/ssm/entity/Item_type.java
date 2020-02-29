package com.ctgu.ssm.entity;

public class Item_type {
    
    
    private Integer id;
    private String itemname; // 物品种类
    
    public Item_type(){
    }
    public Item_type(Integer id, String itemname) {
        super();this.id = id;
        this.itemname = itemname;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String itemname){
        this.itemname = itemname;
    }
    @Override
    public String toString() {
        return"item_type [id=" + id+ ", itemname=" +itemname + "]";
    }
}
