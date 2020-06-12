package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.dao.oracleimpl.BookDaoImpl;
import com.company.project.model.po.BookPo;

public interface BooksBiz {
	//�����鼮
	public boolean insert(BookPo bookPo);
	
	//�����鼮��Ϣ
	public boolean update(BookPo bookPo);
	
	//ɾ���鼮
	public boolean delete(long id);
	
	//����ID��ѯ�鼮
	public BookPo findById(long id);
	
	//��ѯ�����鼮
	public ArrayList<BookPo> findAll();
	
	//���鼮���Ͳ�ѯ�鼮
	public ArrayList<BookPo> findByType(String type);
	
	//������������ѯ
	public ArrayList<BookPo> findByDim(String name);
	
}
