package com.company.project.daoOracleImpl;

import java.util.ArrayList;

import com.company.project.dao.BookDao;
import com.company.project.dao.oracleimpl.BookDaoImpl;
import com.company.project.model.po.BookPo;

import junit.framework.TestCase;

public class BooksDaoImplTest extends TestCase {
	public void testInsert() {
		BookDao bookDaoImpl = new BookDaoImpl();
		BookPo bookPo = new BookPo();
		bookPo.setAuthor("鬼谷子");
		bookPo.setBookImg("img\\004.png");
		bookPo.setIntroduction("鬼谷子的纵横之道");
		bookPo.setName("鬼谷子");
		bookPo.setPrice(80.50f);
		bookPo.setPublishingHouse("中国长安出版社");
		bookPo.setRepertoryNumber(10000);
		bookPo.setType("文学");
		bookDaoImpl.insert(bookPo);
	}
	
	public void testUpdate() {
		BookDao bookDaoImpl = new BookDaoImpl();
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
		bookDaoImpl.update(bookPo);
	}
	
	public void testDelete() {
		BookDao bookDaoImpl = new BookDaoImpl();
		bookDaoImpl.delete(1000013l);
	}
	
	public void testFindById() {
		BookDao bookDaoImpl = new BookDaoImpl();
		BookPo bookPo = bookDaoImpl.findById(1000011l);
		System.out.println(bookPo);
	}
	
	public void testFindAll() {
		BookDao bookDaoImpl = new BookDaoImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDaoImpl.findAll();
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
	
	public void testFindByType() {
		BookDao bookDaoImpl = new BookDaoImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDaoImpl.findByType("计算机");
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
	
	public void testFindByDim() {
		BookDao bookDaoImpl = new BookDaoImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDaoImpl.findByDim("雨");
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
	
	public void testFindByPage() {
		BookDao bookDaoImpl = new BookDaoImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDaoImpl.findByPage(12, 2);
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
}
