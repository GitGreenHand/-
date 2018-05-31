package com.web.DAOImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.web.IbaseDao.IchartDao;
import com.web.utils.ColumnarTools;

public class ChartDAIOImpl implements IchartDao {

	@Override

	// 从柱状图工具类里面获取创建的Columnar柱状图

	public JFreeChart createColumnarTools(String wid) {
		// TODO Auto-generated method stub
		// 获得数据
		CategoryDataset dataset = getDataSet(wid);
		// 获取柱状图工具类创建的柱状图，（将数据集传入）
		JFreeChart chart = ColumnarTools.createCoColumnar(dataset);
		return chart;
	}

	// 获取一个演示用的组合数据集对象 为柱状图添加数据

	private static CategoryDataset getDataSet(String wid) {
		// 数据可以从数据库中得到
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		HouseDAOImpl houseDAOImpl=new HouseDAOImpl();
	    Map<String, Integer> mapkey=new HashMap<>();
	    mapkey= houseDAOImpl.getByWid(wid,"colChart");
	    Set<String> keys = mapkey.keySet();
	    for (String key : keys) {
	        dataset.setValue(mapkey.get(key),"数量", key);
	    } 
		
		
		return dataset;
	}

	@Override
	public JFreeChart createColumnarTools() {
		return null;
	}
}
