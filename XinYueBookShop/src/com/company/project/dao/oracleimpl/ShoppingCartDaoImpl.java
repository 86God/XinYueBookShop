package com.company.project.dao.oracleimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.project.dao.ShoppingCartDao;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.ShoppingCartPo;
import com.company.project.util.DBUtil;
import com.company.project.util.DbClose;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
	/*
	 * PreparedStatement ��ʾԤ�����SQL���Ķ��� ResultSet ��ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ��������ɡ�
	 * Connection ���ض����ݿ�����ӣ��Ự����
	 * 
	 */
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean insert(ShoppingCartPo shoppingCartPo) {

		boolean flag = false;

		// ����û����ﳵ�Ƿ��Ѿ���������Ʒ����������ֱ��������1
		long isHavaBookId = isHavaBook(shoppingCartPo);
		if (isHavaBookId != 0l) {
			shoppingCartPo = findById(isHavaBookId);
			shoppingCartPo.setBookNum(shoppingCartPo.getBookNum() + 1);
			flag = update(shoppingCartPo);
		} else {
			conn = DBUtil.getConnection();
			String sql = "insert into SHOPPING_CART(user_id,book_id,book_num) values(?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, shoppingCartPo.getUserId());
				pstmt.setLong(2, shoppingCartPo.getBookId());
				pstmt.setInt(3, shoppingCartPo.getBookNum());
				int rs = pstmt.executeUpdate();
				System.out.println("�ɹ�����" + rs + "����¼");
				if (rs > 0) {
					flag = true;
				} else {
					System.out.println("����ʧ��");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean update(ShoppingCartPo shoppingCartPo) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "update SHOPPING_CART set user_id = ?,book_id = ?,book_num = ? where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, shoppingCartPo.getUserId());
			pstmt.setLong(2, shoppingCartPo.getBookId());
			pstmt.setInt(3, shoppingCartPo.getBookNum());
			pstmt.setLong(4, shoppingCartPo.getId());

			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				flag = true;
				System.out.println("���³ɹ�" + rs + "��");
			} else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}

		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "delete shopping_cart where ID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				flag = true;
				System.out.println("�ɹ�ɾ��" + rs + "��");
			} else {
				System.out.println("ɾ��ʧ��");
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
	public ShoppingCartPo findById(long id) {
		String sql = "select * from SHOPPING_CART where id = ?";
		conn = DBUtil.getConnection();
		ShoppingCartPo shoppingCart = new ShoppingCartPo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoppingCart.setId(rs.getLong("id"));
				shoppingCart.setUserId(rs.getLong("user_id"));
				shoppingCart.setBookId(rs.getLong("book_id"));
				shoppingCart.setBookNum(rs.getInt("book_num"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return shoppingCart;
	}

	@Override
	public ShoppingCartPo findByIdDetailPage(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ShoppingCartPo> findAll() {
		String sql = "select * from shopping_cart";
		conn = DBUtil.getConnection();
		ArrayList<ShoppingCartPo> shoppingCartList = new ArrayList<ShoppingCartPo>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShoppingCartPo shoppingCart = new ShoppingCartPo();
				shoppingCart.setId(rs.getLong("id"));
				shoppingCart.setUserId(rs.getLong("user_id"));
				shoppingCart.setBookId(rs.getLong("book_id"));
				shoppingCart.setBookNum(rs.getInt("book_num"));
				shoppingCartList.add(shoppingCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return shoppingCartList;
	}

	@Override
	public ArrayList<ShoppingCartPo> findByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ShoppingCartPo> findByUserId(long userId) {
		String sql = "select * from SHOPPING_CART where user_id = ? order by id DESC";
		conn = DBUtil.getConnection();
		ArrayList<ShoppingCartPo> shoppingCartList = new ArrayList<ShoppingCartPo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShoppingCartPo shoppingCart = new ShoppingCartPo();
				shoppingCart.setId(rs.getLong("id"));
				shoppingCart.setUserId(rs.getLong("user_id"));
				shoppingCart.setBookId(rs.getLong("book_id"));
				shoppingCart.setBookNum(rs.getInt("book_num"));
				shoppingCartList.add(shoppingCart);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return shoppingCartList;
	}

	@Override
	public Long isHavaBook(ShoppingCartPo shoppingCartPo) {
		long flag = 0l;
		conn = DBUtil.getConnection();
		String sql = "select * from SHOPPING_CART where user_id = ? and BOOK_ID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, shoppingCartPo.getUserId());
			pstmt.setLong(2, shoppingCartPo.getBookId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = rs.getLong("id");
				System.out.println("���û����ﳵ�а�������Ʒ");
			} else {
				System.out.println("���û����ﳵ��û�и���Ʒ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return flag;
	}

}
