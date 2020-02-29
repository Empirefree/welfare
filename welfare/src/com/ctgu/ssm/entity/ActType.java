package com.ctgu.ssm.entity;

public class ActType {
	private Integer id;
	private String actname;

	public ActType(){
	}
	public ActType(Integer id, String actname) {
		super();this.id = id;
		this.actname = actname;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getActname() {
		return actname;
	}
	public void setActname(String actname){
		this.actname = actname;
	}
	@Override
	public String toString() {
		return"actType [id=" + id+ ", actname=" +actname + "]";
	}
}