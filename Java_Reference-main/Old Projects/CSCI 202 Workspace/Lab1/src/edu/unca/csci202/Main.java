package edu.unca.csci202;

import java.util.Scanner;
public class Main {
	
	public static int inPrompt(int i, Scanner scan) {
		String userInput = null;
		int integerInput = -99999; //Ugly number for sanity check.
		boolean valid = false;
		while (!valid) {
			System.out.print("Enter integer " + i + ": ");
			userInput = scan.nextLine();
			try {
				integerInput = Integer.parseInt(userInput);
				//System.out.println(integerInput); //for debug
			}
			catch (NumberFormatException exception) {
				System.out.println("Invalid integer.");
				continue;
				/*
				 * This continue skips the current loop iteration to avoid
				 * a false positive when an exception is thrown.
				 */
			}
			valid = true;
		}
		return integerInput;
	}
	
	public static double average(int[] list) {
		double sum = 0;
		for(int i = 0; i < list.length; i++){
			sum += list[i];
			}
		return sum/(list.length);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i;
		int userList[] = new int[10];
		for (i = 1; i <= 10; i++) {
			userList[i-1] = inPrompt(i, scan);
			//System.out.println(userList[i-1]); //For debug
		}
		System.out.print("The numbers are: ");
		for (i = 0; i <= 8; i++) {
			System.out.print(userList[i] + ", ");
		}
		System.out.print(userList[9]);
		System.out.println();
		System.out.print("The average is: ");
		System.out.println(average(userList));
		
		scan.close();
	}

}
