package com.web.IbaseDao;

import java.util.List;

import com.web.model.StaffJavaBean;

public interface IstaffDao {
public void  add(StaffJavaBean staff);
public boolean  delete(String stid);
public void  update(StaffJavaBean staff);
public StaffJavaBean get(String stid);//更新获取单个数据
public  List<StaffJavaBean> select(String key,String content); 
}
