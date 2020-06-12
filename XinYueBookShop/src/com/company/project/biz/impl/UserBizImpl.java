package com.company.project.biz.impl;

import com.company.project.biz.UserBiz;
import com.company.project.dao.LogDao;
import com.company.project.dao.UserDao;
import com.company.project.dao.oracleimpl.LogDaoImpl;
import com.company.project.dao.oracleimpl.UserDaoImpl;

import com.company.project.model.po.LogPo;
import com.company.project.model.po.UserPo;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;

	public UserBizImpl() {
		this.userDao = new UserDaoImpl();
	}

	@Override
	public boolean reg(UserPo userPo) {

		boolean flag = false;

		if (userDao.usedPhoneNum(userPo.getPhoneNum())!= 0) {
			System.out.println("这个手机号已经注册过了，请更换手机号");
		} else {
			// 向用户表插入一条记录
			flag = userDao.insert(userPo);
		}
		return flag;
	}

	@Override
	public boolean login(long phoneNum, String password) {
		boolean flag = false;

		if (userDao.usedPhoneNum(phoneNum)==0) {
			return false;
		} else {
			UserPo userPo = userDao.findByPhoneNum(phoneNum);
			if (userPo.getPassword().equals(password)) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public boolean updatePassWord(UserPo userPo, String newPW) {
		boolean flag = false;
		if(userDao.changePW(userPo, newPW)) {
			flag = true;
			System.out.println("更改密码成功");
		}else {
			System.out.println("更改密码失败");
		}
		return flag;
	}

	@Override
	public int updatePersonalData(UserPo userPo) {
		int flag = 0;
		
		if (userDao.usedPhoneNum(userPo.getPhoneNum())!=0 && userPo.getId() != userDao.usedPhoneNum(userPo.getPhoneNum())) {
			System.out.println("此手机号已经注册过了");
			flag = 1;
		}else if(userDao.usedUserName(userPo.getUserName())!=0 && userPo.getId() != userDao.usedUserName(userPo.getUserName())) {
			System.out.println("此用户名已经使用过了");
			flag = 2;
		}else {
			if(userDao.updatePersonalData(userPo)) {
				System.out.println("更改信息成功");
				flag = 0;
			}else {
				System.out.println("更新资料失败，请检测服务器是否正常");
				flag = 3;
			}
		}
		return flag;
	}

	@Override
	public UserPo getPersonalData(long phoneNum) {
		UserPo userPo = new UserPo();
		userPo = userDao.findByPhoneNum(phoneNum);
		return userPo;
	}

	@Override
	public UserPo findById(long id) {
		return userDao.findById(id);
	}

}
