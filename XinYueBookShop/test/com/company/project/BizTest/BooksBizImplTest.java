package com.company.project.BizTest;

import java.util.ArrayList;

import com.company.project.biz.BooksBiz;
import com.company.project.biz.impl.BooksBizImpl;
import com.company.project.model.po.BookPo;

import junit.framework.TestCase;

public class BooksBizImplTest extends TestCase{
	public void testInsert() {
		BooksBiz booksBiz = new BooksBizImpl();
		BookPo bookPo = new BookPo();
		bookPo.setAuthor("鬼谷子");
		bookPo.setBookImg("img\\004.png");
		bookPo.setIntroduction("鬼谷子的纵横之道");
		bookPo.setName("鬼谷子");
		bookPo.setPrice(80.50f);
		bookPo.setPublishingHouse("中国长安出版社");
		bookPo.setRepertoryNumber(10000);
		bookPo.setType("文学");
		booksBiz.insert(bookPo);
	}
	
	public void testUpdate() {
		BooksBiz booksBiz = new BooksBizImpl();
		BookPo bookPo = new BookPo();
		bookPo.setId(1000011l);
		bookPo.setName("码出高效");
		bookPo.setType("计算机");
		bookPo.setAuthor("杨冠宝");
		bookPo.setBookImg("img\\005.png");
		bookPo.setIntroduction("我们一起合作写经济发展的代码，写未来社会发展的每一行代码，码出高效，码出未来");
		bookPo.setPublishingHouse("电子工业出版社");
		bookPo.setPrice(99.99f);
		bookPo.setRepertoryNumber(500);
		booksBiz.update(bookPo);
	}
	
	public void testDelete() {
		BooksBiz booksBiz = new BooksBizImpl();
		booksBiz.delete(1000014l);
	}
	
	public void testFindById() {
		BooksBiz booksBiz = new BooksBizImpl();
		BookPo bookPo = booksBiz.findById(1000011l);
		System.out.println(bookPo);
	}
	
	public void testFindAll() {
		BooksBiz booksBiz = new BooksBizImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = booksBiz.findAll();
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
	
	public void testFindByType() {
		BooksBiz booksBiz = new BooksBizImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = booksBiz.findByType("计算机");
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
}
