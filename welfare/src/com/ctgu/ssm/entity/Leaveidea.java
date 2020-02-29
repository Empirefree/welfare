package com.ctgu.ssm.entity;

public class Leaveidea {
	private Integer id;
	private Integer ideaid;
	private Integer user1id;
	private String comment;
	private Integer isSolve;
	private String createtime;

	public Leaveidea(){
	}
	public Leaveidea(Integer id, Integer ideaid, Integer user1id, String comment, Integer isSolve, String createtime) {
		super();this.id = id;
		this.ideaid = ideaid;
		this.user1id = user1id;
		this.comment = comment;
		this.isSolve = isSolve;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getIdeaid() {
		return ideaid;
	}
	public void setIdeaid(Integer ideaid){
		this.ideaid = ideaid;
	}
	public Integer getUser1id() {
		return user1id;
	}
	public void setUser1id(Integer user1id){
		this.user1id = user1id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public Integer getIsSolve() {
		return isSolve;
	}
	public void setIsSolve(Integer isSolve){
		this.isSolve = isSolve;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return"leaveidea [id=" + id+ ", ideaid=" +ideaid+ ", user1id=" +user1id+ ", comment=" +comment+ ", isSolve=" +isSolve+ ", createtime=" +createtime + "]";
	}
}