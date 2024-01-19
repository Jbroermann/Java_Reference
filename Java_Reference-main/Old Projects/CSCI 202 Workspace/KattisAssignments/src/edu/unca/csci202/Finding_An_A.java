package edu.unca.csci202;

import java.util.Scanner;
/**
 * Finding An A 1.3
 * @author Ben Yaniero
 *
 */
public class Finding_An_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		char[] ray = str.toCharArray();
		int i = 0;
		while(ray[i] != 'a') {
			i++;
		}
		for(;i<ray.length;i++) {
			System.out.print(ray[i]);
		}
		

	}

}
