package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.ItemType;

public class ItemTypeDynaSqlProvider {

	// 动态查询
	public String selectItemType(ItemType itemType){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "item_type" );
				if(itemType != null){
					if(itemType.getId() != null && !itemType.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(itemType.getItemname() != null && !itemType.getItemname().equals("")){
						WHERE(" itemname LIKE CONCAT ('%',#{itemname},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertItemType(ItemType itemType){

		return new SQL(){
			{
				INSERT_INTO( "item_type" );
				if(itemType.getId() != null && !itemType.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(itemType.getItemname() != null && !itemType.getItemname().equals("")){
					VALUES(" itemname", "#{itemname}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateItemType(ItemType itemType){

		return new SQL(){
			{
				UPDATE( "item_type" );
				if(itemType.getId() != null && !itemType.getId().equals("")){
					SET(" id= #{id}");
				}
				if(itemType.getItemname() != null && !itemType.getItemname().equals("")){
					SET(" itemname= #{itemname}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}