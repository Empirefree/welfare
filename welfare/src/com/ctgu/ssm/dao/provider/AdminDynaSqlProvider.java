package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Admin;

public class AdminDynaSqlProvider {

	// 动态查询
	public String selectAdmin(Admin admin){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("admin");
				if(admin != null){
					if(admin.getId() != null && !admin.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(admin.getUsername() != null && !admin.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{username},'%') ");
					}
					if(admin.getPassword() != null && !admin.getPassword().equals("")){
						WHERE(" password LIKE CONCAT ('%',#{password},'%') ");
					}
					if(admin.getAdminname() != null && !admin.getAdminname().equals("")){
						WHERE(" adminname LIKE CONCAT ('%',#{adminname},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertAdmin(Admin admin){

		return new SQL(){
			{
				INSERT_INTO("admin");
				if(admin.getId() != null && !admin.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(admin.getUsername() != null && !admin.getUsername().equals("")){
					VALUES(" username", "#{username}");
				}
				if(admin.getPassword() != null && !admin.getPassword().equals("")){
					VALUES(" password", "#{password}");
				}
				if(admin.getAdminname() != null && !admin.getAdminname().equals("")){
					VALUES(" adminname", "#{adminname}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateAdmin(Admin admin){

		return new SQL(){
			{
				UPDATE("admin");
				if(admin.getId() != null && !admin.getId().equals("")){
					SET(" id= #{id}");
				}
				if(admin.getUsername() != null && !admin.getUsername().equals("")){
					SET(" username= #{username}");
				}
				if(admin.getPassword() != null && !admin.getPassword().equals("")){
					SET(" password= #{password}");
				}
				if(admin.getAdminname() != null && !admin.getAdminname().equals("")){
					SET(" adminname= #{adminname}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}