package com.company.project.dao;

import java.awt.List;
import java.util.ArrayList;

import com.company.project.model.po.OrderFormDetailPage;
import com.company.project.model.po.OrderFormPo;

public interface OrderFormDao {
	// 插入
	boolean insert(OrderFormPo orderForm);

	// 更新
	boolean update(OrderFormPo orderForm);

	// 删除
	boolean delete(long id);

	// 查询主键
	OrderFormPo findById(long id);
	
	//查询
//	OrderFormDetailPage findByIdDetailPage(long id);

	// 查询所有订单
	ArrayList<OrderFormPo> findAll();

	// 分页查询订单
	ArrayList<OrderFormPo> findByPage();

	// 根据用户id查询个人的所有订单
	ArrayList<OrderFormPo> findByUserId(long userId);
	
	// 根据用户id 和 订单类型查询个人的所有订单
    ArrayList<OrderFormPo> findByUserIdAndType(long userId,String type);

}
