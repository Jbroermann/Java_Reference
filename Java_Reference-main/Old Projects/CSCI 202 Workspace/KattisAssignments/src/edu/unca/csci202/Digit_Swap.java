package edu.unca.csci202;

import java.util.Scanner;

/**
 * Digit Swap 1.3
 * @author Ben Yaniero
 *
 */
public class Digit_Swap {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		char[] ray = str.toCharArray();
		int digitA = Character.getNumericValue(ray[0]);
		int digitB = Character.getNumericValue(ray[1]);
		
		System.out.println(digitB+""+digitA);
		
	}

}
