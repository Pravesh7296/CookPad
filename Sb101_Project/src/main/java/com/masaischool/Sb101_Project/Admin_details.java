package com.masaischool.Sb101_Project;

import java.util.*;

import javax.persistence.*;


@Entity
public class Admin_details {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_Id;
    private String admin_Name;
    private  String admin_pass;
    
   @OneToMany
   private List<Recipe_details> list= new ArrayList();

   public Admin_details() {
	   
   }
public Admin_details(int admin_Id, String admin_Name, String admin_pass, List<Recipe_details> list) {
	super();
	this.admin_Id = admin_Id;
	this.admin_Name = admin_Name;
	this.admin_pass = admin_pass;
	this.list = list;
}

public String getAdmin_Name() {
	return admin_Name;
}

public void setAdmin_Name(String admin_Name) {
	this.admin_Name = admin_Name;
}

public String getAdmin_pass() {
	return admin_pass;
}

public void setAdmin_pass(String admin_pass) {
	this.admin_pass = admin_pass;
}

public List<Recipe_details> getList() {
	
	return list;
}

public void setList(List<Recipe_details> list) {
	this.list = list;
}

public int getAdmin_Id() {
	return admin_Id;
}

@Override
public String toString() {
	return " Admin_Id : " + admin_Id + " Admin_Name : " + admin_Name + " Admin_password : " + admin_pass
;			
}
   
   
     
     
}
