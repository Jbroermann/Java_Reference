package edu.unca.csci201.Polymorphism;
/**
 * The purpose of this class is to demonstrate polymorphism.
 * @see Mammal.java
 */
public class Horse extends Mammal{

	public void eat() {
		System.out.println("hay eaten");
	}
	
	public void neigh() {
		System.out.println("Neigh");
	}
}
