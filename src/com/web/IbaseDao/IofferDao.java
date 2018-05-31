package com.web.IbaseDao;

import java.util.List;

import com.web.model.OfferJavaBean;

public interface IofferDao {
	public void  add(OfferJavaBean offer);
	public boolean  delete(String oid);
	public void  update(OfferJavaBean offer);
	public OfferJavaBean get(String oid);//更新获取单个数据
	public  List<OfferJavaBean> select(String key,String content); 
	}
