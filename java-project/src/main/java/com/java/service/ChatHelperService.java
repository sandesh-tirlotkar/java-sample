package com.java.service;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.java.dto.DataSource;
import com.java.dto.LoginResponse;
import com.java.dto.Tweet;
import com.java.dto.UserDetail;

public class ChatHelperService {

	DataSource dataStore = new DataSource();
	Scanner sc = new Scanner(System.in);
	
	//user select the menu and return the choice number
	public int mainMenu() {
		System.out.println("1.) Register");
		System.out.println("2.) Login");
		System.out.println("3.) Exit");
		
		System.out.println("Enter choice");
		int choice=sc.nextInt();
		
		return choice;
	}
	
	
	//singup form for new user
		public UserDetail signUpForm() {
			sc.nextLine();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			
			System.out.print("password: ");
			String password = sc.nextLine();
			
			System.out.print("username: ");
			String username=sc.nextLine();
			
			System.out.print("bio: ");
			String bio = sc.nextLine();
			
			UserDetail user = new UserDetail(name, username, password, bio);
			return user;
		}
		
		//singup message return if true or false
		public void signUpMessage(boolean isUserSaved) {
			if(isUserSaved) {
				System.out.println("User Added Successfully");
			}
			else {
				System.out.println("there some error while registring");
			}
		}
		
		//loginForm
		public String[] loginForm() {
			sc.nextLine();
			System.out.print("Enter username: ");
			String username=sc.nextLine();
			
			System.out.print("Enter password:");
			String password=sc.nextLine();
			
			String[] loginDetails = {username,password};
			return loginDetails;
		}
		
		public void loginMessage(LoginResponse loginResponse)
		{
			if(loginResponse.isLogin()) {
				System.out.println(loginResponse.getUserDetail().getName() + ", login successfully!!");
			}
			else {
				System.out.println("login failed!!");
			}
		}
		
		public int loginedMenu() {
			System.out.println("1.) post a tweet");
			System.out.println("2.) view your timeline");
			System.out.println("3.) search for users");
			System.out.println("4.) search for tweets.");
			System.out.println("5.) view your profile.");
			System.out.println("6.) logout");
			
			int choice = sc.nextInt();
			return choice;
		}
		
		//create tweet using parameter
		public Tweet createTweet(UserDetail userDetail) {
			sc.nextLine();
			System.out.println("what you'd like to tweet!!");
			String content = sc.nextLine();
			
			Integer tweetId = dataStore.generateTweetId();
			String author = userDetail.getUsername();
			Date timeStamp = new Date();
			Tweet tweet = new Tweet(String.valueOf(tweetId), content, author, timeStamp);
			System.out.println("!!! successfully tweeted !!!");
			return tweet;
		}

		public void showProfile(UserDetail user) {
			System.out.println("hello " + user.getName() + " here is your Twitter profile");
			System.out.println("userName --> "+user.getUsername());
			System.out.println("bio --> "+user.getBio());
			
			List<UserDetail> followers = user.getFollowers();
			if(followers == null || followers.size() == 0) {
				System.out.println("followers --> zero");
			}
			else {
				System.out.println("your followers:");
				for(UserDetail follower : followers) System.out.println("    "+follower);
			}
			
			List<UserDetail> followings = user.getFollowings();
			if(followings == null || followings.size() == 0) {
				System.out.println("you are not following anyone.");
			}
			else {
				System.out.println("your following:");
				for(UserDetail following : followings) System.out.println("    "+following);
			}
			
			List<Tweet> tweets = user.getTweets();
			if(tweets == null || tweets.size() == 0) System.out.println("you haven't tweet yet!!");
			else { 
				System.out.println("your Tweets :");
				for(Tweet tweet : tweets) System.out.println("    " + tweet);
			}
		}
		
		public String searchUser() {
			sc.nextLine();
			System.out.println("Enter username: ");
			String username = sc.nextLine();
			return username;
		}
		
		public int userOperation() {
			System.out.println("    1.) follow this user");
			System.out.println("    2.) main menu");
			int loginedUserChoice = sc.nextInt();
			return loginedUserChoice;
		}

		//print the iist of tweets.
		public void showTweets(List<Tweet> tweets) {
			for(Tweet tweet : tweets) System.out.println(tweet);
			
		}

		public Integer inputTweetId() {
			System.out.print("Enter Tweet id to search: ");
			Integer tweetId = sc.nextInt();
			return tweetId;
		}

}
