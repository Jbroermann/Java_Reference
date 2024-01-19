package edu.unca.csci201;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import edu.unca.csci201.Inheritance.Dog;

//This is Ben's super fancy reference document :)

		/* Some quiz stuff that might be helpful.
		 * 
		 * Java is commonly compiled into Byte code.
		 * 
		 * An interpreter executes a program one command at a time.
		 * 
		 * A computer's processor executes machine code.
		 * 
		 * A compiler translates code from one language to another.
		 * 
		 * A stream must be closed when you are done using it because the system
		 * may not finish writing everything in it before the program ends.
		 * 
		 * System.out is the stream used to output to the console.
		 * 
		 * The series of streams needed to write to a file is:
		 * FileWriter -> BufferedWriter -> PrintWriter
		 * 
		 * Java's mechanism for receiving input into a program is the scanner.
		 * 
		 * The minimum number a float can store is 1.17594 * 10^-38.
		 * 
		 * The normal scope of a variable is the point it is defined to the end of the block it was defined in.
		 * 
		 * After a variable goes out of scope it is no longer accessible.
		 * 
		 * 
		 * 
		 * 3 Things that make up object oriented programming:
		 * Inheritance: A way for classes to share code.
		 * Think dog extends Animal (example Classes created)
		 * 
		 * Polymorphism: This is the difficult one to explain...
		 * Polymorphism means "having many forms" In this case, it means
		 * a reference variable that can refer to different types of
		 * objects at different points in time.
		 * The specific method invoked through a polymorphic
		 * reference can change from one invocation to the next.
		 * 
		 * 
		 * Encapsulation:
		 * 
		 * 
		 * Exceptions: Exceptions represent problems or unusual situations 
		 * that may occur in a program. 
		 * 
		 */

public class Reference {
	
	public static void main(String[] args) throws IOException, FileNotFoundException  {
		
		/**
		 * 
		 * Uncomment Blocks As Desired
		 * 
		 */
		
		
		/**File Writing*/
		
		/*{
			//Be sure to organize imports (Ctrl+Shift+O) and add throws declaration for IOException
			FileWriter fw = new FileWriter("myfile.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter myOutput = new PrintWriter(bw);
			
			myOutput.println("I'm file output");
			
			//Be sure to close the file.
			myOutput.close();
		}*/
		
		/**Basic Input*/
		
		/*{
			System.out.println("Type something.");
			//Be sure to organize imports
			Scanner scan = new Scanner(System.in);
			//Example echo program
			
			String echo = scan.nextLine();
			System.out.println("You typed: "+ echo);
			
		}*/
		
		/**File Input*/
		
		/*{
			//Remember to organize inputs
			//Remember to throw FileNotFoundException
			Scanner scanFile = new Scanner(new FileReader("ExampleInput.txt"));
			String fileContent = scanFile.nextLine();
			System.out.println("What is contained in ExampleInput.txt: " + fileContent);
		}*/
		
		/**Loops*/
		
		/*{
			int i = 0;
			
			//While Loop
			while (i <= 9) {
				System.out.print(i);
				i++;
			}
			
			i = 0;
			System.out.println();
			
			//Do While Loop
			//Do whiles will always run once regardless of loop condition.
			do {
				System.out.print(i);
				i++;
			} while (i <= 9);
			
			System.out.println();
			
			//For Loop
			for (i = 0; i <= 9; i++) {
				System.out.print(i);
			}
			
		}*/
		
		/**Arrays*/
		
		/*{
			//one way to create an array
			int myArray [] = new int[6];
			for(int i = 0; i <= 5; i++) {
				myArray[i]  = i;
			}
			
			//another way to create an array
			int anotherArray [] = {0,1,2,3,4,5};
			
			for(int i = 0; i <= 5; i++) {
				System.out.print(myArray[i]);
			}
			System.out.println();
			
			//Using array.length
			for(int i = 0; i < anotherArray.length; i++) {
				System.out.print(anotherArray[i]);
			}
			System.out.println();
			
			//For each loop
			//This is a mysterious loop...its only really good for printing arrays out
			for(int i : myArray) {
				System.out.print(i);
			}
			
		}*/
		
		/**Basic Methods*/

		/*{
			exampleMethod();
			System.out.println(exampleMethod2("a very fancy methody return valuey string"));
		}*/
		
		/**Inheritance
		 * @see Animal.java
		 * @see Dog.java
		 */
		
		/*{
			Dog woofer = new Dog("Woofer", 3);
			
			System.out.println(woofer);
			
			woofer.bark();
			
			System.out.println(woofer.getAge());
			
			woofer.setAge(4);
			System.out.println(woofer.getAge());
			
		}*/
		
		/**Polymorphism (see the Polymorphism package)*/
		
		/**Exceptions (see the Exceptions package)*/
		
		
		

	}
	
	//Example method
	public static void exampleMethod() {
		System.out.println("a very nice methody string");
	}
	//Example method with return value
	public static String exampleMethod2(String myString) {
		return myString;
	}

}
