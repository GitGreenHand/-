package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.IbaseDao.IstaffDao;
import com.web.model.StaffJavaBean;
import com.web.utils.DatabaseJDBC;

public class StaffDAOImpl implements IstaffDao {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String Sql = null;

	@Override
	public void add(StaffJavaBean staff) {
		System.out.println("come  add");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "insert into staff values(?,?,?,?,?,?,?)";
			// 3 调用方法

			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, staff.getStid());
			psmt.setString(2, staff.getStname());
			psmt.setString(3, staff.getStsex());
			psmt.setInt(4, staff.getStage());
			psmt.setInt(5, staff.getStpower());
			psmt.setString(6, staff.getStpassword());
			psmt.setString(7, staff.getStpart());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");
	}

	@Override
	public List<StaffJavaBean> select(String key, String content) {

		ArrayList<StaffJavaBean> list = new ArrayList<StaffJavaBean>();
		System.out.println("come  select");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			switch (key) {
			case "stpart":
				Sql = "select * from staff where ST_part=?";
				break;
			case "stid":
				Sql = "select * from staff where ST_id=?";
				break;
			case "stname":
				Sql = "select * from staff where ST_name=?";
				break;
			case "stsex":
				Sql = "select * from staff where ST_sex=?";
				break;
			case "stage":
				Sql = "select * from staff where ST_age=?";
				break;
			case "stpower":
				Sql = "select * from staff where ST_power=?";
				break;
			case "all":
				Sql = "select * from staff ";
				break;
			}

			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			System.out.println("Key:" + key);
			System.out.println("content:" + content);
			// psmt.setString(1,key );
			if(!key.equals("all"))
			{
				psmt.setString(1, content);
			}rs = psmt.executeQuery();
			// 获得的是一个结果集，把他放入到list集合中
			// System.out.println("rs:"+rs);
			// System.out.println("rs.next():"+rs.next());
			// System.out.println("Sql:"+Sql);
			while (rs.next()) {
				StaffJavaBean staff = new StaffJavaBean();
				staff.setStid(rs.getString("ST_id"));
				staff.setStname(rs.getString("ST_name"));
				staff.setStsex(rs.getString("ST_sex"));
				staff.setStage(Integer.parseInt(rs.getString("ST_age")));
				staff.setStpower(Integer.parseInt(rs.getString("ST_power")));
				staff.setStpart(rs.getString("ST_part"));
				list.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean delete(String stid) {
		System.out.println("come  delete");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "delete  from  staff where ST_id=? ";
			// 3 调用方法
			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, stid);
			 psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true ;

		
	}

	@Override
	public void update(StaffJavaBean staff) {
		System.out.println("come  update");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update staff set ST_name=?,ST_sex=? ,ST_age=?,ST_power=? where ST_id=?";
			// 3 调用方法

			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, staff.getStname());
			 psmt.setString(2, staff.getStsex());
			 psmt.setInt(3, staff.getStage());
			 psmt.setInt(4, staff.getStpower());
			 psmt.setString(5, staff.getStid());
			 psmt.executeUpdate();
			 System.out.println(staff.getStname()+"的信息修改了");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");
		
	}

	@Override
	public StaffJavaBean get(String stid) {
		System.out.println("come  get");
		System.out.println("stid:" + stid);
		StaffJavaBean staff = new StaffJavaBean();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from staff where ST_id=?";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, stid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				staff.setStpassword(rs.getString("ST_password"));
				staff.setStid(rs.getString("ST_id"));
				staff.setStname(rs.getString("ST_name"));
				staff.setStsex(rs.getString("ST_sex"));
				staff.setStage((rs.getInt("ST_age")));
				staff.setStpower((rs.getInt("ST_power")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

		return staff;
	}

}
