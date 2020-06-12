package com.company.project.BizTest;

import com.company.project.biz.impl.UserBizImpl;
import com.company.project.model.po.UserPo;

import junit.framework.TestCase;

public class UserBizImplTest extends TestCase {
	public void testReg() {
		UserBizImpl userBizImpl = new UserBizImpl();
		UserPo userPo = new UserPo();
		userPo.setPhoneNum(15592237837l);
		userPo.setPassword("123456");
		userBizImpl.reg(userPo);
	}
}
