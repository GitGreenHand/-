package com.web.IbaseDao;

import java.util.List;

import com.web.model.PartJavaBean;

public interface IpartDAO {
public  void add(PartJavaBean part);
public  List<PartJavaBean> select(String key,String content); 
public void update(PartJavaBean part);
public PartJavaBean get(String pid);//更新获取单个数据
public void delete(String pid);
}