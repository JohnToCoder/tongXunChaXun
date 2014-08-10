package com.model;

public class voiceList {
	private int id;
	private String name;
	private String datetime;
	private String longth;
	private String style;
	private String toNum;
	private String place;
	private String toll;
	public voiceList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public voiceList(int id, String name, String datetime, String longth,
			String style, String toNum, String place, String toll) {
		super();
		this.id = id;
		this.name = name;
		this.datetime = datetime;
		this.longth = longth;
		this.style = style;
		this.toNum = toNum;
		this.place = place;
		this.toll = toll;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getLongth() {
		return longth;
	}
	public void setLongth(String longth) {
		this.longth = longth;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getToNum() {
		return toNum;
	}
	public void setToNum(String toNum) {
		this.toNum = toNum;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getToll() {
		return toll;
	}
	public void setToll(String toll) {
		this.toll = toll;
	}
}
