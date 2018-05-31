/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.web.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseJDBC {
	public DatabaseJDBC() {

	}

	// 静态工具连接数据库方法
	public static Connection getConnection() {
		Connection connection = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String username = "hr";
		String password = "123456";
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException exception) {
			Logger.getLogger(DatabaseJDBC.class.getName()).log(Level.SEVERE, null, exception);
		} catch (SQLException exception) {
			Logger.getLogger(DatabaseJDBC.class.getName()).log(Level.SEVERE, null, exception);
		}
		return connection;
	}

	public static void Close(ResultSet rs, Statement stmt, Connection connection) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException exception) {
			Logger.getLogger(DatabaseJDBC.class.getName()).log(Level.SEVERE, null, exception);
		}
	}

}
