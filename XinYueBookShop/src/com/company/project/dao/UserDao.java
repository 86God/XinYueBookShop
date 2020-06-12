package com.company.project.dao;

import java.util.ArrayList;

import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

public interface UserDao {
	//����
	boolean insert(UserPo userPo);
	
	//���¸�������
	boolean updatePersonalData(UserPo userPo);
	
	//�һ�����
	boolean findBackPW(UserPo userPo,String newPW);
	
	//��������
	boolean changePW(UserPo userPo,String newPW);
	
	//ɾ��
	boolean delete(long id);
	
	//��ѯ����
	UserPo findById(long id);
	
	//ͨ���ֻ��Ų�ѯ
	UserPo findByPhoneNum(long phoneNum);
	
	//��ѯ����
	ArrayList<UserPo> findAll();
	
	//��ѯ�ֻ����Ƿ��Ѿ�ʹ�ù�
	long usedPhoneNum(long phoneNum);
	
	//��ѯ�û����Ƿ��Ѿ�ʹ�ù�
	long usedUserName(String userName);

}
