package com.java.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Tweet {
	
	private String id;
	private String content;
	private String author;
	private Date timestamp;
	private List<String> likes;
	private List<String> retweets;
	private List<String> replies;
	
	public Tweet(String id, String content, String author, Date timestamp) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.timestamp = timestamp;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	public List<String> getRetweets() {
		return retweets;
	}
	public void setRetweets(List<String> retweets) {
		this.retweets = retweets;
	}
	public List<String> getReplies() {
		return replies;
	}
	public void setReplies(List<String> replies) {
		this.replies = replies;
	}


	@Override
	public String toString() {
		return "Tweet [id=" + id + ", content=" + content + ", author=" + author + ", timestamp=" + timestamp
				+ ", likes=" + likes + ", retweets=" + retweets + ", replies=" + replies + "]";
	}
	
	

}
