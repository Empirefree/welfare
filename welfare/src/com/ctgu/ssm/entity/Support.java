package com.ctgu.ssm.entity;

public class Support {
	private Integer id;
	private Integer donorid;
	private Integer itemid;
	private Integer itemnum;
	private Integer receiveid;
	private String remarks;
	private Integer distin;
	private String createtime;

	public Support(){
	}
	public Support(Integer id, Integer donorid, Integer itemid, Integer itemnum, Integer receiveid, String remarks, Integer distin, String createtime) {
		super();this.id = id;
		this.donorid = donorid;
		this.itemid = itemid;
		this.itemnum = itemnum;
		this.receiveid = receiveid;
		this.remarks = remarks;
		this.distin = distin;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getDonorid() {
		return donorid;
	}
	public void setDonorid(Integer donorid){
		this.donorid = donorid;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid){
		this.itemid = itemid;
	}
	public Integer getItemnum() {
		return itemnum;
	}
	public void setItemnum(Integer itemnum){
		this.itemnum = itemnum;
	}
	public Integer getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(Integer receiveid){
		this.receiveid = receiveid;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks){
		this.remarks = remarks;
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
		return"support [id=" + id+ ", donorid=" +donorid+ ", itemid=" +itemid+ ", itemnum=" +itemnum+ ", receiveid=" +receiveid+ ", remarks=" +remarks+ ", distin=" +distin+ ", createtime=" +createtime + "]";
	}
}