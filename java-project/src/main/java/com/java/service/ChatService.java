package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.dto.LoginResponse;
import com.java.dto.Tweet;
import com.java.dto.UserDetail;

public class ChatService {
	
	private Map<String, UserDetail> users;
	private List<Tweet> tweets;
	
	public ChatService() {
		this.tweets = new ArrayList<>();
		this.users = new HashMap<>();
	}
	
	
	public boolean registerUser(UserDetail user) {
		String username = user.getUsername();
		if(!users.containsKey(username)) {
			users.put(username, user);
			return true;
		}
		else return false;
	}
	
	
	public LoginResponse login(String[] loginDetail) {
		String username = loginDetail[0];
		String password = loginDetail[1];
		LoginResponse loginResponse = new LoginResponse();
		
		if(users.containsKey(username)) {
			UserDetail user = users.get(username);
			if(user.getPassword().equals(password)) {
				loginResponse.setUserDetail(user);
				loginResponse.setLogin(true);
			}
			else loginResponse.setLogin(false);
		}
		else {
			loginResponse.setLogin(false);
		}
		return loginResponse;
	}
	
	
	public void saveTweet(Tweet tweet, String username) {
		UserDetail user = users.get(username);
		user.postTweet(tweet);
		tweets.add(tweet);
	}
	
	
	public List<String> getUserNames(){
		List<String> userNames = new ArrayList<String>(users.keySet());
		return userNames;
	}
	
	
	public UserDetail searchUser(String username) {
		if(users.containsKey(username)) {
			return users.get(username);
		}
		else return null;
	}
	
	
	public void follow(UserDetail loginUser, UserDetail followedUser) {
		UserDetail userDetail = users.get(loginUser.getUsername());
		userDetail.getFollowings().add(followedUser);
		users.put(loginUser.getUsername(), userDetail);
		
	    UserDetail userDetail2 = users.get(followedUser.getUsername());
	    userDetail2.getFollowers().add(userDetail2);
	    users.put(followedUser.getUsername(), userDetail2);
	}
	
	
	public Tweet searchTweet(Integer tweetId) {
		for(Tweet tweet : tweets)
		{
			if(tweet.getId().equals(tweetId)) {
				return tweet;
			}
		}
		return null;
	}

}
