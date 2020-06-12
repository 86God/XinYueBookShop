package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.dao.oracleimpl.BookDaoImpl;
import com.company.project.model.po.BookPo;

public interface BooksBiz {
	//插入书籍
	public boolean insert(BookPo bookPo);
	
	//更改书籍信息
	public boolean update(BookPo bookPo);
	
	//删除书籍
	public boolean delete(long id);
	
	//根据ID查询书籍
	public BookPo findById(long id);
	
	//查询所有书籍
	public ArrayList<BookPo> findAll();
	
	//按书籍类型查询书籍
	public ArrayList<BookPo> findByType(String type);
	
	//搜索框搜索查询
	public ArrayList<BookPo> findByDim(String name);
	
}
