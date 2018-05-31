package com.web.model;

public class OfferJavaBean {
	private String oname;
	private String oad;
	private String olike;
	private String ophone;
	private String operson;
	private int ostate;
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOad() {
		return oad;
	}
	public void setOad(String oad) {
		this.oad = oad;
	}
	public String getOlike() {
		return olike;
	}
	public void setOlike(String olike) {
		this.olike = olike;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public String getOperson() {
		return operson;
	}
	public void setOperson(String operson) {
		this.operson = operson;
	}
	public int getOstate() {
		return ostate;
	}
	public void setOstate(int ostate) {
		this.ostate = ostate;
	}
	public OfferJavaBean(String oname, String oad, String olike, String ophone, String operson, int ostate) {
		super();
		this.oname = oname;
		this.oad = oad;
		this.olike = olike;
		this.ophone = ophone;
		this.operson = operson;
		this.ostate = ostate;
	}
	public OfferJavaBean() {
		super();
	}
	
}
