package edu.unca.csci201.Polymorphism;

import java.util.Scanner;

/**
 * The purpose of this program is to demonstrate polymorphism.
 * @see Mammal.java
 * @see	Horse.java
 *
 */

public class Polymorphism_Main_Example {

	/*
	 * Polymorphism allows you to treat an object as if it were 
	 * its superclass by assigning it to a variable of the superclass type.
	 * 
	 * In doing this you lose the ability to use the 
	 * sub-class's specifics, but gain generalizability.
	 */
	
	public static void main(String[] args) {

		Horse secretariat = new Horse();
		
		Mammal m = secretariat;
		
		secretariat.eat();
		secretariat.neigh();
		
		m.eat();
		
		Mammal m2 = new Mammal();
		
		m2.eat();
		
		//To demonstrate the usefulness of this:
		//This is also called Dynamic Binding
		
		Mammal m3;
		
		Scanner scan = new Scanner(System.in);
		
		int userInput;
		
		do {
			System.out.println("Do you want to 1, eat like a horse, or 2, eat like a mammal?");
			userInput = scan.nextInt();
		} while ((userInput != 1) && (userInput != 2));
		
		
		if(userInput == 1) {
			m3 = new Horse();
			m3.eat();
		}
		if(userInput == 2) {
			m3 = new Mammal();
			m3.eat();
		}
		
		scan.close();
		
		/*
		 * In this example, it should be noted that it is possible to
		 * assign a new mammal to a horse. m, in this case. m is able to eat like a horse, but is unable to neigh.
		 * This is because the mammal eat method was overridden by the horse eat method, but
		 * the neigh method is contained only within the horse subclass, therefore it is unusable by the mammal, m.
		 * 
		 * This is, in a way, the underlying principle behind polymorphism. It allows for the subclass's
		 * unique methods to be used by their superclass.
		 * 
		 */
		
	}

}
