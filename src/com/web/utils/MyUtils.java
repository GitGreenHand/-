package com.web.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyUtils {
	
	private static Connection conn = null;
	private static PreparedStatement psmt = null;
	private ResultSet rs = null;
	private static String Sql = null;
	
	public static boolean  isExit (String key,String type) {
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			
			// 2 编写SQL语句
			switch (type) {
			case "ohouse":
				Sql = "select * from  I_house  where I_id=?";
				break; 
			default:
				break;
			}
			
			// 3 调用方法

			psmt = conn.prepareStatement(Sql);
			/*psmt.setString(1, part.getPid());
			psmt.setString(2, part.getPname());
			psmt.setString(3, part.getPsp());
			psmt.setString(4, "" + part.getPprice());
			psmt.setString(5, part.getPoffer());
			psmt.setString(6, part.getPtime());*/
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");
		
		
		
		
		
		
	return true;
	
		
	}

}
