package p1.models;

import java.util.ArrayList;

public class Cook {
private int id;
private String name, username, password;
private ArrayList<Recipe> recipes = new ArrayList<>();


public Cook() {

}

public Cook(int id, String name, String username, String password, ArrayList<Recipe> recipes) {
	this.id = id;
	this.name = name;
	this.username = username;
	this.password = password;
	this.recipes = recipes;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public ArrayList<Recipe> getRecipes() {
	return recipes;
}

public void setRecipes(ArrayList<Recipe> recipes) {
	this.recipes = recipes;
}



}