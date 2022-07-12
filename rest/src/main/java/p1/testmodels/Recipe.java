package p1.testmodels;

public class Recipe {
private int id;
private String  name, description, ingriedients;
private double cooktime;

public Recipe() {
	super();
	this.id = 1;
	this.name = "Sample Recipe";
	this.description = "This will be some recipe";
	this.ingriedients = "Milk, eggs, etc";
	this.cooktime = 30.00;
}
public Recipe(int id, String name, String desc, String ing, double cooktime) {
	super();
	this.id = id;
	this.name = name;
	this.description = desc;
	this.ingriedients = ing;
	this.cooktime = cooktime;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIngriedients() {
	return ingriedients;
}
public void setIngriedients(String ingriedients) {
	this.ingriedients = ingriedients;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public double getCooktime() {
	return cooktime;
}
public void setCooktime(double cooktime) {
	this.cooktime = cooktime;
}



}
