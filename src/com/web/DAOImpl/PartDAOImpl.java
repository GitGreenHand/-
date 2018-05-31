package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.IbaseDao.IpartDAO;
import com.web.model.PartJavaBean;
import com.web.utils.DatabaseJDBC;

public class PartDAOImpl implements IpartDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String Sql = null;
	private List<PartJavaBean> list;

	@Override
	public void add(PartJavaBean part) {

		System.out.println("come  PartDAOImpl");
		System.out.println("part:" + part);
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "insert into part values(?,?,?,?,?,?,1)";
			// 3 调用方法

			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, part.getPid());
			psmt.setString(2, part.getPname());
			psmt.setString(3, part.getPsp());
			psmt.setString(4, "" + part.getPprice());
			psmt.setString(5, part.getPoffer());
			psmt.setString(6, part.getPtime());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

	}

	@Override
	public List<PartJavaBean> select(String key, String content) {

		list = new ArrayList<PartJavaBean>();
		System.out.println("come  select");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			switch (key) {
			case "Pid":
				Sql = "select * from part where P_id=?and P_state=1";
				break;
			case "Pname":
				Sql = "select * from part where P_name=?and P_state=1";
				break;
			case "Psp":
				Sql = "select * from part where P_sp=?and P_state=1";
				break;
			case "Pprice":
				Sql = "select * from part where P_price=?and P_state=1";
				break;
			case "Poffer":
				Sql = "select * from part where P_offer=?and P_state=1";
				break;
			case "Ptime":
				Sql = "select * from part where P_time=?and P_state=1";
				break;
			case "all":
				Sql = "select * from part where P_state=1";
				break;
			}
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			System.out.println("Key:" + key);
			System.out.println("content:" + content);
			if(!("all".equals(key)))
			{
				psmt.setString(1, content);
			}
			rs = psmt.executeQuery();
			while (rs.next()) {
				PartJavaBean part = new PartJavaBean();
				part.setPid(rs.getString("P_id"));
				part.setPname(rs.getString("P_name"));
				part.setPsp(rs.getString("P_sp"));
				part.setPprice(Double.parseDouble(rs.getString("P_price")));
				part.setPoffer(rs.getString("P_offer"));
				part.setPtime(rs.getString("P_time"));
				part.setState(Integer.parseInt(rs.getString("P_state")));
				list.add(part);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

		return list;
	}

	@Override
	public void update(PartJavaBean part) {
		System.out.println("come  update");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update part set P_name=?,P_sp=? ,P_price=?,P_offer=?,P_time=? where P_id=?";
			// 3 调用方法

			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, part.getPname());
			 psmt.setString(2, part.getPsp());
			 psmt.setString(3, ""+part.getPprice());
			 psmt.setString(4, part.getPoffer());
			 psmt.setString(5, part.getPtime());
			 psmt.setString(6, part.getPid());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

	}

	@Override
	public PartJavaBean get(String pid) {
		System.out.println("come  get");
		System.out.println("pid:" + pid);
		PartJavaBean part = new PartJavaBean();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from part where P_id=? ";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, pid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				part.setPid(rs.getString("P_id"));
				part.setPname(rs.getString("P_name"));
				part.setPsp(rs.getString("P_sp"));
				part.setPprice(Double.parseDouble(rs.getString("P_price")));
				part.setPoffer(rs.getString("P_offer"));
				part.setPtime(rs.getString("P_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

		return part;
	}

	@Override
	public void delete(String pid) {
		System.out.println("come  delete");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update part set P_state=0 where P_id=?";
			// 3 调用方法
			
			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, pid);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
	}

}
