package com.cg.marriageceremony.model;

import javax.persistence.Entity;

@Entity
public class Caterers extends Vendor {
	private String cName;
	private String cDiscription;
	private String imagepath;
	
	public Caterers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Caterers(String cName, String cDiscription, String imagepath) {
		super();
		this.cName = cName;
		this.cDiscription = cDiscription;
		this.imagepath = imagepath;
	}

	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDiscription() {
		return cDiscription;
	}
	public void setcDiscription(String cDiscription) {
		this.cDiscription = cDiscription;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}
