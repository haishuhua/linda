package com.daigou.model;

import java.sql.*;

public class AUDTransaction {
	static String hostip = "localhost:3306";
	static String DBname = "test";
	static String user = "root";
	static String passwd = "";
	static Statement stmt;
	static Connection connect;

	static {
		if (connect != null) {
			System.out.println("Connection is not null");
			
		}
		
		if (connect == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
				// Class.forName("org.gjt.mm.mysql.Driver");
				System.out.println("Success loading Mysql Driver!");

				connect = DriverManager.getConnection("jdbc:mysql://" + hostip
						+ "/" + DBname + "?user=" + user + "&password="
						+ passwd + "&useUnicode=true&characterEncoding=utf-8");
				System.out.println("Success connect Mysql server!");
				stmt = connect.createStatement();
					
			} catch (Exception e) {
				System.out.print("Error loading Mysql Driver!");
				e.printStackTrace();
			}
		}
	}

	public static void addKehu(String name, String address, String number)
			throws SQLException {
		if (connect == null) {
			System.out.println("Connection is null");
			
		}
		
		System.out.print("here!");
		if (connect != null) {
			try {
				// Connection connect = DriverManager.getConnection(
				// "jdbc:mysql://localhost:3306/test","root","");
				// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
				System.out.print("here2");
				 stmt.executeUpdate("insert into kehu (name,address,number) values ('陆','陆','1111')");
				ResultSet rs = stmt.executeQuery("select * from kehu");
				while (rs.next()) {
					System.out.println(rs.getString("name"));
				}
			} catch (Exception e) {
				System.out.print("insert data error!");
				e.printStackTrace();
			}
		}
		if (connect != null) {
			System.out.println("Connection will be close");
			connect.close();
		}
		if (stmt != null) {
			stmt.close();
		}

	}
}
