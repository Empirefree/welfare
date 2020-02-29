package com.ctgu.ssm.entity;

public class Audit_type {
    
    
    private Integer id;
    private String auditName; // 审核过程
    
    public Audit_type(){
    }
    public Audit_type(Integer id, String auditName) {
        super();this.id = id;
        this.auditName = auditName;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getAuditName() {
        return auditName;
    }
    public void setAuditName(String auditName){
        this.auditName = auditName;
    }
    @Override
    public String toString() {
        return"audit_type [id=" + id+ ", auditName=" +auditName + "]";
    }
}
