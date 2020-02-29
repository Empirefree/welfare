package com.ctgu.ssm.entity;

public class Interactive {
	private Integer id;
	private Integer itemid;
	private Integer donorid;
	private Integer receiveid;
	private String content;
	private Integer distin;
	private String createtime;

	public Interactive(){
	}
	public Interactive(Integer id, Integer itemid, Integer donorid, Integer receiveid, String content, Integer distin, String createtime) {
		super();this.id = id;
		this.itemid = itemid;
		this.donorid = donorid;
		this.receiveid = receiveid;
		this.content = content;
		this.distin = distin;
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
	public Integer getDonorid() {
		return donorid;
	}
	public void setDonorid(Integer donorid){
		this.donorid = donorid;
	}
	public Integer getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(Integer receiveid){
		this.receiveid = receiveid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Integer getDistin() {
		return distin;
	}
	public void setDistin(Integer distin){
		this.distin = distin;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return"interactive [id=" + id+ ", itemid=" +itemid+ ", donorid=" +donorid+ ", receiveid=" +receiveid+ ", content=" +content+ ", distin=" +distin+ ", createtime=" +createtime + "]";
	}
}