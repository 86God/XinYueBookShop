package com.company.project.dao;

import java.util.ArrayList;
import com.company.project.model.po.BookPo;


public interface BookDao {
	// ����
	boolean insert(BookPo bookPo);

	// ����
	boolean update(BookPo bookPo);

	// ɾ��
	boolean delete(long id);

	// ��ѯ����
	BookPo findById(long id);

	// ��ѯ�����鼮
	ArrayList<BookPo> findAll();
	
	//��ҳ�����鼮
	/**
	 * 
	 * @param pageNums  ÿҳ������Ʒ
	 * @param pages		�ڶ���ҳ
	 * @return
	 */
	ArrayList<BookPo> findByPage(int pageNums,int pages);
	
	//�����鼮���Ͳ�ѯ�鼮
	ArrayList<BookPo> findByType(String type);
	
	//�����鼮�����ߺ�����ģ������
	ArrayList<BookPo> findByDim(String name);

}
