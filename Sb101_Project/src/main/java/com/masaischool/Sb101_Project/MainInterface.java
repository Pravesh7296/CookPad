package com.masaischool.Sb101_Project;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class MainInterface {
////////////////////////Admin signUp///////////////////////////////////
	static void AdminSignUp(Scanner sc) {
		  System.out.println("Enter User Name");
	      String user = sc.next();
	      System.out.println("Enter Password");
	      String password = sc.next();
	      Admin_Services.AdminSignUp(user,password); 
	}
	
      static void AdminLogin(Scanner sc) {
      System.out.println("Enter User Name");
      String user = sc.next();
      System.out.println("Enter Password");
      String password = sc.next();
      EntityManager em = App.getEntMn();
       Query que = em.createQuery("Select a from Admin_details");
       List<Admin_details> list = que.getResultList();
       for(Admin_details ad : list) {
    	  
       }
      }
///////////////////CustomerSigUp/////////////////////////////////////
      static void CustomerSigUp(Scanner sc) {
    	  try {
    		  System.out.println("Enter Customer Name");
    			  
    		  
              String user = sc.next();
              System.out.println("Enter Password");
              String password = sc.next();
               Customer_Services.signUp(user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
         
          }
/////////////////////CustomerLogin//////////////////////////////////////////
      static void CustomerLogin(Scanner sc) {
    	  try {
    		  System.out.println("Enter Customer Name");
              String user = sc.next();
              System.out.println("Enter Password");
              String password = sc.next();
               Customer_Services.signUp(user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
      }
}
