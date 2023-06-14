package com.masaischool.Sb101_Project;

import java.util.*;


import javax.persistence.*;


public class Customer_Services {
	
////////////////////////////Cusomer SignUp////////////////////////////////
         static void signUp(String cus_name,String cus_pass) {
        	 EntityManager em = App.getEntMn();
        	 EntityTransaction ts = em.getTransaction();
        	 Customer_details cd = new Customer_details();
        	 cd.setCustomer_Name(cus_name);
        	 cd.setCustomer_Pass(cus_pass);
        try {
        	ts.begin();
        	em.persist(cd);
        	ts.commit();
            System.out.println("SignUp Successfully");
            
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}finally {
			em.close();
		}
    }	
   
////////////////////////////////Customer Login///////////////////////////         
         static void logIn(String cus_name,String cus_pass) {
        	 EntityManager em = App.getEntMn();
        	 EntityTransaction ts = em.getTransaction();
        	
        try {
        	ts.begin();
       Query que = em.createQuery("Select c from Customer_details c where Customer_Name=:cName and Customer_Pass=:cPass");
       que.setParameter("cName",cus_name);
       que.setParameter("cPass",cus_pass);
            
       Customer_details cd = (Customer_details) que.getSingleResult();
       if(cd.getCustomer_Name().equals(cus_name) && cd.getCustomer_Pass().equals(cus_pass)) {
    	   System.out.println("Login Successfully");
    	   Cus_Role(cus_name);
       }else {
    	   System.out.println("Eneter right credentials");
       }
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}finally {
			em.close();
		}
}
///////////////////////////Customer Role///////////////////////////////////
         static void Cus_Role(String name) {
        	 Scanner sc = new Scanner(System.in);
             int choice;
             do {
             	System.out.println("Welcome "+name);
             	System.out.println("1.View All Recipes");
             	System.out.println("2.Filter Recipes");
             	System.out.println("0.Exit");
             	choice = sc.nextInt();
             	switch(choice) {
             	case 1:
                     ViewRe(); 
             		break;
             	case 2:
             		filterRe();
             		break;
             
             	case 0:
             		System.out.println("Thankyou");
             		break;
             		default:
             			System.out.println("sorry Enter valid Selection");
             	}
             	
             }while(choice!=0);
         }
/////////////////////////////////View All Recieps ///////////////////////
         static void ViewRe() {
        	EntityManager em = App.getEntMn();
        	Query que = em.createQuery("Select r from Admin_details r");
        	
        	List<Recipe_details> list = que.getResultList();
            for(Recipe_details ad : list) {
            	System.out.println(ad);
            }
        			
         }
//////////////////////////Filter Recipe//////////////////////////////////////
         static void filterRe() {
        	 System.out.println("Enter ingredients");
         }
  
         
}

