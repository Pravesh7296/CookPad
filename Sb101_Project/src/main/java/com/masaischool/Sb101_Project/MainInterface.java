package com.masaischool.Sb101_Project;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class MainInterface {
//////////////////////////color//////////////
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_PURPLE = "\u001B[34m";
public static final String ANSI_BLUE = "\u001B[35m";
public static final String ANSI_RED = "\u001B[31m";
/////////////////////////////////////////////////////////


////////////////////////Admin signUp///////////////////////////////////
	static void AdminSignUp(Scanner sc) {
		  System.out.println(ANSI_GREEN+"Enter User Name"+ANSI_RESET);
	      String user = sc.next();
	      System.out.println(ANSI_GREEN+"Enter Password"+ANSI_RESET);
	      String password = sc.next();
	      Admin_Services.AdminSignUp(user,password); 
	}
////////////////////////////AdminLogin/////////////////////////////////////	
      static void AdminLogin(Scanner sc) {
      System.out.println(ANSI_GREEN+"Enter User Name"+ANSI_RESET);
      String user = sc.next();
      System.out.println(ANSI_GREEN+"Enter Password"+ANSI_RESET);
      String password = sc.next();
      Admin_Services.AdminLogIn(user,password);
      }
///////////////////CustomerSigUp/////////////////////////////////////
      static void CustomerSigUp(Scanner sc) {
    	  try {
    		  System.out.println(ANSI_GREEN+"Enter Customer Name"+ANSI_RESET);
    			  
    		  
              String user = sc.next();
              System.out.println(ANSI_GREEN+"Enter Password"+ANSI_RESET);
              String password = sc.next();
               Customer_Services.signUp(user, password);
		} catch (Exception e) {
			System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
		}
         
          }
/////////////////////CustomerLogin//////////////////////////////////////////
      static void CustomerLogin(Scanner sc) {
    	  try {
    		  System.out.println(ANSI_GREEN+"Enter Customer Name"+ANSI_RESET);
              String user = sc.next();
              System.out.println(ANSI_GREEN+"Enter Password"+ANSI_RESET);
              String password = sc.next();
               Customer_Services.logIn(user, password);
		} catch (Exception e) {
			System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
		}
      }
}
