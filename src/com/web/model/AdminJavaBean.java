package com.web.model;

public class AdminJavaBean {
	private String id;
	private String Spassword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AdminJavaBean(String id, String spassword) {
		super();
		this.id = id;
		Spassword = spassword;
	}

	public AdminJavaBean() {
	}

	@Override
	public String toString() {
		return "AdminJavaBean [id=" + id + ", Spassword=" + Spassword + "]";
	}

	public String getSpassword() {
		return Spassword;
	}

	public void setSpassword(String spassword) {
		Spassword = spassword;
	}
}
