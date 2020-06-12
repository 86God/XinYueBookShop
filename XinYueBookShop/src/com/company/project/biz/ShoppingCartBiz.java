package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;
import com.company.project.model.po.UserPo;

public interface ShoppingCartBiz {
	//用户添加商品到购物车
	boolean insertGoodsToCart(ShoppingCartPo shoppingCartPo);
	
	//用户查看自己的购物车
	ArrayList<ShoppingCartPo> lookOwnShoppingCart(long userId);
	
	//用户删除自己购物车的商品
	boolean deleteGoods(long id);
	
	//用户在购物车点击购买
	OrderFormPo buy(long id);	
	
	//修改购物车商品的数量
	boolean updateGoods(ShoppingCartPo shoppingCartPo);
	
	
	
}
