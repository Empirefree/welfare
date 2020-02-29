package com.ctgu.ssm.entity;

public class Apply {
	private Integer id;
	private Integer itemid;
	private Integer userid;
	private Integer auditid;
	private String createtime;

	public Apply(){
	}
	public Apply(Integer id, Integer itemid, Integer userid, Integer auditid, String createtime) {
		super();this.id = id;
		this.itemid = itemid;
		this.userid = userid;
		this.auditid = auditid;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid){
		this.itemid = itemid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	public Integer getAuditid() {
		return auditid;
	}
	public void setAuditid(Integer auditid){
		this.auditid = auditid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return"apply [id=" + id+ ", itemid=" +itemid+ ", userid=" +userid+ ", auditid=" +auditid+ ", createtime=" +createtime + "]";
	}
}