package com.company.project.daoOracleImpl;

import java.util.ArrayList;

import com.company.project.dao.oracleimpl.OrderFormDaoimpl;
import com.company.project.model.po.OrderFormDetailPage;
import com.company.project.model.po.OrderFormPo;

import junit.framework.TestCase;

public class OrderFormDaoImplTest extends TestCase {

	public void testInsert() {
		OrderFormPo orderForm = new OrderFormPo();
		orderForm.setUserId(1000001);
		orderForm.setBookId(1000112);
		orderForm.setBookNum(10);
		orderForm.setMoney(1000);
		orderForm.setShippingAddress("陕西省渭南市蒲城县");
		orderForm.setShippingPersonName("张耿英");
		orderForm.setShippingPhoneNum(15592237827l);
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		orderFormDaoimpl.insert(orderForm);
		
	}
	
	public void testUpdate() {
		OrderFormPo orderForm = new OrderFormPo();
		orderForm.setId(1000001);
		orderForm.setBookId(1000011);
		orderForm.setUserId(1000001);
		orderForm.setBookNum(20);
		orderForm.setMoney(100000);
		orderForm.setShippingAddress("陕西省渭南市蒲城县");
		orderForm.setShippingPersonName("张耿英");
		orderForm.setShippingPhoneNum(15592237827l);
		orderForm.setType("待发货");
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		orderFormDaoimpl.update(orderForm);
		
	}
	
	public void testDelete() {
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		orderFormDaoimpl.delete(1000003l);
		
	}
	
	
	public void testFindById() {
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		OrderFormPo orderForm = new OrderFormPo();
		orderForm = orderFormDaoimpl.findById(1000001l);
		System.out.println(orderForm);
	}
	
	public void testFindAll() {
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		orderFormList = orderFormDaoimpl.findAll();
		for (OrderFormPo orderFormPo : orderFormList) {
			System.out.println(orderFormPo);
		}
	}
	
	public void testFindByUserId() {
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		orderFormList = orderFormDaoimpl.findByUserId(1000001L);
		for (OrderFormPo orderFormPo : orderFormList) {
			System.out.println(orderFormPo);
		}
	}

	public void testFindByUserIdAndType() {
		OrderFormDaoimpl orderFormDaoimpl = new OrderFormDaoimpl();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		orderFormList = orderFormDaoimpl.findByUserIdAndType(1000011L,"待付款");
		for (OrderFormPo orderFormPo : orderFormList) {
			System.out.println(orderFormPo);
		}
	}
	
}
