package com.web.model;

public class StoreJavaBean {
	private String sid;
	private String spid;
	private String swid;
	private int snum;
	private int sstate;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpid() {
		return spid;
	}
	public void setSpid(String spid) {
		this.spid = spid;
	}
	public String getSwid() {
		return swid;
	}
	public void setSwid(String swid) {
		this.swid = swid;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public int getSstate() {
		return sstate;
	}
	public void setSstate(int sstate) {
		this.sstate = sstate;
	}
	public StoreJavaBean(String sid, String spid, String swid, int snum, int sstate) {
		super();
		this.sid = sid;
		this.spid = spid;
		this.swid = swid;
		this.snum = snum;
		this.sstate = sstate;
	}
	public StoreJavaBean() {
		super();
	}

}
