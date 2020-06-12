package com.company.project.model.po;

public class UserPo {
	private long id;
	private String userName;
	private long phoneNum;
	private String password;
	private String name;
	private String sex;
	private String shippingAddress;
	
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@Override
	public String toString() {
		return "UserPo [id=" + id + ", userName=" + userName + ", phoneNum=" + phoneNum + ", password=" + password
				+ ", name=" + name + ", sex=" + sex + ", shippingAddress=" + shippingAddress + "]";
	}

}
