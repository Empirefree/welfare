package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Item_type;

public class Item_typeDynaSqlProvider {
    
    // 动态查询
    public String selectItem_type(Item_type item_type){
        
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM( "item_type" );
                if(item_type != null){
                    if(item_type.getId() != null && !item_type.getId().equals("")){
                        WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
                    }
                    if(item_type.getItemname() != null && !item_type.getItemname().equals("")){
                        WHERE(" itemname LIKE CONCAT ('%',#{itemname},'%') ");
                    }
                }
            }
        }.toString();
        
        return sql;
    }
    
    // 动态插入
    public String insertItem_type(Item_type item_type){
        
        return new SQL(){
            {
                INSERT_INTO( "item_type" );
                if(item_type.getId() != null && !item_type.getId().equals("")){
                    VALUES(" id", "#{id}");
                }
                if(item_type.getItemname() != null && !item_type.getItemname().equals("")){
                    VALUES(" itemname", "#{itemname}");
                }
            }
        }.toString();
    }
    
    // 动态更新
    public String updateItem_type(Item_type item_type){
        
        return new SQL(){
            {
                UPDATE( "item_type" );
                if(item_type.getId() != null && !item_type.getId().equals("")){
                    SET(" id= #{id}");
                }
                if(item_type.getItemname() != null && !item_type.getItemname().equals("")){
                    SET(" itemname= #{itemname}");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
    
}
