package com.java.javaproject;

import java.util.Scanner;

import com.java.service.LibraryService;

public class Library {
	
	public static void main(String[] args) {
		String title="";
		String author="";
		String patron="";
		
		LibraryService services = new LibraryService();
		
		int choice = -1;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. Add Patron");
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book");
			System.out.println("5. Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			//add book
			case 1:
				sc.nextLine();
				System.out.println("Enter Title : ");
				title = sc.nextLine();
				
				System.out.println("Enter Author : ");
				author = sc.nextLine();
				
				services.addBook(title, author);
				break;
				
			//add patron
			case 2:
				sc.nextLine();
				System.out.println("Enter Patron Name : ");
				patron = sc.nextLine();
				services.addPatron(patron);
				break;
				
			//borrow book
			case 3:
				sc.nextLine();
				System.out.println("Enter Patron Name : ");
				patron = sc.nextLine();
				
				System.out.println("Enter Book Title : ");
				title = sc.nextLine();
				services.borrowBook(patron, title);
				break;
			
			//return book
			case 4:
				sc.nextLine();
				System.out.println("Enter Patron Name : ");
				patron = sc.nextLine();
				System.out.println("Enter Book Title : ");
				title = sc.nextLine();
				services.returnBook(patron, title);
				break;
			
			//exit
			case 5:
				sc.close();
				System.out.println("Thanks, Visit Again!!");
				break;
				
			default:
				choice = -1;
			}
		}
		while(choice!=5);
	
	}

}
