package com.company.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// ���������ݿ����Ӷ��󡱣�����ģʽ
	private static Connection conn;

	// ��������ȡ�����ݿ����Ӷ��󡱣�����ģʽ��
	public static Connection getConnection() {
		// �жϡ����ݿ����Ӷ����Ƿ����
		try {
			// �ж����������Ӷ���Ϊ�� ���� ���Ӷ����ǹرյ�
			if (conn != null && !conn.isClosed()) {
				return conn;
				// ���سɹ��󣬺���Ĵ��뽫���ᱻִ�С�
			}

			// ���ء������ࡱ SPI
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ������URL�����ַ���������ʽ��jdbc:oracle:thin:@ ������/IP : �˿ں� ����������
			String url = "jdbc:oracle:thin:@localhost:1521:XE";

			// �������û�����
			String username = "bookmall";
			// ���������롱
			String password = "123456";

			// ��ʼ�������ݿ����Ӷ���
			conn = DriverManager.getConnection(url, username, password);
			if (conn != null) {
				System.out.println("[������ʾ]��ϲ�������ݿ����ӳɹ���");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
