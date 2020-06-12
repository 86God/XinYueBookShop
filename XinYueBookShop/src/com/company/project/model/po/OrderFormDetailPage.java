package com.company.project.model.po;

import java.sql.Date;

public class OrderFormDetailPage {
	private long orderFormId;
	private long bookId;
	private String bookName;
	private String bookAuthor;
	private float bookPrice;
	private String publishingHouse;
	private Date createDate;
	private String userName;
	private long phoneNum;
	private String consignee;
	private String shippingAddress;
	public long getOrderFormId() {
		return orderFormId;
	}
	public long getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public String getUserName() {
		return userName;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public String getConsignee() {
		return consignee;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setOrderFormId(long orderFormId) {
		this.orderFormId = orderFormId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@Override
	public String toString() {
		return "OrderFormDetailPage [orderFormId=" + orderFormId + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice + ", publishingHouse=" + publishingHouse
				+ ", createDate=" + createDate + ", userName=" + userName + ", phoneNum=" + phoneNum + ", consignee="
				+ consignee + ", shippingAddress=" + shippingAddress + "]";
	}
	
	
	
}
