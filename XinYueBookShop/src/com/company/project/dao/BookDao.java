package com.company.project.dao;

import java.util.ArrayList;
import com.company.project.model.po.BookPo;


public interface BookDao {
	// 插入
	boolean insert(BookPo bookPo);

	// 更新
	boolean update(BookPo bookPo);

	// 删除
	boolean delete(long id);

	// 查询主键
	BookPo findById(long id);

	// 查询所有书籍
	ArrayList<BookPo> findAll();
	
	//分页查找书籍
	/**
	 * 
	 * @param pageNums  每页多少商品
	 * @param pages		第多少页
	 * @return
	 */
	ArrayList<BookPo> findByPage(int pageNums,int pages);
	
	//按照书籍类型查询书籍
	ArrayList<BookPo> findByType(String type);
	
	//按照书籍的作者和书名模糊搜索
	ArrayList<BookPo> findByDim(String name);

}
