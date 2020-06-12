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
		bookPo.setAuthor("�����");
		bookPo.setBookImg("img\\004.png");
		bookPo.setIntroduction("����ӵ��ݺ�֮��");
		bookPo.setName("�����");
		bookPo.setPrice(80.50f);
		bookPo.setPublishingHouse("�й�����������");
		bookPo.setRepertoryNumber(10000);
		bookPo.setType("��ѧ");
		booksBiz.insert(bookPo);
	}
	
	public void testUpdate() {
		BooksBiz booksBiz = new BooksBizImpl();
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
		bookPoList = booksBiz.findByType("�����");
		for (BookPo bookPo : bookPoList) {
			System.out.println(bookPo);
		}
	}
}
