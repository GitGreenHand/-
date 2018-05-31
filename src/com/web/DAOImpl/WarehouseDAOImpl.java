package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Store;

import com.web.IbaseDao.IwarehouseDao;
import com.web.model.StoreJavaBean;
import com.web.model.WarehouseJavaBean;
import com.web.utils.DatabaseJDBC;

public class WarehouseDAOImpl implements IwarehouseDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String Sql = null;
	@Override
	public void add(WarehouseJavaBean warehouse) {
		System.out.println("come  warehouseDAOImpl  add");
		System.out.println("warehouse:" + warehouse);
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "insert into warehouse values(?,?,?,?,?,?,?)";
			// 3 调用方法

			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, warehouse.getWid());
			psmt.setString(2, warehouse.getWad());
			psmt.setInt(3, warehouse.getWsize());
			psmt.setString(4, warehouse.getWphone());
			psmt.setString(5, warehouse.getWperson());
			psmt.setInt(6, warehouse.getWspace());
			psmt.setInt(7, warehouse.getWstate());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseJDBC.Close(rs, psmt, conn);
			
		}


	}
	@Override
	public List<WarehouseJavaBean> select(String key, String content) {
		List<WarehouseJavaBean> list = new ArrayList<WarehouseJavaBean>();
		System.out.println("come  select");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			switch (key) {
			
			case "wid":
				Sql = "select * from warehouse where W_id=?and W_state=1";
				break;
			case "wad":
				Sql = "select * from warehouse where W_ad=?and W_state=1";
				break;
			case "wsize":
				Sql = "select * from warehouse where W_size=?and W_state=1";
				break;
			case "wphone":
				Sql = "select * from warehouse where W_phone=?and W_state=1";
				break;
			case "wperson":
				Sql = "select * from warehouse where W_person=?and W_state=1";
				break;
			case "wspace":
				Sql = "select * from warehouse where W_space=?and W_state=1";
				break;
			case "all":
				Sql = "select * from warehouse where  W_state=1";
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
			}
			rs = psmt.executeQuery();
			// 获得的是一个结果集，把他放入到list集合中
			while (rs.next()) {
				//wid wad wsize wphone wperson wspace
				//W_id W_ad W_size W_phone W_person W_space
				WarehouseJavaBean warehouse = new WarehouseJavaBean();
				warehouse.setWid(rs.getString("W_id"));
				warehouse.setWad(rs.getString("W_ad"));
				warehouse.setWsize(Integer.parseInt(rs.getString("W_size")));
				warehouse.setWphone(rs.getString("W_phone"));
				warehouse.setWperson(rs.getString("W_person"));
				warehouse.setWspace(Integer.parseInt(rs.getString("W_space")));
				warehouse.setWstate(Integer.parseInt(rs.getString("W_state")));
				list.add(warehouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseJDBC.Close(rs, psmt, conn);
			
		}

		// 4 提示
		System.out.println("success！");

		return list;
	}
	@Override
	public void update(WarehouseJavaBean warehouse) {
		System.out.println("come  update");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update warehouse set W_ad=?,W_size=? ,W_phone=?,W_person=?,W_space=? where W_id=?";
			// 3 调用方法

			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, warehouse.getWad());
			 psmt.setInt(2, warehouse.getWsize());
			 psmt.setString(3, warehouse.getWphone());
			 psmt.setString(4, warehouse.getWperson());
			 psmt.setInt(5, warehouse.getWspace());
			 psmt.setString(6, warehouse.getWid());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseJDBC.Close(rs, psmt, conn);
			
		}

		// 4 提示
		System.out.println("success！");
		
		
		
		
	}
	@Override
	public WarehouseJavaBean get(String wid) {
		System.out.println("come  get");
		System.out.println("wid:" + wid);
		WarehouseJavaBean warehouse = new WarehouseJavaBean();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from warehouse where W_id=? and W_state=1";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, wid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				warehouse.setWid(rs.getString("W_id"));
				warehouse.setWad(rs.getString("W_ad"));
				warehouse.setWsize(Integer.parseInt(rs.getString("W_size")));
				warehouse.setWphone(rs.getString("W_phone"));
				warehouse.setWperson(rs.getString("W_person"));
				warehouse.setWspace(Integer.parseInt(rs.getString("W_space")));
				warehouse.setWstate(Integer.parseInt(rs.getString("W_state")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseJDBC.Close(rs, psmt, conn);
			
		}

		// 4 提示
		System.out.println("success！");

		return warehouse;
	}
	@Override
	public boolean delete(String wid) {
		
		System.out.println("come  delete");
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			//update part set P_sp='B' where P_sp='A'and P_id='003';
			Sql = "update warehouse set W_state=0 where W_id=?";
			// 3 调用方法
			
			 psmt=conn.prepareStatement(Sql);
			 psmt.setString(1, wid);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            DatabaseJDBC.Close(rs, psmt, conn);
        }

		
		
	return true;
	}
	
		
		
	}

	

