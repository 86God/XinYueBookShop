package com.company.project.dao;

import java.util.ArrayList;


import com.company.project.model.po.ShoppingCartPo;;


public interface ShoppingCartDao {
	// ����
	boolean insert(ShoppingCartPo shoppingCartPo);

	// ����
	boolean update(ShoppingCartPo shoppingCartPo);

	// ɾ��
	boolean delete(long id);

	// ��ѯ����
	ShoppingCartPo findById(long id);
	
	//��ѯ
	ShoppingCartPo findByIdDetailPage(long id);

	// ��ѯ���ж���
	ArrayList<ShoppingCartPo> findAll();

	// ��ҳ��ѯ����
	ArrayList<ShoppingCartPo> findByPage();

	// �����û�id��ѯ���˵����ж���
	ArrayList<ShoppingCartPo> findByUserId(long userId);
	
	//��ѯ�û����ﳵ���Ƿ���ڸ���Ʒ
	Long isHavaBook(ShoppingCartPo shoppingCartPo);

}
