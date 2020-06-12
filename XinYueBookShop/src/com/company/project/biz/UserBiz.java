package com.company.project.biz;
import com.company.project.model.po.UserPo;


//业务规则
public interface UserBiz {
	//注册
	boolean reg(UserPo userPo);
	
	//登录
	boolean login(long phoneNum,String password);
	
	//改密
	boolean updatePassWord(UserPo userPo, String newPW);
	
	//修改个人信息
	int updatePersonalData (UserPo userPo);
	
	//获取个人信息
	UserPo getPersonalData(long phoneNum);
	
	//通过Id查询
	UserPo findById(long id);
	
	
	
}
