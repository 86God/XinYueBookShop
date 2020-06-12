package com.company.project.dao;

import java.util.ArrayList;


import com.company.project.model.po.ShoppingCartPo;;


public interface ShoppingCartDao {
	// 插入
	boolean insert(ShoppingCartPo shoppingCartPo);

	// 更新
	boolean update(ShoppingCartPo shoppingCartPo);

	// 删除
	boolean delete(long id);

	// 查询主键
	ShoppingCartPo findById(long id);
	
	//查询
	ShoppingCartPo findByIdDetailPage(long id);

	// 查询所有订单
	ArrayList<ShoppingCartPo> findAll();

	// 分页查询订单
	ArrayList<ShoppingCartPo> findByPage();

	// 根据用户id查询个人的所有订单
	ArrayList<ShoppingCartPo> findByUserId(long userId);
	
	//查询用户购物车中是否存在该商品
	Long isHavaBook(ShoppingCartPo shoppingCartPo);

}
