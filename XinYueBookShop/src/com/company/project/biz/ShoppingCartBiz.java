package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;
import com.company.project.model.po.UserPo;

public interface ShoppingCartBiz {
	//�û������Ʒ�����ﳵ
	boolean insertGoodsToCart(ShoppingCartPo shoppingCartPo);
	
	//�û��鿴�Լ��Ĺ��ﳵ
	ArrayList<ShoppingCartPo> lookOwnShoppingCart(long userId);
	
	//�û�ɾ���Լ����ﳵ����Ʒ
	boolean deleteGoods(long id);
	
	//�û��ڹ��ﳵ�������
	OrderFormPo buy(long id);	
	
	//�޸Ĺ��ﳵ��Ʒ������
	boolean updateGoods(ShoppingCartPo shoppingCartPo);
	
	
	
}
