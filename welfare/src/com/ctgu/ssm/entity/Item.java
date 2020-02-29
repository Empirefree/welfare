package com.ctgu.ssm.entity;

public class Item {
	private Integer id;
	private String itemname;
	private String itemimg;
	private Integer itemcount;
	private String introduce;
	private Integer userid;
	private Integer typeid;
	private Integer auditid;
	private String createtime;

	public Item(){
	}
	public Item(Integer id, String itemname, String itemimg, Integer itemcount, String introduce, Integer userid, Integer typeid, Integer auditid, String createtime) {
		super();this.id = id;
		this.itemname = itemname;
		this.itemimg = itemimg;
		this.itemcount = itemcount;
		this.introduce = introduce;
		this.userid = userid;
		this.typeid = typeid;
		this.auditid = auditid;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname){
		this.itemname = itemname;
	}
	public String getItemimg() {
		return itemimg;
	}
	public void setItemimg(String itemimg){
		this.itemimg = itemimg;
	}
	public Integer getItemcount() {
		return itemcount;
	}
	public void setItemcount(Integer itemcount){
		this.itemcount = itemcount;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid){
		this.typeid = typeid;
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
		return"item [id=" + id+ ", itemname=" +itemname+ ", itemimg=" +itemimg+ ", itemcount=" +itemcount+ ", introduce=" +introduce+ ", userid=" +userid+ ", typeid=" +typeid+ ", auditid=" +auditid+ ", createtime=" +createtime + "]";
	}
}