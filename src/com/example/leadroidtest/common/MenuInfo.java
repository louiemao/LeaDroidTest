package com.example.leadroidtest.common;

public class MenuInfo {
	private String title;
	private Class<?> cls;

	public MenuInfo(String title, Class<?> cls) {
		this.title = title;
		this.cls = cls;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
}
