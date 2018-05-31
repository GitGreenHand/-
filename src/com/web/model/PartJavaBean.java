package com.web.model;

public class PartJavaBean {
	private String pid;
	private String pname;
	private String psp;
	private double pprice;
	private String poffer;
	private String ptime;
	private int state;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsp() {
		return psp;
	}
	public void setPsp(String psp) {
		this.psp = psp;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPoffer() {
		return poffer;
	}
	public void setPoffer(String poffer) {
		this.poffer = poffer;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public PartJavaBean(String pid, String pname, String psp, double pprice, String poffer, String ptime, int state) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.psp = psp;
		this.pprice = pprice;
		this.poffer = poffer;
		this.ptime = ptime;
		this.state = state;
	}
	public PartJavaBean() {
		super();
	}
	

}
