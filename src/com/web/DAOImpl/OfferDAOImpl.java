package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.IbaseDao.IofferDao;
import com.web.model.OfferJavaBean;
import com.web.utils.DatabaseJDBC;

public class OfferDAOImpl implements IofferDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String Sql = null;
	@Override
	public void add(OfferJavaBean offer) {
		System.out.println("come  add");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "insert into offer values(?,?,?,?,?,1)";
			// 3 调用方法

			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, offer.getOname());
			psmt.setString(2, offer.getOad());
			psmt.setString(3, offer.getOlike());
			psmt.setString(4, offer.getOphone());
			psmt.setString(5, offer.getOperson());

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");
	}
	@Override
	public boolean delete(String oname) {
		System.out.println("come  delete");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update offer set O_state=0 where O_name=?";
			// 3 调用方法
			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, oname);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }
		return true;
	}
	@Override
	public void update(OfferJavaBean offer) {
		System.out.println("come  update");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update offer set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update offer set O_ad=?,O_like=? ,O_phone=?,O_person=? where O_name=?";
			// 3 调用方法

			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, offer.getOad());
			 psmt.setString(2, offer.getOlike());
			 psmt.setString(3, offer.getOphone());
			 psmt.setString(4, offer.getOperson());
			 psmt.setString(5, offer.getOname());
			 psmt.executeUpdate();
			 System.out.println(offer.getOname()+"的信息修改了");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");
		
		
	}
	@Override
	public OfferJavaBean get(String oname) {
		System.out.println("come  get");
		System.out.println("oname:" + oname);
		OfferJavaBean offer=new OfferJavaBean();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from offer where O_name=?";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, oname);
			rs = psmt.executeQuery();
			while (rs.next()) {
				offer.setOname(rs.getString("O_name"));
				offer.setOad(rs.getString("O_ad"));
				offer.setOlike(rs.getString("O_like"));
				offer.setOphone(rs.getString("O_phone"));
				offer.setOperson(rs.getString("O_person"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

		return offer;
		
	}
	@Override
	public List<OfferJavaBean> select(String key, String content) {
		
		List<OfferJavaBean>	list = new ArrayList<OfferJavaBean>();
		System.out.println("come  select");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			switch (key) {
			case "oname":
				Sql = "select * from offer where O_name=?and O_state=1";
				break;
			case "oad":
				Sql = "select * from offer where O_ad=?and O_state=1";
				break;
			case "olike":
				Sql = "select * from offer where O_like=?and O_state=1";
				break;
			case "ophone":
				Sql = "select * from offer where O_phone=?and O_state=1";
				break;
			case "operson":
				Sql = "select * from offer where O_person=?and O_state=1";
				break;
			case "all":
				Sql = "select * from offer where  O_state=1";
				break;

			}
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			System.out.println("Key:" + key);
			System.out.println("content:" + content);
			// psmt.setString(1,key );
			if(!("all".equals(key)))
			{
				psmt.setString(1, content);
			}
			//没有找到值？
			rs = psmt.executeQuery();
			while (rs.next()) {
				OfferJavaBean offer=new OfferJavaBean();
				offer.setOname(rs.getString("O_name"));
				offer.setOad(rs.getString("O_ad"));
				offer.setOlike(rs.getString("O_like"));
				offer.setOphone(rs.getString("O_phone"));
				offer.setOperson(rs.getString("O_person"));
				list.add(offer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4 提示
		System.out.println("success！");

		return list;
		
		
		
	}



}
