package com.company.project.dao.oracleimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.company.project.dao.UserDao;
import com.company.project.model.po.OrderFormPo;
import com.company.project.model.po.UserPo;
import com.company.project.util.DBUtil;
import com.company.project.util.DbClose;

public class UserDaoImpl implements UserDao {
	// 拿到数据库连接
	private Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	@Override
	public boolean insert(UserPo userPo) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "insert into \"USER\" (phone_num,password) values (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userPo.getPhoneNum());
			pstmt.setString(2, userPo.getPassword());

			int rs = pstmt.executeUpdate();
			System.out.println("成功插入" + rs + "条");
			if (rs > 0) {
				flag = true;
			} else {
				System.out.println("插入失败");
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
	public boolean updatePersonalData(UserPo userPo) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "update \"USER\" set user_name = ?,phone_num = ?,name = ?,sex = ?,shipping_address = ? where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPo.getUserName());
			pstmt.setLong(2, userPo.getPhoneNum());
			pstmt.setString(3, userPo.getName());
			pstmt.setString(4, userPo.getSex());
			pstmt.setString(5, userPo.getShippingAddress());
			pstmt.setLong(6, userPo.getId());

			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				flag = true;
				System.out.println("更新成功" + rs + "条");
			} else {
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}
		return flag;
	}
	
	
	@Override
	public boolean changePW(UserPo userPo, String newPW) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		// 获取用户的旧密码进行验证
		UserPo oldUserPo = findById(userPo.getId());
		
		if (userPo.getPassword().equals(oldUserPo.getPassword())) {
			conn = DBUtil.getConnection();
			String sql = "update \"USER\" set password = ? where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPW);
				pstmt.setLong(2, userPo.getId());

				int rs = pstmt.executeUpdate();

				if (rs > 0) {
					flag = true;
					System.out.println("更新成功" + rs + "条");
				} else {
					System.out.println("更新失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbClose.addClose(pstmt, conn);
			}
		}else {
			System.out.println("原密码错误，修改失败");
		}
		return flag;
	}

	@Override
	public boolean findBackPW(UserPo userPo, String newPW) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		// 获取用户的旧密码进行验证
		UserPo oldUserPo = findByPhoneNum(userPo.getPhoneNum());
		userPo.setId(oldUserPo.getId());
		if (userPo.getPassword().equals(oldUserPo.getPassword())) {
			conn = DBUtil.getConnection();
			String sql = "update \"USER\" set password = ? where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newPW);
				pstmt.setLong(2, userPo.getId());

				int rs = pstmt.executeUpdate();

				if (rs > 0) {
					flag = true;
					System.out.println("更新成功" + rs + "条");
				} else {
					System.out.println("更新失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbClose.addClose(pstmt, conn);
			}
		}else {
			System.out.println("原密码错误，修改失败");
		}
		return flag;
	}

	@Override
	public boolean delete(long id) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "delete \"USER\" where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				flag = true;
				System.out.println("成功删除" + rs + "条");
			} else {
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
	public UserPo findById(long id) {
		String sql = "select * from \"USER\" where id = ?";
		conn = DBUtil.getConnection();
		UserPo userPo = new UserPo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userPo.setId(rs.getLong("id"));
				userPo.setUserName(rs.getString("user_name"));
				userPo.setPhoneNum(rs.getLong("phone_num"));
				userPo.setPassword(rs.getString("password"));
				userPo.setName(rs.getString("name"));
				userPo.setSex(rs.getString("sex"));
				userPo.setShippingAddress(rs.getString("shipping_address"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return userPo;
	}

	@Override
	public UserPo findByPhoneNum(long phoneNum) {
		String sql = "select * from \"USER\" where phone_num = ?";
		conn = DBUtil.getConnection();
		UserPo userPo = new UserPo();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, phoneNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userPo.setId(rs.getLong("id"));
				userPo.setUserName(rs.getString("user_name"));
				userPo.setPhoneNum(rs.getLong("phone_num"));
				userPo.setPassword(rs.getString("password"));
				userPo.setName(rs.getString("name"));
				userPo.setSex(rs.getString("sex"));
				userPo.setShippingAddress(rs.getString("shipping_address"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return userPo;
	}

	@Override
	public long usedPhoneNum(long phoneNum) {
		boolean flag = false;
		String sql = "select * from \"USER\" where phone_num = ?";
		conn = DBUtil.getConnection();
		UserPo userPo = new UserPo();
		long id = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, phoneNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getLong("id");
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return id;
	}
	
	@Override
	public ArrayList<UserPo> findAll() {
		String sql = "select * from \"USER\"";
		conn = DBUtil.getConnection();
		ArrayList<UserPo> userPoList = new ArrayList<UserPo>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserPo userPo = new UserPo();
				userPo.setId(rs.getLong("id"));
				userPo.setUserName(rs.getString("user_name"));
				userPo.setPhoneNum(rs.getLong("phone_num"));
				userPo.setPassword(rs.getString("password"));
				userPo.setName(rs.getString("name"));
				userPo.setSex(rs.getString("sex"));
				userPo.setShippingAddress(rs.getString("shipping_address"));
				userPoList.add(userPo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return userPoList;
	}
	
	@Override
	public long usedUserName(String userName) {
		boolean flag = false;
		String sql = "select * from \"USER\" where user_name = ?";
		conn = DBUtil.getConnection();
		UserPo userPo = new UserPo();
		long id = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getLong("id");
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.queryClose(pstmt, rs, conn);
		}
		return id;
	}

	public Connection getConn() {
		return conn;
	}

	public PreparedStatement getPstmt() {
		return pstmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}
