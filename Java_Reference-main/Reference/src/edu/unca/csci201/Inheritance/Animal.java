package edu.unca.csci201.Inheritance;
/**
 * This is meant to demonstrate inheritance
 * @see Dog.java
 */
public class Animal{
	
	//Instance variables
	//These describe the state of an object.
	private String name;
	private int age;

	//This is a constructor which initializes the instance variables of an object.
	//This can be generated from the source menu
	public Animal(String myName, int myAge) {
		//"this" denotes this specific object
		this.name = myName;
		this.age = myAge;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//These are getters and setters
	//They can be generated from the Source menu.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Extends object (all classes extend this)
	//These are the three methods that Bogert talked about
	//Overriding/Implementing methods can be done in the Source menu
	
	//Returns a representation of this object.
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return name;
	}

	//Used to compare objects
	//Not really sure how to use this.
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//return super.equals(obj);
		return false;
	}
	
	//Creates an exact copy(clone) of this object
	//Not really sure how to use this.
	@Override
	protected Object clone() /*throws CloneNotSupportedException*/ {
		// TODO Auto-generated method stub
		//return super.clone();
		return new Animal(name, age);
	}

	


	
	


	
	
	
	
	
	
}
