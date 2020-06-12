package com.company.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// 声明“数据库连接对象”，单例模式
	private static Connection conn;

	// 方法：获取“数据库连接对象”，单例模式。
	public static Connection getConnection() {
		// 判断“数据库连接对象”是否存在
		try {
			// 判断条件：连接对象不为空 并且 连接对象不是关闭的
			if (conn != null && !conn.isClosed()) {
				return conn;
				// 返回成功后，后面的代码将不会被执行。
			}

			// 加载“驱动类” SPI
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 创建“URL连接字符串”。格式：jdbc:oracle:thin:@ 主机名/IP : 端口号 ：服务名称
			String url = "jdbc:oracle:thin:@localhost:1521:XE";

			// 创建“用户名”
			String username = "bookmall";
			// 创建“密码”
			String password = "123456";

			// 初始化“数据库连接对象”
			conn = DriverManager.getConnection(url, username, password);
			if (conn != null) {
				System.out.println("[操作提示]恭喜您，数据库连接成功！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
