package com.web.IbaseDao;

import java.util.List;
import java.util.Map;

import com.web.model.IhouseJavaBean;
import com.web.model.OhouseJavaBean;
import com.web.model.StoreJavaBean;

public interface IhouseDao {
	public boolean in(IhouseJavaBean ihouse);
	public boolean out(OhouseJavaBean ohouse);
	public List<IhouseJavaBean> getInhouse(String inHouseId );
	public List<OhouseJavaBean> getOuthouse(String onHouseId );
	public List<StoreJavaBean>  select(String sid);
	public Map <String,List<String>> getPartIdAndWareHouseId();
	public Map<String, Integer>getByWid(String wid ,String flag);	
}
