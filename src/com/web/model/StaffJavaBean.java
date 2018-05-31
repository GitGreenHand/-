package com.web.model;

public class StaffJavaBean {
	private String stid;
	private String  stname;
	private String  stsex;
	private int  stage;
	private int stpower;
	private String stpassword;
	private  String stpart;
	
	
	public String getStpart() {
		return stpart;
	}

	public void setStpart(String stpart) {
		this.stpart = stpart;
	}

	public String getStpassword() {
		return stpassword;
	}

	public void setStpassword(String stpassword) {
		this.stpassword = stpassword;
	}



	public StaffJavaBean(String stid, String stname, String stsex, int stage, int stpower, String stpassword,
			String stpart) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.stsex = stsex;
		this.stage = stage;
		this.stpower = stpower;
		this.stpassword = stpassword;
		this.stpart = stpart;
	}

	public StaffJavaBean() {
		super();
	}
	
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStsex() {
		return stsex;
	}
	public void setStsex(String stsex) {
		this.stsex = stsex;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getStpower() {
		return stpower;
	}
	public void setStpower(int stpower) {
		this.stpower = stpower;
	}
}	
