package com.company.project.daoOracleImpl;

import java.util.ArrayList;

import com.company.project.dao.oracleimpl.UserDaoImpl;
import com.company.project.model.po.UserPo;

import junit.framework.TestCase;

public class USERDaoImplTest extends TestCase {
	public void testInsert() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserPo userPo = new UserPo();
		userPo.setPhoneNum(15592237837l);
		userPo.setPassword("123456");
		userDaoImpl.insert(userPo);
	}

	public void testUpdate() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserPo userPo = new UserPo();
		userPo.setId(1000001l);
		userPo.setUserName("86_god");
		userPo.setPhoneNum(12345678910l);
		userPo.setName("张三");
		userPo.setSex("女");
		userPo.setShippingAddress("陕西理工大学");
		userDaoImpl.updatePersonalData(userPo);
	}
	
	public void testDelete() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		long id = 1000003l;
		userDaoImpl.delete(id);
	}
	
	public void testFindById() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		long id = 1000001l;
		UserPo userPo = userDaoImpl.findById(id);
		System.out.println(userPo);
	}
	
	public void testFindAll() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		ArrayList<UserPo> userPoList = new ArrayList<>();
		userPoList = userDaoImpl.findAll();
		for (UserPo userPo : userPoList) {
			System.out.println(userPo);
		}
	}
	
	public void testFindByPhoneNum() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		long phoneNum = 12345678910l;
		UserPo userPo = userDaoImpl.findByPhoneNum(phoneNum);
		System.out.println(userPo);
	}
	
	public void testUpdatePassWord() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		UserPo userPo = new UserPo();
		userPo.setPhoneNum(12345678910l);
		userPo.setPassword("896222");
		userDaoImpl.changePW(userPo,"123456");
	}
	
	public void testUsedPhoneNum() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		System.out.println(userDaoImpl.usedPhoneNum(12345678910l));
	}
	
	public void testUsedUserName() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		System.out.println(userDaoImpl.usedUserName("86_god"));
	}
	
}
