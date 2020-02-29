package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Apply;

public class ApplyDynaSqlProvider {

	// 动态查询
	public String selectApply(Apply apply){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "apply" );
				if(apply != null){
					if(apply.getId() != null && !apply.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(apply.getItemid() != null && !apply.getItemid().equals("")){
						WHERE(" itemid LIKE CONCAT ('%',#{itemid},'%') ");
					}
					if(apply.getUserid() != null && !apply.getUserid().equals("")){
						WHERE(" userid LIKE CONCAT ('%',#{userid},'%') ");
					}
					if(apply.getAuditid() != null && !apply.getAuditid().equals("")){
						WHERE(" auditid LIKE CONCAT ('%',#{auditid},'%') ");
					}
					if(apply.getCreatetime() != null && !apply.getCreatetime().equals("")){
						WHERE(" createtime LIKE CONCAT ('%',#{createtime},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertApply(Apply apply){

		return new SQL(){
			{
				INSERT_INTO( "apply" );
				if(apply.getId() != null && !apply.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(apply.getItemid() != null && !apply.getItemid().equals("")){
					VALUES(" itemid", "#{itemid}");
				}
				if(apply.getUserid() != null && !apply.getUserid().equals("")){
					VALUES(" userid", "#{userid}");
				}
				if(apply.getAuditid() != null && !apply.getAuditid().equals("")){
					VALUES(" auditid", "#{auditid}");
				}
				if(apply.getCreatetime() != null && !apply.getCreatetime().equals("")){
					VALUES(" createtime", "#{createtime}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateApply(Apply apply){

		return new SQL(){
			{
				UPDATE( "apply" );
				if(apply.getId() != null && !apply.getId().equals("")){
					SET(" id= #{id}");
				}
				if(apply.getItemid() != null && !apply.getItemid().equals("")){
					SET(" itemid= #{itemid}");
				}
				if(apply.getUserid() != null && !apply.getUserid().equals("")){
					SET(" userid= #{userid}");
				}
				if(apply.getAuditid() != null && !apply.getAuditid().equals("")){
					SET(" auditid= #{auditid}");
				}
				if(apply.getCreatetime() != null && !apply.getCreatetime().equals("")){
					SET(" createtime= #{createtime}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}