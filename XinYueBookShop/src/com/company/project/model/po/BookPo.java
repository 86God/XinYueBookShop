package com.company.project.model.po;

public class BookPo {
	private long id;
	private String name;
	private String type;
	private String author;
	private float price;
	private String bookImg;
	private String introduction;
	private String publishingHouse;
	private int repertoryNumber;
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getAuthor() {
		return author;
	}
	public float getPrice() {
		return price;
	}
	public String getBookImg() {
		return bookImg;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public int getRepertoryNumber() {
		return repertoryNumber;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public void setRepertoryNumber(int repertoryNumber) {
		this.repertoryNumber = repertoryNumber;
	}
	@Override
	public String toString() {
		return "BookPo [id=" + id + ", name=" + name + ", type=" + type + ", author=" + author + ", price=" + price
				+ ", bookImg=" + bookImg + ", introduction=" + introduction + ", publishingHouse=" + publishingHouse
				+ ", repertoryNumber=" + repertoryNumber + "]";
	}

}
