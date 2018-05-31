package com.web.model;

public class OhouseJavaBean {
	private String oid;
	private String owid;
	private String opid;
	private String otime;
	private String operson;
	private int oprice;
	private int ocount;
	private int osum;

	public int getOsum() {
		return osum;
	}

	public void setOsum(int osum) {
		this.osum = osum;
	}

	public OhouseJavaBean(String oid, String owid, String opid, String otime, String operson, int oprice, int ocount,
			int osum) {
		super();
		this.oid = oid;
		this.owid = owid;
		this.opid = opid;
		this.otime = otime;
		this.operson = operson;
		this.oprice = oprice;
		this.ocount = ocount;
		this.osum = osum;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOwid() {
		return owid;
	}

	public void setOwid(String owid) {
		this.owid = owid;
	}

	public String getOpid() {
		return opid;
	}

	public void setOpid(String opid) {
		this.opid = opid;
	}

	public String getOtime() {
		return otime;
	}

	public void setOtime(String otime) {
		this.otime = otime;
	}

	public String getOperson() {
		return operson;
	}

	public void setOperson(String operson) {
		this.operson = operson;
	}

	public int getOprice() {
		return oprice;
	}

	public void setOprice(int oprice) {
		this.oprice = oprice;
	}

	public int getOcount() {
		return ocount;
	}

	public void setOcount(int ocount) {
		this.ocount = ocount;
	}

	public OhouseJavaBean() {
		super();
	}
}