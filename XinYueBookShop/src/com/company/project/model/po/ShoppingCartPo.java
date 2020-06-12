package com.company.project.model.po;

public class ShoppingCartPo {
	private long id;
	private long userId;
	private long bookId;
	private int bookNum;

	public ShoppingCartPo() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public long getUserId() {
		return userId;
	}

	public long getBookId() {
		return bookId;
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

	
	
	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	@Override
	public String toString() {
		return "ShoppingCartPo [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", bookNum=" + bookNum + "]";
	}
}
