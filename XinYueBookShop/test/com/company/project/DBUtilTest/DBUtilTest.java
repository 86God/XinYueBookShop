package com.company.project.DBUtilTest;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.company.project.util.DBUtil;

import junit.framework.TestCase;

public class DBUtilTest extends TestCase {
	public void testGetConnection() {
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			System.out.println("���ݿ����ӳɹ�");
			System.out.println(conn);
		}
		else {
			System.out.println("���ݿ�����ʧ��");
		}
	}
	
	
	@Test
	public void Hello() {
		System.out.println("testName");
	}
}
