package com.ctgu.ssm.entity;

public class AuditType {
	private Integer id;
	private String auditName;

	public AuditType(){
	}
	public AuditType(Integer id, String auditName) {
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
		return"auditType [id=" + id+ ", auditName=" +auditName + "]";
	}
}