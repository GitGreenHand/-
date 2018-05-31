package com.web.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;

import com.sun.org.apache.regexp.internal.recompile;
import com.web.IbaseDao.IhouseDao;
import com.web.model.IhouseJavaBean;
import com.web.model.OhouseJavaBean;
import com.web.model.StoreJavaBean;
import com.web.utils.DatabaseJDBC;

public class HouseDAOImpl implements IhouseDao {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private ResultSet rsPrice = null;
	private String Sql = null;

	@Override
	public boolean in(IhouseJavaBean ihouse) {
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			// 要判断 仓库是否 有多余的空间
			boolean isOK = isStore(ihouse);
			if (!isOK) {
				// 没有有多余空间
				return false;
			}
			// 先要在库存表中查询是否有存在该零件
			boolean flag = IsExistPart(ihouse);
			if (flag) {
				// 如果存在将现在入库的东西加在一起。
				// 获取库存中的数量
				int num = getNumFromStore(ihouse);
				// 更新库存数量
				updateStore(ihouse, num);
			} else {
				// 如果不存在就添加到库存表中，
				addStore(ihouse);

				// 并在入库表中记录
				addInhouse(ihouse);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {

			DatabaseJDBC.Close(rs, psmt, conn);
		}
		return true;
	}

	private boolean isStore(IhouseJavaBean ihouse) {
		Sql = "select W_space from warehouse where W_id=? and W_state=1 ";
		String getiWid = ihouse.getiWid();
		int space = 0;
		try {
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, getiWid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				space = rs.getInt("W_space");
				if (space >= ihouse.getIcount()) {
					// 还要将仓库表中的所剩余空间更新;
					updateWarehouseSpace(space - ihouse.getIcount(),ihouse.getiWid());
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void updateWarehouseSpace(int space ,String wid) {
		try {
			Sql = "update warehouse set W_space=?where W_id=? and W_state=1 ";
			psmt = conn.prepareStatement(Sql);
			psmt.setInt(1, space);
			psmt.setString(2, wid);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private int getNumFromStore(IhouseJavaBean ihouse) {
		Sql = "select * from mstore where S_state=1 and S_W_id=? and S_P_id=? ";
		try {
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, ihouse.getiWid());
			psmt.setString(2, ihouse.getiPid());
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("S_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	private void updateStore(IhouseJavaBean ihouse, int num) {
		String getiPid = ihouse.getiPid();
		String getiWid = ihouse.getiWid();
		int addNum = ihouse.getIcount();
		Sql = "update  mstore set S_num =? where S_P_id=? and S_W_Id=? and S_state=1";
		try {
			psmt = conn.prepareStatement(Sql);
			psmt.setInt(1, num + addNum);
			psmt.setString(2, getiPid);
			psmt.setString(3, getiWid);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean IsExistPart(IhouseJavaBean ihouse) {
		String getiPid = ihouse.getiPid();
		String getiWid = ihouse.getiWid();
		Sql = "select * from mstore where S_P_id=? and S_W_Id=? and S_state=1";
		try {
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, getiPid);
			psmt.setString(2, getiWid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	private void addInhouse(IhouseJavaBean ihouse) throws SQLException {
		Sql = "insert into I_house values(?,?,?,to_date(?,'yyyy-MM-dd HH24:mi:ss'),?,?,?,?)";
		// 3 调用方法
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, ihouse.getIid());
		psmt.setString(2, ihouse.getiWid());
		psmt.setString(3, ihouse.getiPid());
		psmt.setString(4, ihouse.getItime());
		psmt.setString(5, ihouse.getIperson());
		psmt.setInt(6, ihouse.getIprice());
		psmt.setInt(7, ihouse.getIcount());
		psmt.setInt(8, ihouse.getIsum());
		psmt.executeUpdate();
	}

	private void addStore(IhouseJavaBean ihouse) throws SQLException {
		Sql = "insert into mstore values(?,?,?,?,1) ";
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, System.currentTimeMillis() + "");
		psmt.setString(2, ihouse.getiPid());
		psmt.setString(3, ihouse.getiWid());
		psmt.setInt(4, ihouse.getIcount());
		psmt.executeUpdate();
	}

	@Override
	public boolean out(OhouseJavaBean ohouse) {
		System.out.println("come  out");
		System.out.println("ohouse:" + ohouse);
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			// 要判断数据库（仓库有没有）,才可以出库。
			Sql = "select * from mstore where S_state=1 and S_W_id=? and S_P_id=? ";
			psmt = conn.prepareStatement(Sql);
			System.out.println("ohouse.getOwid():" + ohouse.getOwid());
			System.out.println("ohouse.getOpid():" + ohouse.getOpid());
			psmt.setString(1, ohouse.getOwid());
			psmt.setString(2, ohouse.getOpid());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("rs.getInt(S_num)：" + rs.getInt("S_num"));
				System.out.println("rs.getString(S_P_id)：" + rs.getString("S_P_id"));
				if (rs.getInt("S_num") < ohouse.getOcount()) {
					System.out.println("仓库没有那么多货");
					return false;
				} else {
					// 修改mstote表中数据。
					updateHouse(ohouse);
					outHouse(ohouse);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);
		}
		return true;
	}

	private void updateHouse(OhouseJavaBean ohouse) throws SQLException {
		int num = 0;
		num = getStoreNum(ohouse, num) - ohouse.getOcount();
		Sql = "update mstore set S_num=? where S_W_id =? and S_state=1 AND S_P_id=?";
		psmt = conn.prepareStatement(Sql);
		psmt.setInt(1, num);
		psmt.setString(2, ohouse.getOwid());
		psmt.setString(3, ohouse.getOpid());
		psmt.executeUpdate();
	}

	private int getStoreNum(OhouseJavaBean ohouse, int num) throws SQLException {
		Sql = "select S_num from mstore where S_W_id =? and S_state=1 AND S_P_id=?";
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, ohouse.getOwid());
		psmt.setString(2, ohouse.getOpid());
		rs = psmt.executeQuery();

		if (rs.next()) {
			num = rs.getInt("S_num");
		}
		return num;
	}

	private void outHouse(OhouseJavaBean ohouse) throws SQLException {
		Sql = "insert into O_house values(?,?,?,to_date(?,'yyyy-MM-dd HH24:mi:ss'),?,?,?,?)";
		// 3 调用方法
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, ohouse.getOid());
		psmt.setString(2, ohouse.getOwid());
		psmt.setString(3, ohouse.getOpid());
		psmt.setString(4, ohouse.getOtime());
		psmt.setString(5, ohouse.getOperson());
		psmt.setInt(6, ohouse.getOprice());
		psmt.setInt(7, ohouse.getOcount());
		psmt.setInt(8, ohouse.getOsum());
		psmt.executeUpdate();

	}

	@Override
	public List<StoreJavaBean> select(String sid) {
		System.out.println("come OhouseJavaBean  select");
		System.out.println("sid:" + sid);
		List<StoreJavaBean> list = new ArrayList<>();

		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from mstore where S_W_id=? and S_state=1";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, sid);
			rs = psmt.executeQuery();
			// System.out.println("rs.next():"+rs.next());
			while (rs.next()) {
				StoreJavaBean store = new StoreJavaBean();
				store.setSid(rs.getString("S_id"));
				store.setSpid(rs.getString("S_P_id"));
				store.setSwid(rs.getString("S_W_id"));
				store.setSnum(rs.getInt("S_num"));
				store.setSstate(rs.getInt("S_state"));
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);
		}

		return list;
	}

	@Override
	public Map<String, Integer> getByWid(String wid, String flag) {
		int value = 0;// 零件的数量
		String key = null;// 仓库的零件号
		int price = 0;// 零件的单价
		Map<String, Integer> map = new HashMap<>();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from mstore where S_W_id=? and S_state=1";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, wid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				key = rs.getString("S_P_id");
				value = rs.getInt("S_num");
				// 获取当前key零件编码的单价。
				if ("pieChart".equals(flag)) {
					price = getPartPrice(key);
					value = value * price;
				}
				map.put(key, value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);

		}
		return map;
	}

	private Integer getPartPrice(String key) throws SQLException {
		int price = 0;
		Sql = "select P_price from part where P_id=?and P_state=1";
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, key);
		rsPrice = psmt.executeQuery();
		while (rsPrice.next()) {
			price = rsPrice.getInt("P_price");
		}
		return price;
	}

	private boolean isExit(String oid) throws SQLException {
		Sql = "select * from  I_house  where I_id=?";
		psmt = conn.prepareStatement(Sql);
		psmt.setString(1, oid);
		rs = psmt.executeQuery();
		return rs.next();
	}

	@Override
	public List<IhouseJavaBean> getInhouse(String inHouseId) {
		System.out.println("come IhouseJavaBean  getInhouse");
		System.out.println("inHouseId:" + inHouseId);
		List<IhouseJavaBean> list = new ArrayList<>();

		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from I_house where I_id=?";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, inHouseId);
			rs = psmt.executeQuery();
			// System.out.println("rs.next():"+rs.next());
			while (rs.next()) {
				IhouseJavaBean inhouse = new IhouseJavaBean();
				inhouse.setIid(rs.getString("I_id"));
				inhouse.setiWid(rs.getString("I_W_id"));
				inhouse.setiPid(rs.getString("I_P_id"));
				inhouse.setItime(rs.getString("I_time"));
				inhouse.setIperson(rs.getString("I_person"));
				inhouse.setIprice(rs.getInt("I_price"));
				inhouse.setIcount(rs.getInt("I_count"));
				inhouse.setIsum(rs.getInt("I_sum"));
				list.add(inhouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);
		}

		return list;

	}

	@Override
	public List<OhouseJavaBean> getOuthouse(String onHouseId) {
		System.out.println("come IhouseJavaBean  getOuthouse");
		System.out.println("onHouseId:" + onHouseId);
		List<OhouseJavaBean> list = new ArrayList<>();
		try {
			// 数据库乱码;
			// 1链接数据库
			conn = DatabaseJDBC.getConnection();
			// 2 编写SQL语句
			Sql = "select * from O_house where O_id=?";
			// 3 调用方法
			psmt = conn.prepareStatement(Sql);
			psmt.setString(1, onHouseId);
			rs = psmt.executeQuery();
			// System.out.println("rs.next():"+rs.next());
			while (rs.next()) {
				OhouseJavaBean onhouse = new OhouseJavaBean();
				onhouse.setOid(rs.getString("O_id"));
				onhouse.setOwid(rs.getString("O_W_id"));
				onhouse.setOpid(rs.getString("O_P_id"));
				onhouse.setOtime(rs.getString("O_time"));
				onhouse.setOperson(rs.getString("O_person"));
				onhouse.setOprice(rs.getInt("O_price"));
				onhouse.setOcount(rs.getInt("O_count"));
				onhouse.setOsum(rs.getInt("O_sum"));
				list.add(onhouse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);
		}

		return list;
	}

	@Override
	public Map<String, List<String>> getPartIdAndWareHouseId() {

		Map<String, List<String>> map = new HashMap<>();
		List<String> listpartid = new ArrayList<>();
		List<String> listwarehouseid = new ArrayList<>();
		listpartid = getid("partId");
		listwarehouseid = getid("warehouseId");
		map.put("partid", listpartid);
		map.put("warehouseid", listwarehouseid);
		return map;
	}

	private List<String> getid(String id) {

		List<String> list = new ArrayList<>();
		if ("partId".equals(id)) {
			Sql = "select P_id  from  part where P_state=1";
			// 进行part表的查询
		} else if ("warehouseId".equals(id)) {
			// 进行warehouse表的查询
			Sql = "select W_id from warehouse where W_state=1";
		}
		try {
			conn = DatabaseJDBC.getConnection();
			psmt = conn.prepareStatement(Sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				if ("partId".equals(id)) {
					System.out.println("rs.getString(P_id):" + rs.getString("P_id"));
					list.add(rs.getString("P_id"));
				} else {
					System.out.println("rs.getString(W_id):" + rs.getString("W_id"));
					list.add(rs.getString("W_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseJDBC.Close(rs, psmt, conn);
		}

		return list;
	}

}
