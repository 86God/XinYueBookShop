package com.company.project.biz;
import com.company.project.model.po.UserPo;


//ҵ�����
public interface UserBiz {
	//ע��
	boolean reg(UserPo userPo);
	
	//��¼
	boolean login(long phoneNum,String password);
	
	//����
	boolean updatePassWord(UserPo userPo, String newPW);
	
	//�޸ĸ�����Ϣ
	int updatePersonalData (UserPo userPo);
	
	//��ȡ������Ϣ
	UserPo getPersonalData(long phoneNum);
	
	//ͨ��Id��ѯ
	UserPo findById(long id);
	
	
	
}
