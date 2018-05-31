package com.web.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.web.DAOImpl.HouseDAOImpl;
import com.web.IbaseDao.IpieService;
import com.web.utils.PieTools;


public class PieServiceImp implements IpieService {
/**
 * 从饼状图工具类里面获取创建的Columnar柱状图
 */
public JFreeChart createPieTools(String wid) {
    // TODO Auto-generated method stub
    // 获取饼状图的数据集
    DefaultPieDataset dataset = getDataSet(wid);
    // 获取饼状图工具类创建的饼状图
    JFreeChart chart = PieTools.createPie(dataset);
    return chart;
}

/**
 * 添加饼状图的数据
 * @param wid 
 * 
 * @return
 */
private static DefaultPieDataset getDataSet(String wid) {
    // 数据可以从数据库中得到
    DefaultPieDataset dataset = new DefaultPieDataset();
    // 添加数据
    HouseDAOImpl houseDAOImpl=new HouseDAOImpl();
    Map<String, Integer> mapkey=new HashMap<>();
    
    mapkey= houseDAOImpl.getByWid(wid,"pieChart");
  
    System.out.println("mapkey:"+mapkey);
    //查询单价将单价和数量相乘
    
    Set<String> keys = mapkey.keySet();
    for (String key : keys) {

        dataset.setValue("零件编号"+key, mapkey.get(key));
    } 
    return dataset;
}
}