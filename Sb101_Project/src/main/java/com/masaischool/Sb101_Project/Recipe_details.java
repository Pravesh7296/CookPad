package com.masaischool.Sb101_Project;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recipe_details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int Recipe_Id;
   private String Recipe_Name;
   private String ingredients;
   private String preparation;
   

   public Recipe_details() {
	   
   }
public Recipe_details(int recipe_Id, String recipe_Name, String ingredients, String preparation) {
		
	super();
	Recipe_Id = recipe_Id;
	Recipe_Name = recipe_Name;
	this.ingredients = ingredients;
	this.preparation = preparation;
	
}

public String getRecipe_Name() {
	return Recipe_Name;
}
public void setRecipe_Name(String recipe_Name) {
	Recipe_Name = recipe_Name;
}
public String getIngredients() {
	return ingredients;
}
public void setIngredients(String ingredients) {
	this.ingredients = ingredients;
}
public String getPreparation() {
	return preparation;
}
public void setPreparation(String preparation) {
	this.preparation = preparation;
}


public int getRecipe_Id() {
	return Recipe_Id;
}
@Override
public String toString() {
	return "Recipe_details [Recipe_Id=" + Recipe_Id + ", Recipe_Name=" + Recipe_Name + ", ingredients=" + ingredients
			+ ", preparation=" + preparation + "]";
}


   
}
