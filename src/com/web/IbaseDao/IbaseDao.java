package com.web.IbaseDao;

import com.web.model.AdminJavaBean;

public interface IbaseDao {
public void add(AdminJavaBean admin);
public Object delete();
public Object update();
public AdminJavaBean select(String id);//获取单个信息
public Object getAll();//获取多个信息

}
