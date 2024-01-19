package edu.unca.csci202;

import java.util.Scanner;

/**
 * Echo Echo Echo
 * 1.3 difficulty = 0.65 pts
 * @author Ben Yaniero
 *
 */
public class Echo_Echo_Echo {

	public static void main(String[] args) {

		//System.out.println(1.3/2);
		Scanner scan = new Scanner(System.in);
		
		String echoMe = scan.nextLine();
		echoMe = echoMe + " " + echoMe + " " + echoMe;
		
		System.out.println(echoMe);
		
		
	}
	

}
