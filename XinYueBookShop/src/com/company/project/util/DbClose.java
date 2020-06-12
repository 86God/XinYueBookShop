package com.company.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �رղ������ݿ�ʱ��������Դ��
 * @author God_86
 *
 */
public class DbClose {
	/**
	 * �ر���ӹ���
	 * @param pstmt ��ʾԤ�����SQL���Ķ���
	 * @param conn ���ض����ݿ�����ӣ��Ự����
	 */
	public static void addClose(PreparedStatement pstmt, Connection conn) {
		/*
		 * ��� try-catch �����㣺��ȫ
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
	 * �ر���Դ
	 * @param pstmt ��ʾԤ�����SQL���Ķ���
	 * @param rs ��ʾ���ݿ����������ݱ�ͨ��ͨ��ִ�в�ѯ���ݿ���������
	 * @param conn ���ض����ݿ�����ӣ��Ự��
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
