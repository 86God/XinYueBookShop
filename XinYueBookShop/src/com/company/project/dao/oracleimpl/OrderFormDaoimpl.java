package com.company.project.dao.oracleimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.project.dao.OrderFormDao;
import com.company.project.model.po.OrderFormDetailPage;
import com.company.project.model.po.OrderFormPo;
import com.company.project.util.DBUtil;
import com.company.project.util.DbClose;


public class OrderFormDaoimpl implements OrderFormDao {
	/*
	 * PreparedStatement 表示预编译的SQL语句的对象。
	 * ResultSet 表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
	 * Connection 与特定数据库的连接（会话）。
	 * 
	 */
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	@Override
	public boolean insert(OrderFormPo orderForm) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "insert into order_form(user_id,book_id,book_num,money,shipping_Address,create_date,shipping_PhoneNum,shipping_personName,type) values (?,?,?,?,?,trunc(sysdate),?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderForm.getUserId());
			pstmt.setLong(2, orderForm.getBookId());
			pstmt.setInt(3, orderForm.getBookNum());
			pstmt.setFloat(4, orderForm.getMoney());
			pstmt.setString(5, orderForm.getShippingAddress());
			pstmt.setLong(6, orderForm.getShippingPhoneNum());
			pstmt.setString(7, orderForm.getShippingPersonName());
			pstmt.setString(8, orderForm.getType());
			int rs = pstmt.executeUpdate();
			System.out.println("成功插入" + rs + "条记录");
			if(rs > 0) {
				flag = true;
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(OrderFormPo orderForm) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "update order_form set user_id = ?,book_id=?,book_num =?,money=?,shipping_Address=?,shipping_PhoneNum=?,shipping_personName=?,type=? where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, orderForm.getUserId());
			pstmt.setLong(2, orderForm.getBookId());
			pstmt.setInt(3, orderForm.getBookNum());
			pstmt.setFloat(4, orderForm.getMoney());
			pstmt.setString(5, orderForm.getShippingAddress());
			pstmt.setLong(6, orderForm.getShippingPhoneNum());
			pstmt.setString(7, orderForm.getShippingPersonName());
			pstmt.setString(8, orderForm.getType());
			pstmt.setLong(9, orderForm.getId());
			int rs = pstmt.executeUpdate();
			
			if(rs > 0) {
				flag = true;
				System.out.println("更新成功" + rs + "条");
			}else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			DbClose.addClose(pstmt, conn);
		}
		
		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "delete ORDER_FORM where ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			int rs = pstmt.executeUpdate();
			if(rs > 0) {
				flag =true;
				System.out.println("成功删除" + rs + "条");
			}else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}
		
		return flag;
	}

	@Override
	public OrderFormPo findById(long id) {
		String sql = "select * from order_form where id = ?";
		conn = DBUtil.getConnection();
		OrderFormPo orderForm = new OrderFormPo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderForm.setId(rs.getLong("id"));
				orderForm.setUserId(rs.getLong("user_id"));
				orderForm.setBookId(rs.getLong("book_id"));
				orderForm.setBookNum(rs.getInt("book_num"));
				orderForm.setMoney(rs.getFloat("money"));
				orderForm.setCreateDate(rs.getDate("create_date"));
				orderForm.setShippingAddress(rs.getString("shipping_address"));
				orderForm.setShippingPersonName(rs.getString("shipping_personName"));
				orderForm.setShippingPhoneNum(rs.getLong("shipping_PhoneNum"));
				orderForm.setType(rs.getString("type"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return orderForm;
	}
	


	@Override
	public ArrayList<OrderFormPo> findAll() {
		String sql = "select * from order_form";
		conn = DBUtil.getConnection();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderFormPo orderForm = new OrderFormPo();
				orderForm.setId(rs.getLong("id"));
				orderForm.setUserId(rs.getLong("user_id"));
				orderForm.setBookId(rs.getLong("book_id"));
				orderForm.setBookNum(rs.getInt("book_num"));
				orderForm.setMoney(rs.getFloat("money"));
				orderForm.setCreateDate(rs.getDate("create_date"));
				orderForm.setShippingAddress(rs.getString("shipping_address"));
				orderForm.setShippingPersonName(rs.getString("shipping_personName"));
				orderForm.setShippingPhoneNum(rs.getLong("shipping_PhoneNum"));
				orderForm.setType(rs.getString("type"));
				orderFormList.add(orderForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return orderFormList;
	}

	@Override
	public ArrayList<OrderFormPo> findByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderFormPo> findByUserId(long userId) {
		String sql = "select * from order_form where user_id = ? order by id DESC";
		conn = DBUtil.getConnection();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderFormPo orderForm = new OrderFormPo();
				orderForm.setId(rs.getLong("id"));
				orderForm.setUserId(rs.getLong("user_id"));
				orderForm.setBookId(rs.getLong("book_id"));
				orderForm.setBookNum(rs.getInt("book_num"));
				orderForm.setMoney(rs.getFloat("money"));
				orderForm.setCreateDate(rs.getDate("create_date"));
				orderForm.setShippingAddress(rs.getString("shipping_address"));
				orderForm.setShippingPersonName(rs.getString("shipping_personName"));
				orderForm.setShippingPhoneNum(rs.getLong("shipping_PhoneNum"));
				orderForm.setType(rs.getString("type"));
				orderFormList.add(orderForm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return orderFormList;
	}

	@Override
	public ArrayList<OrderFormPo> findByUserIdAndType(long userId, String type) {
		String sql = "select * from order_form where user_id = ? and type = ? order by id DESC";
		conn = DBUtil.getConnection();
		ArrayList<OrderFormPo> orderFormList = new ArrayList<OrderFormPo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderFormPo orderForm = new OrderFormPo();
				orderForm.setId(rs.getLong("id"));
				orderForm.setUserId(rs.getLong("user_id"));
				orderForm.setBookId(rs.getLong("book_id"));
				orderForm.setBookNum(rs.getInt("book_num"));
				orderForm.setMoney(rs.getFloat("money"));
				orderForm.setCreateDate(rs.getDate("create_date"));
				orderForm.setShippingAddress(rs.getString("shipping_address"));
				orderForm.setShippingPersonName(rs.getString("shipping_personName"));
				orderForm.setShippingPhoneNum(rs.getLong("shipping_PhoneNum"));
				orderForm.setType(rs.getString("type"));
				orderFormList.add(orderForm);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return orderFormList;
	}


}
