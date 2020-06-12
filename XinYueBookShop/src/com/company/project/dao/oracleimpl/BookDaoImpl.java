package com.company.project.dao.oracleimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.project.dao.BookDao;
import com.company.project.model.po.BookPo;
import com.company.project.util.DBUtil;
import com.company.project.util.DbClose;

public class BookDaoImpl implements BookDao {
	/*
	 * PreparedStatement 表示预编译的SQL语句的对象。 ResultSet 表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
	 * Connection 与特定数据库的连接（会话）。
	 * 
	 */
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public boolean insert(BookPo bookPo) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "insert into books(name,type,author,price,book_img,introduction,publishing_house,repertory_number) values (?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookPo.getName());
			pstmt.setString(2, bookPo.getType());
			pstmt.setString(3, bookPo.getAuthor());
			pstmt.setFloat(4, bookPo.getPrice());
			pstmt.setString(5, bookPo.getBookImg());
			pstmt.setString(6, bookPo.getIntroduction());
			pstmt.setString(7, bookPo.getPublishingHouse());
			pstmt.setInt(8, bookPo.getRepertoryNumber());
			int rs = pstmt.executeUpdate();
			System.out.println("成功插入" + rs + "条记录");
			if (rs > 0) {
				flag = true;
			} else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}

		return flag;
	}

	@Override
	public boolean update(BookPo bookPo) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "update BOOKS set name=?,type=?,author=?,price=?,book_img=?,publishing_house=?,introduction=?,repertory_number=? where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookPo.getName());
			pstmt.setString(2, bookPo.getType());
			pstmt.setString(3, bookPo.getAuthor());
			pstmt.setFloat(4, bookPo.getPrice());
			pstmt.setString(5, bookPo.getBookImg());
			pstmt.setString(6, bookPo.getPublishingHouse());
			pstmt.setString(7, bookPo.getIntroduction());
			pstmt.setInt(8, bookPo.getRepertoryNumber());
			pstmt.setLong(9, bookPo.getId());
			int rs = pstmt.executeUpdate();
			System.out.println("成功更新" + rs + "条数据");
			if (rs > 0) {
				flag = true;
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
	public boolean delete(long id) {
		boolean flag = false;
		conn = DBUtil.getConnection();
		String sql = "delete books where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			int rs = pstmt.executeUpdate();
			System.out.println("成功删除" + rs + "条记录");
			if (rs > 0) {
				flag = true;
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.addClose(pstmt, conn);
		}
		return flag;
	}

	@Override
	public BookPo findById(long id) {
		BookPo bookPo = new BookPo();
		conn = DBUtil.getConnection();
		String sql = "select * from books where id = ?";
		int rsNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rsNum++;
				bookPo.setId(rs.getLong("id"));
				bookPo.setName(rs.getString("name"));
				bookPo.setType(rs.getString("type"));
				bookPo.setAuthor(rs.getString("author"));
				bookPo.setPrice(rs.getFloat("price"));
				bookPo.setBookImg(rs.getString("book_img"));
				bookPo.setIntroduction(rs.getString("introduction"));
				bookPo.setPublishingHouse(rs.getString("publishing_house"));
				bookPo.setRepertoryNumber(rs.getInt("repertory_number"));
			}
			System.out.println("查询到" + rsNum + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
			DbClose.queryClose(pstmt, rs, conn);
		}
		return bookPo;
	}

	@Override
	public ArrayList<BookPo> findAll() {
		ArrayList<BookPo> bookPolList = new ArrayList<>();
		conn = DBUtil.getConnection();
		String sql = "select * from books";
		int rsNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rsNum++;
				BookPo bookPo = new BookPo();
				bookPo.setId(rs.getLong("id"));
				bookPo.setName(rs.getString("name"));
				bookPo.setType(rs.getString("type"));
				bookPo.setAuthor(rs.getString("author"));
				bookPo.setPrice(rs.getFloat("price"));
				bookPo.setBookImg(rs.getString("book_img"));
				bookPo.setIntroduction(rs.getString("introduction"));
				bookPo.setPublishingHouse(rs.getString("publishing_house"));
				bookPo.setRepertoryNumber(rs.getInt("repertory_number"));
				bookPolList.add(bookPo);
			}
			System.out.println("查询到" + rsNum + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
			DbClose.queryClose(pstmt, rs, conn);
		}
		return bookPolList;
	}

	@Override
	public ArrayList<BookPo> findByType(String type) {

		ArrayList<BookPo> bookPolList = new ArrayList<>();
		conn = DBUtil.getConnection();
		String sql = "select * from books where type = ?";
		int rsNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rsNum++;
				BookPo bookPo = new BookPo();
				bookPo.setId(rs.getLong("id"));
				bookPo.setName(rs.getString("name"));
				bookPo.setType(rs.getString("type"));
				bookPo.setAuthor(rs.getString("author"));
				bookPo.setPrice(rs.getFloat("price"));
				bookPo.setBookImg(rs.getString("book_img"));
				bookPo.setIntroduction(rs.getString("introduction"));
				bookPo.setPublishingHouse(rs.getString("publishing_house"));
				bookPo.setRepertoryNumber(rs.getInt("repertory_number"));
				bookPolList.add(bookPo);
			}
			System.out.println("查询到" + rsNum + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
			DbClose.queryClose(pstmt, rs, conn);
		}
		return bookPolList;
	}

	@Override
	public ArrayList<BookPo> findByDim(String name) {
		ArrayList<BookPo> bookPolList = new ArrayList<>();
		conn = DBUtil.getConnection();
		String sql = "select * from books where name like ? or AUTHOR like ? or type like ?";
		int rsNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			pstmt.setString(2, "%"+name+"%");
			pstmt.setString(3, "%"+name+"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rsNum++;
				BookPo bookPo = new BookPo();
				bookPo.setId(rs.getLong("id"));
				bookPo.setName(rs.getString("name"));
				bookPo.setType(rs.getString("type"));
				bookPo.setAuthor(rs.getString("author"));
				bookPo.setPrice(rs.getFloat("price"));
				bookPo.setBookImg(rs.getString("book_img"));
				bookPo.setIntroduction(rs.getString("introduction"));
				bookPo.setPublishingHouse(rs.getString("publishing_house"));
				bookPo.setRepertoryNumber(rs.getInt("repertory_number"));
				bookPolList.add(bookPo);
			}
			System.out.println("查询到" + rsNum + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
			DbClose.queryClose(pstmt, rs, conn);
		}
		return bookPolList;
	}

	@Override
	public ArrayList<BookPo> findByPage(int pageNums, int pages) {
		ArrayList<BookPo> bookPolList = new ArrayList<>();
		conn = DBUtil.getConnection();
		String sql = "SELECT *  FROM   books\r\n" + 
				"WHERE id IN (\r\n" + 
				"  SELECT id  FROM (\r\n" + 
				"        SELECT ROWNUM  rn , id FROM books memp WHERE  ROWNUM  <=?)  nemp\r\n" + 
				"        WHERE  nemp.rn > ?\r\n" + 
				")";
		int rsNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNums*pages);
			pstmt.setInt(2, pageNums*(pages-1));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rsNum++;
				BookPo bookPo = new BookPo();
				bookPo.setId(rs.getLong("id"));
				bookPo.setName(rs.getString("name"));
				bookPo.setType(rs.getString("type"));
				bookPo.setAuthor(rs.getString("author"));
				bookPo.setPrice(rs.getFloat("price"));
				bookPo.setBookImg(rs.getString("book_img"));
				bookPo.setIntroduction(rs.getString("introduction"));
				bookPo.setPublishingHouse(rs.getString("publishing_house"));
				bookPo.setRepertoryNumber(rs.getInt("repertory_number"));
				bookPolList.add(bookPo);
			}
			System.out.println("查询到" + rsNum + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
			DbClose.queryClose(pstmt, rs, conn);
		}
		return bookPolList;
	}

}
