package edu.unca.csci202;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * Simple Addition 2
 * @author Ben Yaniero
 * 
 *
 */
public class Simple_Addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		BigInteger val1 = scan.nextBigInteger();
		BigInteger val2 = scan.nextBigInteger();
		System.out.println(val1.add(val2));
		
	}

}
