package com.company.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 关闭操作数据库时产生的资源流
 * @author God_86
 *
 */
public class DbClose {
	/**
	 * 关闭添加功能
	 * @param pstmt 表示预编译的SQL语句的对象。
	 * @param conn 与特定数据库的连接（会话）。
	 */
	public static void addClose(PreparedStatement pstmt, Connection conn) {
		/*
		 * 多个 try-catch 出发点：安全
		 */
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭资源
	 * @param pstmt 表示预编译的SQL语句的对象
	 * @param rs 表示数据库结果集的数据表，通常通过执行查询数据库的语句生成
	 * @param conn 与特定数据库的连接（会话）
	 */
	public static void queryClose(PreparedStatement pstmt,ResultSet rs,Connection conn) {

		
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
