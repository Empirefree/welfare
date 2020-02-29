package com.ctgu.ssm.entity;

public class ItemType {
	private Integer id;
	private String itemname;

	public ItemType(){
	}
	public ItemType(Integer id, String itemname) {
		super();this.id = id;
		this.itemname = itemname;
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
	@Override
	public String toString() {
		return"itemType [id=" + id+ ", itemname=" +itemname + "]";
	}
}