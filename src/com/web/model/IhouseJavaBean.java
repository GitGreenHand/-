package com.web.model;


public class IhouseJavaBean {
	private String iid;
	private String iWid;
	private String iPid;
	private String  itime;
	private String iperson;
	private int  iprice;
	private int  icount;
	private int  isum;
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getiWid() {
		return iWid;
	}
	public void setiWid(String iWid) {
		this.iWid = iWid;
	}
	public String getiPid() {
		return iPid;
	}
	public void setiPid(String iPid) {
		this.iPid = iPid;
	}
	public String getItime() {
		return  itime;
	}
	public void setItime(String itime) {
		this.itime = itime;
	}
	public String getIperson() {
		return iperson;
	}
	public void setIperson(String iperson) {
		this.iperson = iperson;
	}
	public int getIprice() {
		return iprice;
	}
	public void setIprice(int iprice) {
		this.iprice = iprice;
	}
	public int getIcount() {
		return icount;
	}
	public void setIcount(int icount) {
		this.icount = icount;
	}
	public int getIsum() {
		return isum;
	}
	public void setIsum(int isum) {
		this.isum = isum;
	}
	public IhouseJavaBean(String iid, String iWid, String iPid, String itime, String iperson, int iprice, int icount,
			int isum) {
		super();
		this.iid = iid;
		this.iWid = iWid;
		this.iPid = iPid;
		this.itime = itime;
		this.iperson = iperson;
		this.iprice = iprice;
		this.icount = icount;
		this.isum = isum;
	}
	public IhouseJavaBean() {
		super();
	}
	@Override
	public String toString() {
		return "IhouseJavaBean [iid=" + iid + ", iWid=" + iWid + ", iPid=" + iPid + ", itime=" + itime + ", iperson="
				+ iperson + ", iprice=" + iprice + ", icount=" + icount + ", isum=" + isum + "]";
	}

}
