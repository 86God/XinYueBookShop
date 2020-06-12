package com.company.project.BizTest;

import java.util.ArrayList;

import com.company.project.biz.impl.OrderFormBizImpl;
import com.company.project.dao.oracleimpl.OrderFormDaoimpl;
import com.company.project.model.po.BookPo;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;

import junit.framework.TestCase;

public class OrderFormBizImplTest extends TestCase {
	public OrderFormPo testCreate() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		BookPo bookPo = new BookPo();
		bookPo.setId(1000111);
		bookPo.setName("情商高就是会说话");
		bookPo.setPrice((float) 198.50);
		
		UserPo userPo = new UserPo();
		userPo.setId(1000002);
		
		UserPo consignee = new UserPo();
		consignee.setName("张三");
		consignee.setPhoneNum(12345678910l);
		consignee.setShippingAddress("陕西省渭南市蒲城县");
		
		OrderFormPo orderFormPo = new OrderFormPo();
		orderFormPo = orderFormBizImpl.create(bookPo, 10, userPo,consignee);
		System.out.println(orderFormPo);
		return orderFormPo;
	}
	
	public void testInsert() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		orderFormBizImpl.insert(testCreate());
	}
	
	public void testUpdate() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		OrderFormPo orderForm = new OrderFormPo();
		orderForm.setId(1000004);
		orderForm.setBookId(1000011);
		orderForm.setUserId(1000001);
		orderForm.setBookNum(20);
		orderForm.setMoney(100000);
		orderForm.setShippingAddress("陕西省渭南市蒲城县");
		orderForm.setShippingPersonName("张耿英");
		orderForm.setShippingPhoneNum(15592237827l);
		orderForm.setType("待发货");
		orderFormBizImpl.update(orderForm);
	}
	
	public void testDelete() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		orderFormBizImpl.delete(1000004l);
	}
	
	public void testFindById() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		OrderFormPo orderFormPo = new OrderFormPo();
		orderFormPo = orderFormBizImpl.findById(1000001l);
		System.out.println(orderFormPo);
	}
	
	public void testFindAll() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		orderFormList = orderFormBizImpl.findAll();
		for (OrderFormPo orderFormPo : orderFormList) {
			System.out.println(orderFormPo);
		}
	}
	
	public void testFindByUserId() {
		OrderFormBizImpl orderFormBizImpl = new OrderFormBizImpl();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		orderFormList = orderFormBizImpl.findByUserId(1000011l);
		for (OrderFormPo orderFormPo : orderFormList) {
			System.out.println(orderFormPo);
		}
	}
}
