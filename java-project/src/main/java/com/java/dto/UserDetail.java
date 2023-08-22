package com.java.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDetail {
	
	private String username;
	private String password;
	private String name;
	private String bio;
	private List<UserDetail> followings;
	private List<UserDetail> followers;
	private List<Tweet> tweets;
	
	
	public UserDetail() {
		super();
		this.followers = new ArrayList<>();
		this.followings = new ArrayList<>();
		this.tweets = new ArrayList<>();
	}

	public UserDetail(String name, String username, String password, String bio) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.bio = bio;
		this.followers = new ArrayList<>();
		this.followings = new ArrayList<>();
		this.tweets = new ArrayList<>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public List<UserDetail> getFollowings() {
		return followings;
	}
	public void setFollowings(List<UserDetail> followings) {
		this.followings = followings;
	}
	public List<UserDetail> getFollowers() {
		return followers;
	}
	public void setFollowers(List<UserDetail> followers) {
		this.followers = followers;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public void postTweet(Tweet tweet) {
		if(tweets == null) tweets = new ArrayList<>();
		tweets.add(tweet);
		
	}
	
	

}
