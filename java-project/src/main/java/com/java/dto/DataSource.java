package com.java.dto;

public class DataSource {
	
	private Integer id;

	public DataSource() {
		this.id = 0;
	}
	
	public Integer generateTweetId() {
		return ++id;
	}

}
