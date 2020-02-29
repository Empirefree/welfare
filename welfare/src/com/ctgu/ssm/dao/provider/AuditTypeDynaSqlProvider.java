package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.AuditType;

public class AuditTypeDynaSqlProvider {

	// 动态查询
	public String selectAuditType(AuditType auditType){

		String sql =  new SQL(){
			{
				SELECT("*");
				FROM( "audit_type" );
				if(auditType != null){
					if(auditType.getId() != null && !auditType.getId().equals("")){
						WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
					}
					if(auditType.getAuditName() != null && !auditType.getAuditName().equals("")){
						WHERE(" audi_name LIKE CONCAT ('%',#{auditName},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态插入
	public String insertAuditType(AuditType auditType){

		return new SQL(){
			{
				INSERT_INTO( "audit_type" );
				if(auditType.getId() != null && !auditType.getId().equals("")){
					VALUES(" id", "#{id}");
				}
				if(auditType.getAuditName() != null && !auditType.getAuditName().equals("")){
					VALUES(" audi_name", "#{auditName}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateAuditType(AuditType auditType){

		return new SQL(){
			{
				UPDATE( "audit_type" );
				if(auditType.getId() != null && !auditType.getId().equals("")){
					SET(" id= #{id}");
				}
				if(auditType.getAuditName() != null && !auditType.getAuditName().equals("")){
					SET(" audi_name= #{auditName}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}