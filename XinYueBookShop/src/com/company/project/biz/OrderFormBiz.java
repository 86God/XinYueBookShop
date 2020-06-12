package com.company.project.biz;

import java.util.ArrayList;

import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

import oracle.net.aso.s;

public interface OrderFormBiz {
	//�û���������Զ���������
	OrderFormPo create (BookPo bookPo, int num, UserPo userPo,UserPo consignee);
	
	//ȷ������
	boolean insert(OrderFormPo orderFormPo);
	
	//�޸Ķ���
	boolean update(OrderFormPo orderFormPo);
	
	//ɾ������
	boolean delete(long id);
	
	//��ѯ����
	OrderFormPo findById(long id);
	
	//��ѯ���ж���
	ArrayList<OrderFormPo> findAll();
	
	//��ҳ��ѯ����
	ArrayList<OrderFormPo> findByPage();
	
	//�����û�id��ѯ���˵����ж���
	ArrayList<OrderFormPo> findByUserId(long userId);
	
	//��ҳ�����û�id��ѯ���˵Ķ���
	ArrayList<OrderFormPo> findByUserIdPage();
	
	//�����û�id�Ͷ������Ͳ�ѯ����
	ArrayList<OrderFormPo> findByUserIdAndType(long userId,String type);
}