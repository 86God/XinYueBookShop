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
			System.out.println("����ֻ����Ѿ�ע����ˣ�������ֻ���");
		} else {
			// ���û������һ����¼
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
			System.out.println("��������ɹ�");
		}else {
			System.out.println("��������ʧ��");
		}
		return flag;
	}

	@Override
	public int updatePersonalData(UserPo userPo) {
		int flag = 0;
		
		if (userDao.usedPhoneNum(userPo.getPhoneNum())!=0 && userPo.getId() != userDao.usedPhoneNum(userPo.getPhoneNum())) {
			System.out.println("���ֻ����Ѿ�ע�����");
			flag = 1;
		}else if(userDao.usedUserName(userPo.getUserName())!=0 && userPo.getId() != userDao.usedUserName(userPo.getUserName())) {
			System.out.println("���û����Ѿ�ʹ�ù���");
			flag = 2;
		}else {
			if(userDao.updatePersonalData(userPo)) {
				System.out.println("������Ϣ�ɹ�");
				flag = 0;
			}else {
				System.out.println("��������ʧ�ܣ�����������Ƿ�����");
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
