package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.IbaseDao.IbaseDao;
import com.web.model.AdminJavaBean;
import com.web.utils.DatabaseJDBC;

public class AdminDAOImpl implements IbaseDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String Sql = null;

	@Override
	public void add(AdminJavaBean admin) {
		try {
			conn = DatabaseJDBC.getConnection();
			if (conn != null) {
				System.out.println("数据库链接正常");
				Sql = "insert into Sadmin values(?,?)";
				psmt = conn.prepareStatement(Sql);
				/*
				 * System.out.println("conn:  " + conn); System.out.println(
				 * "psmt :  " + psmt); System.out.println("admin"+admin);
				 * System.out.println(admin.getId());
				 * System.out.println(admin.getSpassword());
				 */
				psmt.setString(1, admin.getId());
				psmt.setString(2, admin.getSpassword());
				psmt.executeUpdate();
				// System.out.println("rs:");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Object delete() {
		return null;
	}

	@Override
	public Object update() {
		return null;
	}

	@Override
	public AdminJavaBean select(String id) {
		AdminJavaBean adminJavaBean = null;
		try {
			conn = DatabaseJDBC.getConnection();
			if (conn != null) {
				System.out.println("数据库链接正常");
				Sql="select * from Sadmin where id=?";
				psmt = conn.prepareStatement(Sql);
				 System.out.println("conn: " + conn);
				 System.out.println("psmt : " + psmt);
				 psmt.setString(1, id);
				 rs = psmt.executeQuery();				
				//System.out.println("rs.next():"+rs.next());
				//System.out.println("rs.next():"+rs.getString("id"));
				//System.out.println("rs.next():"+rs.getString("S_password"));
				while (rs.next()) { 
					adminJavaBean = new AdminJavaBean();
					adminJavaBean.setId(rs.getString("id"));
					adminJavaBean.setSpassword(rs.getString("S_password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adminJavaBean;
	}

	@Override
	public Object getAll() {
		return null;
	}

}
