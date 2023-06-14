package com.masaischool.Sb101_Project;

import javax.persistence.*;

@Entity
public class Customer_details {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int Customer_id;
      private String Customer_Name;
      private String Customer_Pass;
      public Customer_details() {
    	  
      }
	public Customer_details(int customer_id, String Customer_Name,String customer_Pass) {
		super();
		this.Customer_Name= Customer_Name;
		Customer_id = customer_id;
		Customer_Pass = customer_Pass;
	}
	public String getCustomer_Pass() {
		return Customer_Pass;
	}
	public void setCustomer_Pass(String customer_Pass) {
		Customer_Pass = customer_Pass;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	@Override
	public String toString() {
		return "Customer_details [Customer_id=" + Customer_id + ", Customer_Name=" + Customer_Name + ", Customer_Pass="
				+ Customer_Pass + "]";
	}
	
      
}
