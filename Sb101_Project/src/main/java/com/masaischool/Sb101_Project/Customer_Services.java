package com.masaischool.Sb101_Project;

import java.util.*;



import javax.persistence.*;


public class Customer_Services {
//////////////////////////color//////////////
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_PURPLE = "\u001B[34m";
public static final String ANSI_BLUE = "\u001B[35m";
public static final String ANSI_RED = "\u001B[31m";
/////////////////////////////////////////////////////////

	
////////////////////////////Cusomer SignUp////////////////////////////////
         static void signUp(String cus_name,String cus_pass) {
        	 EntityManager em = App.getEntMn();
        	 EntityTransaction ts = em.getTransaction();
        	 
        try {
            Query que =em.createQuery("Select a from Customer_details a");
 		   int count=0;
 		  List<Customer_details> add = que.getResultList();
 			for(Customer_details ad : add) {
 				if(ad.getCustomer_Name().equals(cus_name)) {
 					count++;
 				}
 			}
 			if(count==1) {
 				System.out.println(ANSI_YELLOW+cus_name+ANSI_BLUE+"  You already Registered please Login"+ANSI_RESET);
 			}else {
 				Customer_details ad = new Customer_details();
 				ad.setCustomer_Name(cus_name);
 				ad.setCustomer_Pass(cus_pass);;
 				ts.begin();
 				em.persist(ad);
 				ts.commit();
 				System.out.println(ANSI_BLUE+"Thanks " +ANSI_YELLOW+cus_name+ ANSI_BLUE+" For SignUp"+ANSI_RESET);
 			}
        	
        
		} catch (Exception e) {
			System.out.println(ANSI_RED+e.getLocalizedMessage()+ANSI_RESET);
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
    	   System.out.println(ANSI_BLUE+"Login Successfully"+ANSI_RESET);
    	   Cus_Role(cus_name);
       }else {
    	   System.out.println(ANSI_RED+"Enter right credentials"+ANSI_RESET);
       }
			
		} catch (Exception e) {
			System.out.println(ANSI_RED+" Customer Not Found !"+ANSI_RESET);
		}finally {
			em.close();
		}
}
///////////////////////////Customer Role///////////////////////////////////
         static void Cus_Role(String name) {
        	 Scanner sc = new Scanner(System.in);
             int choice;
             do {
            	 try {
            		    System.out.println(ANSI_BLUE+"-------------------------");
            		    System.out.println("|  Welcome "+ANSI_YELLOW+name+ANSI_BLUE+"      |");
            			System.out.println("-------------------------");
                     	System.out.println(ANSI_YELLOW+"ENTER : 1 FOR View All Recipes");
                     	System.out.println("ENTER : 2 FOR Filter Recipes");
                     	System.out.println("ENTER : 3 FOR like Recipes");
                     	System.out.println("ENTER : 0 FOR Exit"+ANSI_RESET);
                     	choice = sc.nextInt();
				} catch (Exception e) {
					choice=0;
					System.out.println(ANSI_RED+"Enter valid Input"+ANSI_RESET);
				}
             
             	switch(choice) {
             	case 1:
                     ViewRe(); 
             		break;
             	case 2:
             		filterRe(sc);
             		break;
            	case 3:
             		LikeRecipe(sc);
             		break;
             	case 0:
             		System.out.println(ANSI_BLUE+"Thankyou"+ANSI_RESET);
             		break;
             		default:
             			System.out.println(ANSI_RED+"sorry Enter valid Selection"+ANSI_RESET);
             	}
             	
             }while(choice!=0);
         }
/////////////////////////////////View All Recieps ///////////////////////
         static void ViewRe() {
        	EntityManager em = App.getEntMn();
        	Query que = em.createQuery("Select r from Recipe_details r");
        	
        	List<Recipe_details> list = que.getResultList();
        	if(list.size()==0) {
        		System.out.println(ANSI_RED+"Sorry No Recipes available"+ANSI_RESET);
        	}else {
            for(Recipe_details ad : list) {
            	System.out.println(ad);
            }
        	}		
         }
//////////////////////////Filter Recipe//////////////////////////////////////
         static void filterRe(Scanner sc) {
        	 System.out.println(ANSI_BLUE+"Enter ingredient Name"+ANSI_RESET);
        	 String name = sc.next();
        	 EntityManager em = App.getEntMn();
        	 EntityTransaction ts = em.getTransaction();
        	 Query que = em.createQuery("Select r from Recipe_details r");
             
             
  List<Recipe_details> list = que.getResultList();
  for(Recipe_details rd : list) {
	  if(rd.getIngredients().contains(name)) {
		  System.out.println(rd);
	  }
  }
         }  
////////////////////////////Like_Recipe//////////////////////////////////////
         static void LikeRecipe(Scanner sc) {
        	 System.out.println(ANSI_BLUE+"Enter Recipe_Id"+ANSI_RESET);
        	 int r_Id= sc.nextInt();
        	 sc.nextLine();
        	 EntityManager em = App.getEntMn();
        	 EntityTransaction ts = em.getTransaction();
        	 Query que = em.createQuery("Select r from Recipe_details r where Recipe_Id=:id");
             que.setParameter("id",r_Id);
             
             
               Recipe_details rd = (Recipe_details) que.getSingleResult();
               rd.setLike(rd.getLike()+1);
               try {
				ts.begin();
				em.persist(rd);
				ts.commit();
				System.out.println(ANSI_YELLOW+"thank you for like"+ANSI_RESET);
			} catch (Exception e) {
				System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
			}finally {
				em.close();
			}
  
  } 
         
}


