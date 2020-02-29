package com.ctgu.ssm.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.ctgu.ssm.entity.Audit_type;

public class Audit_typeDynaSqlProvider {
    
    // 动态查询
    public String selectAudit_type(Audit_type audit_type){
        
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM( "audit_type" );
                if(audit_type != null){
                    if(audit_type.getId() != null && !audit_type.getId().equals("")){
                        WHERE(" id LIKE CONCAT ('%',#{id},'%') ");
                    }
                    if(audit_type.getAuditName() != null && !audit_type.getAuditName().equals("")){
                        WHERE(" audi_name LIKE CONCAT ('%',#{auditName},'%') ");
                    }
                }
            }
        }.toString();
        
        return sql;
    }
    
    // 动态插入
    public String insertAudit_type(Audit_type audit_type){
        
        return new SQL(){
            {
                INSERT_INTO( "audit_type" );
                if(audit_type.getId() != null && !audit_type.getId().equals("")){
                    VALUES(" id", "#{id}");
                }
                if(audit_type.getAuditName() != null && !audit_type.getAuditName().equals("")){
                    VALUES(" audi_name", "#{auditName}");
                }
            }
        }.toString();
    }
    
    // 动态更新
    public String updateAudit_type(Audit_type audit_type){
        
        return new SQL(){
            {
                UPDATE( "audit_type" );
                if(audit_type.getId() != null && !audit_type.getId().equals("")){
                    SET(" id= #{id}");
                }
                if(audit_type.getAuditName() != null && !audit_type.getAuditName().equals("")){
                    SET(" audi_name= #{auditName}");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
    
}
