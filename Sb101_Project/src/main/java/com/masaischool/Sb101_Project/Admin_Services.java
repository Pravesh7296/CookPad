package com.masaischool.Sb101_Project;

import java.util.Scanner;

import javax.persistence.*;

public class Admin_Services {
////////////////////////Admin SignUp///////////////////////////////////////
	static void AdminSignUp(String user,String password) {
		EntityManager em = App.getEntMn();
		
	}
	
	
	
	
	
	
	
   static void Adminlg(Scanner sc) {
	   int choice;
	   do {
		      System.out.println("Welcome Admin and Selection");
		 	  System.out.println("1.Add new recipe");
		 	  System.out.println("2.Update recipe");
		 	  System.out.println("3.Delete recipe");
		 	  System.out.println("4.view the number of likes on each recipe");
		 	  System.out.println("5. LogOut from Admin Account");
		 	 choice=sc.nextInt();
		 	 switch(choice) {
		 	 case 1:
		 		 break;
		 	 case 2:
		 		 break;
		 	 case 3:
		 		 break;
		 	 case 4:
		 		 break;
		 	 case 5:
		 		 System.out.println("thankyou Admin");
		 		 break;
		 		 default:
		 			 System.out.println("Enter valid Selection");
		 	 }
		 	 
	   }while(choice!=5);
	 
   }
}
