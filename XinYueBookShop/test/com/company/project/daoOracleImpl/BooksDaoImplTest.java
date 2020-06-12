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
		bookPo.setAuthor("�����");
		bookPo.setBookImg("img\\004.png");
		bookPo.setIntroduction("����ӵ��ݺ�֮��");
		bookPo.setName("�����");
		bookPo.setPrice(80.50f);
		bookPo.setPublishingHouse("�й�����������");
		bookPo.setRepertoryNumber(10000);
		bookPo.setType("��ѧ");
		bookDaoImpl.insert(bookPo);
	}
	
	public void testUpdate() {
		BookDao bookDaoImpl = new BookDaoImpl();
		BookPo bookPo = new BookPo();
		bookPo.setId(1000011l);
		bookPo.setName("�����Ч");
		bookPo.setType("�����");
		bookPo.setAuthor("��ڱ�");
		bookPo.setBookImg("img\\005.png");
		bookPo.setIntroduction("����һ�����д���÷�չ�Ĵ��룬дδ����ᷢչ��ÿһ�д��룬�����Ч�����δ��");
		bookPo.setPublishingHouse("���ӹ�ҵ������");
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
		bookPoList = bookDaoImpl.findByType("�����");
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
	
	public void testFindByDim() {
		BookDao bookDaoImpl = new BookDaoImpl();
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDaoImpl.findByDim("��");
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
