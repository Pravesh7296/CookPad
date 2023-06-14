package com.masaischool.Sb101_Project;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
	static EntityManager getEntMn() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("masaiUnit");
		return emf.createEntityManager();
	}

    public static void main( String[] args ) {
    	getEntMn();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
        	System.out.println("Welcome to Recipe Management System");
        	System.out.println("1.Admin signUp");
        	System.out.println("2.Admin Login");
        	System.out.println("3.Customer SignUp");
        	System.out.println("4.Customer Login");
        	System.out.println("0.Exit");
        	choice = sc.nextInt();
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
