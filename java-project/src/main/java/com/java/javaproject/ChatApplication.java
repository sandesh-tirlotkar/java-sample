package com.java.javaproject;

import java.util.List;

import com.java.dto.LoginResponse;
import com.java.dto.Tweet;
import com.java.dto.UserDetail;
import com.java.service.ChatHelperService;
import com.java.service.ChatService;

public class ChatApplication {
	
	 static ChatHelperService chatHelperService= new ChatHelperService();
	 static ChatService chatService= new ChatService();
	 static LoginResponse loginResponse=new LoginResponse();

	public static void main(String[] args) {
		
		int menuChoice = 0;
		
		do {
			menuChoice = chatHelperService.mainMenu();
			
			switch (menuChoice) {
			//register
			case 1:
				UserDetail user = chatHelperService.signUpForm();
				boolean isUserSaved = chatService.registerUser(user);
				chatHelperService.signUpMessage(isUserSaved);
				break;
			
			//login
			case 2:
			    String[] loginDetails = chatHelperService.loginForm();
			    loginResponse = chatService.login(loginDetails);
			    chatHelperService.loginMessage(loginResponse);
			    System.out.println("");
			    if(loginResponse.isLogin())
			    {
			    	int loginUserChoice;
				    do {
				    	loginUserChoice = chatHelperService.loginedMenu();
					    switch (loginUserChoice)
					    {
					    	//post a tweet
							case 1: 
								Tweet createdTweet = chatHelperService.createTweet(loginResponse.getUserDetail());
								chatService.saveTweet(createdTweet,loginResponse.getUserDetail().getUsername());
								break;
							
							//login user timeline;
							case 2:
								List<Tweet> tweets = loginResponse.getUserDetail().getTweets();
								chatHelperService.showTweets(tweets);
								break;
								
								
							//search for users;
							case 3:
								List<String> userNames = chatService.getUserNames();
								String searchUserName = chatHelperService.searchUser();
								UserDetail searchedUser = chatService.searchUser(searchUserName);
								if(searchedUser == null)
								{
									System.out.println("user not found with this userName");
								}
								else {
									System.out.println("user found: "+searchedUser.getName()+"\n" + "bio--> "+searchedUser.getBio());
									loginUserChoice = chatHelperService.userOperation();
									if(loginUserChoice == 1) {
										chatService.follow(loginResponse.getUserDetail(), searchedUser);
									}
								}
								break;
								
							case 4:
								Integer tweetId = chatHelperService.inputTweetId();
								Tweet foundTweet = chatService.searchTweet(tweetId);
								if(foundTweet == null) {
									System.out.println("no tweet found with "+ tweetId + " this tweet id.");
								}
								else {
									System.out.println(foundTweet);
								}
								break;
								
							//view your profile;
							case 5:
								chatHelperService.showProfile(loginResponse.getUserDetail());
								break;
							
								
							//logout:
							case 6:
								System.out.println(loginResponse.getUserDetail().getName() + " logout successfully!!");
								loginResponse = null;
								break;
							default:
								throw new IllegalArgumentException("Unexpected value: " + loginUserChoice);
						}
					    System.out.println("");
						System.out.println("------------------------------------------------------------------------------");
						System.out.println("");
				    }
				    while(loginUserChoice != 6);
			    }
				break;
			
			//exit
			case 3:
				System.out.println("visit again!!");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + menuChoice);
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("");
			
			
		}while(menuChoice !=3);

	}

}
