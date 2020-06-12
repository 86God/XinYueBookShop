package com.company.project.biz.impl;

import java.util.ArrayList;

import com.company.project.biz.OrderFormBiz;
import com.company.project.dao.OrderFormDao;
import com.company.project.dao.oracleimpl.OrderFormDaoimpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

public class OrderFormBizImpl implements OrderFormBiz {
	private OrderFormDao orderFormDao;
	
	public OrderFormBizImpl() {
		this.orderFormDao = new OrderFormDaoimpl();
	}
	
	@Override
	public OrderFormPo create(BookPo bookPo, int num, UserPo userPo,UserPo consignee) {
		OrderFormPo orderFormPo = new OrderFormPo();
		orderFormPo.setBookId(bookPo.getId());
		orderFormPo.setBookNum(num);
		orderFormPo.setMoney(bookPo.getPrice() * num);
		orderFormPo.setUserId(userPo.getId());
		orderFormPo.setShippingAddress(consignee.getShippingAddress());
		orderFormPo.setShippingPersonName(consignee.getName());
		orderFormPo.setShippingPhoneNum(consignee.getPhoneNum());
		return orderFormPo;
	}

	@Override
	public boolean insert(OrderFormPo orderFormPo) {
		if(this.orderFormDao.insert(orderFormPo)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(OrderFormPo orderFormPo) {
		if(this.orderFormDao.update(orderFormPo)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(long id) {
		if(this.orderFormDao.delete(id)) {
			return true;
		}
		return false;
	}

	@Override
	public OrderFormPo findById(long id) {
		return this.orderFormDao.findById(id);
	}

	@Override
	public ArrayList<OrderFormPo> findAll() {
		return this.orderFormDao.findAll();
	}

	@Override
	public ArrayList<OrderFormPo> findByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderFormPo> findByUserId(long userId) {
		// TODO Auto-generated method stub
		return this.orderFormDao.findByUserId(userId);
	}

	@Override
	public ArrayList<OrderFormPo> findByUserIdPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderFormPo> findByUserIdAndType(long userId,String type) {		
		return this.orderFormDao.findByUserIdAndType(userId, type);
	}
}
