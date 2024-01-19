package edu.unca.csci201.Inheritance;
/**
 * This is meant to demonstrate inheritance
 * @see Animal.java
 */
public class Dog extends Animal {
	
	//This constructor can be generated using the source menu
	//Generate constructor from superclass
	public Dog(String myName, int myAge) {
		super(myName, myAge);
		// TODO Auto-generated constructor stub
	}

	public void bark() {
		System.out.println("woof");
	}
	
	
}
