package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.ActType;

public class ActTypeDynaSqlProvider {

	// 动态查询
	public String selectActType(ActType actType){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "acttype" );
				if(actType != null){
					if(actType.getId() != null && !actType.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(actType.getActname() != null && !actType.getActname().equals("")){
						WHERE(" actname LIKE CONCAT ('%',#{actname},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertActType(ActType actType){

		return new SQL(){
			{
				INSERT_INTO( "acttype" );
				if(actType.getId() != null && !actType.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(actType.getActname() != null && !actType.getActname().equals("")){
					VALUES(" actname", "#{actname}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateActType(ActType actType){

		return new SQL(){
			{
				UPDATE( "acttype" );
				if(actType.getId() != null && !actType.getId().equals("")){
					SET(" id= #{id}");
				}
				if(actType.getActname() != null && !actType.getActname().equals("")){
					SET(" actname= #{actname}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}