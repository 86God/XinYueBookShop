package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

import oracle.net.aso.s;

public interface OrderFormBiz {
	//用户点击购买自动创建订单
	OrderFormPo create (BookPo bookPo, int num, UserPo userPo,UserPo consignee);
	
	//确定订单
	boolean insert(OrderFormPo orderFormPo);
	
	//修改订单
	boolean update(OrderFormPo orderFormPo);
	
	//删除订单
	boolean delete(long id);
	
	//查询订单
	OrderFormPo findById(long id);
	
	//查询所有订单
	ArrayList<OrderFormPo> findAll();
	
	//分页查询订单
	ArrayList<OrderFormPo> findByPage();
	
	//根据用户id查询个人的所有订单
	ArrayList<OrderFormPo> findByUserId(long userId);
	
	//分页根据用户id查询个人的订单
	ArrayList<OrderFormPo> findByUserIdPage();
	
	//根据用户id和订单类型查询订单
	ArrayList<OrderFormPo> findByUserIdAndType(long userId,String type);
}