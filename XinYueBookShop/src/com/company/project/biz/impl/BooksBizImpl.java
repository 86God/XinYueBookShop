package com.company.project.biz.impl;

import java.util.ArrayList;

import com.company.project.biz.BooksBiz;
import com.company.project.dao.BookDao;
import com.company.project.dao.oracleimpl.BookDaoImpl;
import com.company.project.model.po.BookPo;

public class BooksBizImpl implements BooksBiz {
	private BookDao bookDao;
	public BooksBizImpl(){
		bookDao = new BookDaoImpl();
	}
	
	
	@Override
	public boolean insert(BookPo bookPo) {
		boolean flag = false;
		flag = bookDao.insert(bookPo);
		return flag;
	}
	
	@Override
	public boolean update(BookPo bookPo) {
		boolean flag = false;
		flag = bookDao.update(bookPo);
		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		flag = bookDao.delete(id);
		return flag;
	}

	@Override
	public BookPo findById(long id) {
		BookPo bookPo = null;
		bookPo = bookDao.findById(id);
		return bookPo;
	}

	@Override
	public ArrayList<BookPo> findAll() {
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDao.findAll();
		return bookPoList;
	}

	@Override
	public ArrayList<BookPo> findByType(String type) {
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDao.findByType(type);
		return bookPoList;
	}


	@Override
	public ArrayList<BookPo> findByDim(String name) {
		ArrayList<BookPo> bookPoList = new ArrayList<>();
		bookPoList = bookDao.findByDim(name);
		return bookPoList;
	}

}
