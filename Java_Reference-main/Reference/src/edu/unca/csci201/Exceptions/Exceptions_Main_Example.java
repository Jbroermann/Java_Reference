package edu.unca.csci201.Exceptions;

import java.util.Scanner;

public class Exceptions_Main_Example {
	
	/**
	 * This class provides some exception examples.
	 * 
	 * Bogert talked about one common exception hierarchy
	 * which behaves as follows:
	 * There are two types of exceptions. Application exceptions and 
	 * Technical Exceptions. Both extend the base exception. 
	 * 
	 * Application exceptions can be handled by the user.
	 * These are able to deal with unexpected inputs, and things
	 * of that nature.
	 * 
	 * Technical exceptions cannot be handled by the user.
	 * Technical exceptions are typically system failures.
	 */

	public static void userInputShouldBeOne() throws BaseExceptionExample {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String userInput = scan.next();

		if (!userInput.equals("1")) {
			throw new userInputShouldBeOneException();
		}
	}
	
	public static void crashMyProgram() throws BaseExceptionExample {
		throw new crashMyProgramException();
	}
	
	public static void main(String[] args) throws BaseExceptionExample {
		
		/**Application Exception Example*/
		
		/*{
			do {
				try {
					System.out.println("Type me a 1. Do it.");
					userInputShouldBeOne();
					break;
				} catch (userInputShouldBeOneException e) {
					System.out.println("That isn't a 1.");
				}
			} while(true);
			
			System.out.println("User input was indeed 1. Well done.");
		}*/
		
		
		/**Technical Exception Example*/
		
		/*{
			crashMyProgram();
		}*/

	}

}
