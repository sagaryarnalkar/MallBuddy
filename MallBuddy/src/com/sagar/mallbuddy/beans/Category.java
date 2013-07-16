package com.sagar.mallbuddy.beans;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * Generated Serialization ID
	 */
	private static final long serialVersionUID = -5954453095861790454L;

	private String Name;
	private int catId;
	private int Img;
	private String shortDesc;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getImg() {
		return Img;
	}
	public void setImg(int img) {
		Img = img;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	
}
