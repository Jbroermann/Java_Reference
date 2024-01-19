package edu.unca.csci202;

import java.util.Scanner;

/**
 * Apaxiaaaaaaaaaaaans! 1.4
 * @author Ben Yaniero
 *
 */
public class Apaxiaaaaaaaaaaaans {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		char[] ray = str.toCharArray();
		System.out.print(ray[0]);
		for(int i = 1; i < ray.length; i++) {
			if(ray[i] != ray[i-1]) {
				System.out.print(ray[i]);
			}
		}
		
	}

}
