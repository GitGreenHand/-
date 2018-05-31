package com.web.IbaseDao;

import java.util.List;

import com.web.model.WarehouseJavaBean;

public interface IwarehouseDao {
public void add(WarehouseJavaBean warehouse);
public  List<WarehouseJavaBean> select(String key,String content); 
public void update(WarehouseJavaBean warehouse);
public WarehouseJavaBean get(String wid);//更新获取单个数据
public boolean delete(String wid);

}
