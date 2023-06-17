package com.masaischool.Sb101_Project;

import java.util.*;


import javax.persistence.*;



public class App {
	//////////////////////////color//////////////
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[34m";
	public static final String ANSI_BLUE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
/////////////////////////////////////////////////////////
	
	static EntityManager getEntMn() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("masaiUnit");
		return emf.createEntityManager();
	}

    public static void main( String[] args ) {
    	getEntMn();
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do {
        	try {
        		System.out.println(ANSI_PURPLE+"************************");
        		            System.out.println("* Welcome to CookPad   *");
        		            System.out.println("************************");
            	System.out.println(ANSI_YELLOW+"ENTER : 1 For Admin signUp");
            	System.out.println("ENTER : 2 For Admin Login");
            	System.out.println("ENTER : 3 For Customer SignUp");
            	System.out.println("ENTER : 4 For Customer Login");
            	System.out.println("ENTER : 0 For Exit");
            	choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Enter right Input");
				
			}finally {
				
			}
        	
        	
        	
        	switch(choice) {
        	case 1:
        		MainInterface.AdminSignUp(sc);
        		break;
        	case 2:
        	MainInterface.AdminLogin(sc);
        		break;
        	case 3:
        		MainInterface.CustomerSigUp(sc);
        		break;
        	case 4:
        		MainInterface.CustomerLogin(sc);
        		break;
        	case 0:
        		System.out.println("Thankyou for Testing");
        		break;
        		default:
        			System.out.println("sorry Enter valid Selection");
        	}
        	
        }while(choice!=0);
    }
}
