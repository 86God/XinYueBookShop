package com.company.project.dao;

import java.util.ArrayList;

import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

public interface UserDao {
	//插入
	boolean insert(UserPo userPo);
	
	//更新个人资料
	boolean updatePersonalData(UserPo userPo);
	
	//找回密码
	boolean findBackPW(UserPo userPo,String newPW);
	
	//更改密码
	boolean changePW(UserPo userPo,String newPW);
	
	//删除
	boolean delete(long id);
	
	//查询主键
	UserPo findById(long id);
	
	//通过手机号查询
	UserPo findByPhoneNum(long phoneNum);
	
	//查询所有
	ArrayList<UserPo> findAll();
	
	//查询手机号是否已经使用过
	long usedPhoneNum(long phoneNum);
	
	//查询用户名是否已经使用过
	long usedUserName(String userName);

}
