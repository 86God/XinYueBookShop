package com.company.project.daoOracleImpl;

import java.util.ArrayList;

import com.company.project.dao.oracleimpl.OrderFormDaoimpl;
import com.company.project.dao.oracleimpl.ShoppingCartDaoImpl;
import com.company.project.model.po.OrderFormDetailPage;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;

import junit.framework.TestCase;

public class ShoppingCartImplTest extends TestCase{
	public void testInsert() {
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		shoppingCart.setBookId(1000112);
		shoppingCart.setUserId(1000001);

		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		shoppingCartImpl.insert(shoppingCart);
		
	}
	
	public void testUpdate() {
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		shoppingCart.setId(1000010l);
		shoppingCart.setBookId(1000113l);
		shoppingCart.setUserId(1000004l);
		shoppingCart.setBookNum(8);

		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		shoppingCartImpl.update(shoppingCart);
		
	}
	
	public void testDelete() {
		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		shoppingCartImpl.delete(1000009l);
		
	}
	
	public void testFindById() {
		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		shoppingCart = shoppingCartImpl.findById(1000001l);
		System.out.println(shoppingCart);
	}
	
	public void testFindAll() {
		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		ArrayList<ShoppingCartPo> shoppingCartList = new ArrayList<ShoppingCartPo>();
		shoppingCartList = shoppingCartImpl.findAll();
		for (ShoppingCartPo shoppingCartPo : shoppingCartList) {
			System.out.println(shoppingCartPo);
		}
	}
	
	public void testFindByUserId() {
		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		ArrayList<ShoppingCartPo> shoppingCartList = new ArrayList<ShoppingCartPo>();
		shoppingCartList = shoppingCartImpl.findByUserId(1000001L);
		for (ShoppingCartPo shoppingCartPo : shoppingCartList) {
			System.out.println(shoppingCartPo);
		}
	}

	public void testIsHavaBook() {
		ShoppingCartDaoImpl shoppingCartImpl = new ShoppingCartDaoImpl();
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		shoppingCart.setUserId(1000001l);
		shoppingCart.setBookId(1000121l);
		shoppingCartImpl.isHavaBook(shoppingCart);
	}
	
}
