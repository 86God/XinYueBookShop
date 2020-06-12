package com.company.project.biz.impl;

import java.util.ArrayList;

import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.UserBiz;
import com.company.project.dao.BookDao;
import com.company.project.dao.ShoppingCartDao;
import com.company.project.dao.UserDao;
import com.company.project.dao.oracleimpl.BookDaoImpl;
import com.company.project.dao.oracleimpl.ShoppingCartDaoImpl;
import com.company.project.dao.oracleimpl.UserDaoImpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;
import com.company.project.model.po.UserPo;

public class ShoppingCartBizImpl implements ShoppingCartBiz {
	ShoppingCartDao shoppingCartDaoImpl;
	BookDao bookDaoImpl; 
	UserDao userDaoImpl;
	
	public ShoppingCartBizImpl(){
		shoppingCartDaoImpl = new ShoppingCartDaoImpl(); 
		bookDaoImpl = new BookDaoImpl();
		userDaoImpl = new UserDaoImpl();
	}
	
	
	@Override
	public boolean insertGoodsToCart(ShoppingCartPo shoppingCartPo) {
		return shoppingCartDaoImpl.insert(shoppingCartPo);
	}

	@Override
	public ArrayList<ShoppingCartPo> lookOwnShoppingCart(long userId) { 
		return shoppingCartDaoImpl.findByUserId(userId);
	}

	@Override
	public boolean deleteGoods(long id) {
		return shoppingCartDaoImpl.delete(id);
	}


	@Override
	public OrderFormPo buy(long id) {
		ShoppingCartPo shoppingCartPo = shoppingCartDaoImpl.findById(id);
		BookPo bookPo = bookDaoImpl.findById(shoppingCartPo.getBookId());
		UserPo userPo = userDaoImpl.findById(shoppingCartPo.getUserId());
		OrderFormPo orderFormPo = new OrderFormPo();
		orderFormPo.setUserId(shoppingCartPo.getUserId());
		orderFormPo.setBookId(shoppingCartPo.getBookId());
		orderFormPo.setBookNum(shoppingCartPo.getBookNum());
		orderFormPo.setMoney(shoppingCartPo.getBookNum()*bookPo.getPrice());
		orderFormPo.setShippingAddress(userPo.getShippingAddress());
		return orderFormPo;	
	}

	@Override
	public boolean updateGoods(ShoppingCartPo shoppingCartPo) {
		return shoppingCartDaoImpl.update(shoppingCartPo);
	}

}
