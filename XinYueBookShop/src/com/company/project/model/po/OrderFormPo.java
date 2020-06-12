package com.company.project.model.po;

import java.sql.Date;

public class OrderFormPo {
	private long id;
	private long userId;
	private long bookId;
	private int bookNum;
	private float money;
	private Date createDate;
	private String shippingAddress;
	private String shippingPersonName;
	private String type;
	private long shippingPhoneNum;
	
	
	public long getId() {
		return id;
	}
	public long getUserId() {
		return userId;
	}
	public long getBookId() {
		return bookId;
	}
	public int getBookNum() {
		return bookNum;
	}
	public float getMoney() {
		return money;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	
	
	
	public String getShippingPersonName() {
		return shippingPersonName;
	}
	public String getType() {
		return type;
	}

	public void setShippingPersonName(String shippingPersonName) {
		this.shippingPersonName = shippingPersonName;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getShippingPhoneNum() {
		return shippingPhoneNum;
	}
	public void setShippingPhoneNum(long shippingPhoneNum) {
		this.shippingPhoneNum = shippingPhoneNum;
	}
	@Override
	public String toString() {
		return "OrderFormPo [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", bookNum=" + bookNum
				+ ", money=" + money + ", createDate=" + createDate + ", shippingAddress=" + shippingAddress
				+ ", shippingPersonName=" + shippingPersonName + ", type=" + type + ", shippingPhoneNum="
				+ shippingPhoneNum + "]";
	}
}
