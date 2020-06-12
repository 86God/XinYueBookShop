package com.company.project.BizTest;

import java.util.ArrayList;

import com.company.project.biz.ShoppingCartBiz;
import com.company.project.biz.impl.ShoppingCartBizImpl;
import com.company.project.dao.oracleimpl.ShoppingCartDaoImpl;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;

import junit.framework.TestCase;

public class ShoppingCartBizImplTest extends TestCase {
	ShoppingCartBiz shoppingCartBiz = new ShoppingCartBizImpl(); 
	
	public void testInsert() {
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		shoppingCart.setBookId(1000112);
		shoppingCart.setUserId(1000001);
		shoppingCartBiz.insertGoodsToCart(shoppingCart);
	}
	
	public void testLookOwnShoppingCart() {
		ArrayList<ShoppingCartPo> shoppingCartList = new ArrayList<ShoppingCartPo>();
		shoppingCartList = shoppingCartBiz.lookOwnShoppingCart(1000001L);
		for (ShoppingCartPo shoppingCartPo : shoppingCartList) {
			System.out.println(shoppingCartPo);
		}
	}
	
	public void testDeleteGoods() {
		shoppingCartBiz.deleteGoods(1000020l);
	}
	
	public void testBuy() {
		OrderFormPo orderFormPo = null;
		orderFormPo = shoppingCartBiz.buy(1000013l);
		System.out.println(orderFormPo);
	}
	
	public void testUpdateGoods() {
		ShoppingCartPo shoppingCartPo = new ShoppingCartPo();
		shoppingCartPo.setId(1000013l);
		shoppingCartPo.setBookId(1000012l);
		shoppingCartPo.setUserId(1000002l);
		shoppingCartPo.setBookNum(8);

		shoppingCartBiz.updateGoods(shoppingCartPo);
	}

}
