package com.web.model;

public class WarehouseJavaBean {
	private String wid;
	private String wad;
	private int wsize;
	private String wphone;
	private String wperson;
	private int wspace;// 剩余空间
	private  int wstate;
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	public String getWad() {
		return wad;
	}
	public void setWad(String wad) {
		this.wad = wad;
	}
	public int getWsize() {
		return wsize;
	}
	public void setWsize(int wsize) {
		this.wsize = wsize;
	}
	public String getWphone() {
		return wphone;
	}
	public void setWphone(String wphone) {
		this.wphone = wphone;
	}
	public String getWperson() {
		return wperson;
	}
	public void setWperson(String wperson) {
		this.wperson = wperson;
	}
	public int getWspace() {
		return wspace;
	}
	public void setWspace(int wspace) {
		this.wspace = wspace;
	}
	public int getWstate() {
		return wstate;
	}
	public void setWstate(int wstate) {
		this.wstate = wstate;
	}
	public WarehouseJavaBean(String wid, String wad, int wsize, String wphone, String wperson, int wspace, int wstate) {
		
		this.wid = wid;
		this.wad = wad;
		this.wsize = wsize;
		this.wphone = wphone;
		this.wperson = wperson;
		this.wspace = wspace;
		this.wstate = wstate;
	}
	@Override
	public String toString() {
		return "WarehouseJavaBean [wid=" + wid + ", wad=" + wad + ", wsize=" + wsize + ", wphone=" + wphone
				+ ", wperson=" + wperson + ", wspce=" + wspace + ", wstate=" + wstate + "]";
	}
	public WarehouseJavaBean() {
		super();
	}
	
	
	
}	
	