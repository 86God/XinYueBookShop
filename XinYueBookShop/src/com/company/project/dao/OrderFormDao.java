package com.company.project.dao;

import java.awt.List;
import java.util.ArrayList;

import com.company.project.model.po.OrderFormDetailPage;
import com.company.project.model.po.OrderFormPo;

public interface OrderFormDao {
	// ����
	boolean insert(OrderFormPo orderForm);

	// ����
	boolean update(OrderFormPo orderForm);

	// ɾ��
	boolean delete(long id);

	// ��ѯ����
	OrderFormPo findById(long id);
	
	//��ѯ
//	OrderFormDetailPage findByIdDetailPage(long id);

	// ��ѯ���ж���
	ArrayList<OrderFormPo> findAll();

	// ��ҳ��ѯ����
	ArrayList<OrderFormPo> findByPage();

	// �����û�id��ѯ���˵����ж���
	ArrayList<OrderFormPo> findByUserId(long userId);
	
	// �����û�id �� �������Ͳ�ѯ���˵����ж���
    ArrayList<OrderFormPo> findByUserIdAndType(long userId,String type);

}
