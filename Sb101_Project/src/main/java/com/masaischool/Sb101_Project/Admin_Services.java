package com.masaischool.Sb101_Project;

import java.util.*;
import java.util.Scanner;

import javax.persistence.*;

public class Admin_Services {
//////////////////////////color//////////////
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_PURPLE = "\u001B[34m";
public static final String ANSI_BLUE = "\u001B[35m";
public static final String ANSI_RED = "\u001B[31m";
/////////////////////////////////////////////////////////


////////////////////////Admin SignUp///////////////////////////////////////
	static void AdminSignUp(String user,String password) {
		EntityManager em = App.getEntMn();
		EntityTransaction ts=em.getTransaction();
		
		try {
		    Query que =em.createQuery("Select a from Admin_details a");
		   int count=0;
		  List<Admin_details> add = que.getResultList();
			for(Admin_details ad : add) {
				if(ad.getAdmin_Name().equals(user)) {
					count++;
				}
			}
			if(count==1) {
				System.out.println(ANSI_YELLOW+user+ANSI_BLUE+"  You already Registered please Login"+ANSI_RESET);
			}else {
				Admin_details ad = new Admin_details();
				ad.setAdmin_Name(user);
				ad.setAdmin_pass(password);
				ts.begin();
				em.persist(ad);
				ts.commit();
				System.out.println(ANSI_BLUE+"Thankyou " +ANSI_YELLOW+user+ANSI_BLUE+ " For SignUp"+ANSI_RESET);
			}
			
		} catch (Exception e) {
			System.out.println(ANSI_RED+e.getMessage());
		}finally {
			em.close();
		}
		
		
		
	}
//////////////////////////////AdminLogin/////////////////////////////////////	

   static void AdminLogIn(String user,String password) {
	   EntityManager em = App.getEntMn();
	   EntityTransaction ts = em.getTransaction();
	 
	   try {
		   ts.begin();
		   Query que = em.createQuery("Select a from Admin_details a where admin_Name=:adname");
		   que.setParameter("adname",user);
	       Admin_details ad = (Admin_details) que.getSingleResult();
	       if(ad.getAdmin_Name().equals(user) && ad.getAdmin_pass().equals(password)) {
	    	  System.out.println(ANSI_BLUE+"Login Successfully"+ANSI_RESET); 
	    	  AdminFun(user,ad.getAdmin_Id());
	       }else {
	    	   System.out.println(ANSI_RED+"Enter Right Details"+ANSI_RESET);
	       }
	       
	       ts.commit();
	} catch (Exception e) {
		System.out.println(ANSI_RED+"Admin Not Found"+ANSI_RESET);
	}finally {
		em.close();
	}
     
   }   
///////////////////////////////////Admin's Function///////////////////////////
   static void AdminFun(String name,int User_Id) {
         Scanner sc = new Scanner(System.in);
	   int choice;
	   do {
     System.out.println(ANSI_BLUE+" ---------------------------");
		      System.out.println(" |   Welcome : "+ANSI_YELLOW+name+ANSI_BLUE+"      |");
		       System.out.println(" ---------------------------"+ANSI_RESET);
		 	  System.out.println(ANSI_YELLOW+"ENTER : 1 FOR Add new recipe");
		 	  System.out.println("ENTER : 2 FOR Update recipe");
		 	  System.out.println("ENTER : 3 FOR Delete recipe");
		 	  System.out.println("ENTER : 4 FOR View Recipe_Name and their Likes");
		 	  System.out.println("ENTER : 0 FOR LogOut from Admin Account"+ANSI_RESET);
		 	 choice=sc.nextInt();
		 	 sc.nextLine();
		 	 switch(choice) {
		 	 case 1:
		 		 AddNewRecipe(sc,User_Id);
		 		 break;
		 	 case 2:
		 		 UpdateRecipe(sc);
		 		 break;
		 	 case 3:
		 		 DeleteRecipe(sc);
		 		 break;
		 	 case 4:
		 		 ViewLikes(sc,User_Id);
		 		 break;
		 	 case 0:
		 		 System.out.println(ANSI_BLUE+"thankyou Admin"+ANSI_RESET);
		 		 break;
		 		 default:
		 			 System.out.println(ANSI_RED+"Enter valid Selection"+ANSI_RESET);
		 	 }
		 	 
	   }while(choice!=0);
	 
   }
/////////////////////////////AddNewRecipe/////////////////////////////////////
   static void AddNewRecipe(Scanner sc,int User_Id) {
	 EntityManager em = App.getEntMn();
	 EntityTransaction ts  = em.getTransaction();
	 
    System.out.println(ANSI_BLUE+"Enter RecipeName"+ANSI_RESET);
    String Recipe_name = sc.next();
    sc.nextLine();
    
    System.out.println(ANSI_BLUE+"Enter Recipe Ingredients"+ANSI_RESET);
     String ingredients = sc.nextLine();
     System.out.println(ANSI_BLUE+"Enter Recipe steps"+ANSI_RESET);
    String preparation = sc.nextLine();

  
    
    try {
    	  
    	    
		ts.begin();
		Recipe_details rd = new Recipe_details();
	    rd.setRecipe_Name(Recipe_name);
	    rd.setIngredients(ingredients);
	    rd.setPreparation(preparation);
	    em.persist(rd);
	    
	    Admin_details ad = em.find(Admin_details.class,User_Id);
	    
	    List<Recipe_details> ls = ad.getList();
	    ls.add(rd);
	    ad.setList(ls);
	    
		em.persist(ad);
		rd.setAd(ad);
		em.persist(rd);
		ts.commit();
		System.out.println(ANSI_BLUE+"Recipe_added"+ANSI_RESET);
	} catch (Exception e) {
		System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
	}finally {
		em.close();
	}
   }  
////////////////////////UpdateRecipe////////////////////////////////////////
   static void UpdateRecipe(Scanner sc){
		 EntityManager em = App.getEntMn();
		 EntityTransaction ts  = em.getTransaction();
		 
	    System.out.println(ANSI_BLUE+"Enter Recipe_Id"+ANSI_RESET);
	      int Recipe_Id = sc.nextInt();
	      sc.nextLine();
	      Query que = em.createQuery("Select r from Recipe_details r where Recipe_Id=:rId");
		    que.setParameter("rId",Recipe_Id);
		    Recipe_details rd = (Recipe_details) que.getSingleResult();
	  
		System.out.println(ANSI_YELLOW+"ENTER : 1 FOR Update Name");
	    System.out.println("ENTER : 2 FOR Update Ingridents"); 
	    System.out.println("ENTER : 3 FOR Update Steps"+ANSI_RESET); 
	    int ch;
	    try {
	    	 ch = sc.nextInt();
		} catch (Exception e) {
		     ch=5;
		     
		}
	    
	   sc.nextLine();
	    if(ch==1){
	    	System.out.println(ANSI_BLUE+"Enter New Name"+ANSI_RESET); 
	    	String name = sc.next();
	    	rd.setRecipe_Name(name);
	    }else if(ch==2) {
	    	System.out.println(ANSI_BLUE+"Enter New Ingridents"+ANSI_RESET); 
	    	String ing = sc.nextLine();
	    	rd.setIngredients(ing);
	    }else if (ch==3) {
	    	System.out.println(ANSI_BLUE+"Enter Steps"+ANSI_RESET); 
	    	String step = sc.nextLine();
	    	rd.setPreparation(step);
	    }else {
	      System.out.println(ANSI_RED+"Enter right Selection"+ANSI_RESET);
	    }
	    
	    try {
			ts.begin();
			em.persist(rd);
			ts.commit();
			System.out.println(ANSI_BLUE+"updated successfully"+ANSI_RESET);
		} catch (Exception e) {
			System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
		}finally {
			em.close();
		}
   }
////////////////////////Delete Recipe////////////////////////////////////////
   static void DeleteRecipe(Scanner sc){
		 EntityManager em = App.getEntMn();
		 EntityTransaction ts  = em.getTransaction();
		 
	    System.out.println(ANSI_BLUE+"Enter Recipe_Id"+ANSI_RESET);
	      int Recipe_Id = sc.nextInt();
	      sc.nextLine();
	      try {
	    	  ts.begin();
	    	  Query que = em.createNativeQuery("Delete from Admin_details_Recipe_details where List_Recipe_Id=:rId");
			  que.setParameter("rId",Recipe_Id);
			  
	    	  Query qu = em.createNativeQuery("Delete from Recipe_details where Recipe_Id=:rId");
			  qu.setParameter("rId",Recipe_Id);

			  if(que.executeUpdate()>0 && qu.executeUpdate()>0) {
				  System.out.println(ANSI_RED+"Recipe Deleted"+ANSI_RESET);
			  }else {
				  System.out.println(ANSI_RED+"somethingWent wrong"+ANSI_RESET);
			  }
			  ts.commit();
		      
		} catch (Exception e) {
		    System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
		}finally {
			em.close();
		}
   }      
////////////////////////////VeiwLikes////////////////////////////////////////
   static void ViewLikes(Scanner sc,int User_Id){
		 EntityManager em = App.getEntMn();
		 EntityTransaction ts  = em.getTransaction();
	
	      try {
	    	  ts.begin();
	    	  Query que = em.createQuery("Select r from Recipe_details r where adminId=:id");
			  que.setParameter("id",User_Id);
			  List<Recipe_details> ls = que.getResultList();
			  if(ls.size()==0) {
				  System.out.println(ANSI_RED+"Not Found ! "+ANSI_BLUE+"(please Add Recipes)"+ANSI_RESET);
			  }else {
			  for(Recipe_details rd : ls) {
				  System.err.println(ANSI_GREEN+"Recipe_Id : "+ANSI_YELLOW+rd.getRecipe_Id()+ANSI_GREEN+" Recipe_Name  : "+ANSI_YELLOW+rd.getRecipe_Name()+ANSI_GREEN+"  No. of Likes : "+ANSI_RED+rd.getLike()+ANSI_RESET);
			  }
			  }
			  ts.commit();
		      
		} catch (Exception e) {
		    System.out.println(ANSI_RED+e.getMessage()+ANSI_RESET);
		}finally {
			em.close();
		}
 }      
}
