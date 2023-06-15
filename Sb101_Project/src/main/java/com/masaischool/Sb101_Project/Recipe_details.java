package com.masaischool.Sb101_Project;

import javax.persistence.*;

@Entity 
public class Recipe_details {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Recipe_Id;
private String Recipe_Name;
private String ingredients;
private String preparation;
private int Recipe_Like;

@ManyToOne
@JoinColumn(name="adminId")
private Admin_details ad;

public Recipe_details() {
	
}
public Recipe_details(int recipe_Id, String recipe_Name, String ingredients, String preparation, int Recipe_like,
		Admin_details ad) {
	super();
	Recipe_Id = recipe_Id;
	Recipe_Name = recipe_Name;
	this.ingredients = ingredients;
	this.preparation = preparation;
	this.Recipe_Like = Recipe_like;
	this.ad = ad;
}

public int getRecipe_Id() {
	return Recipe_Id;
}

public void setRecipe_Id(int recipe_Id) {
	Recipe_Id = recipe_Id;
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

public int getLike() {
	return Recipe_Like;
}

public void setLike(int like) {
	Recipe_Like = like;
}

public Admin_details getAd() {
	return ad;
}

public void setAd(Admin_details ad) {
	this.ad = ad;
}

@Override
public String toString() {
	return "Recipe_details [Recipe_Id=" + Recipe_Id + ", Recipe_Name=" + Recipe_Name + ", ingredients=" + ingredients
			+ ", preparation=" + preparation + ", Like=" + Recipe_Like + "]";
}


}
