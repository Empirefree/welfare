package com.ctgu.ssm.entity;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String actualname;
	private String sex;
	private String province;
	private String city;
	private String address;
	private String phone;
	private String email;
	private String introduce;
	private String identity;
	private Integer isActualname;
	private String createtime;

	public User(){
	}
	public User(Integer id, String username, String password, String actualname, String sex, String province, String city, String address, String phone, String email, String introduce, String identity, Integer isActualname, String createtime) {
		super();this.id = id;
		this.username = username;
		this.password = password;
		this.actualname = actualname;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.introduce = introduce;
		this.identity = identity;
		this.isActualname = isActualname;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getActualname() {
		return actualname;
	}
	public void setActualname(String actualname){
		this.actualname = actualname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province){
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity){
		this.identity = identity;
	}
	public Integer getIsActualname() {
		return isActualname;
	}
	public void setIsActualname(Integer isActualname){
		this.isActualname = isActualname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime){
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return"user [id=" + id+ ", username=" +username+ ", password=" +password+ ", actualname=" +actualname+ ", sex=" +sex+ ", province=" +province+ ", city=" +city+ ", address=" +address+ ", phone=" +phone+ ", email=" +email+ ", introduce=" +introduce+ ", identity=" +identity+ ", isActualname=" +isActualname+ ", createtime=" +createtime + "]";
	}
}