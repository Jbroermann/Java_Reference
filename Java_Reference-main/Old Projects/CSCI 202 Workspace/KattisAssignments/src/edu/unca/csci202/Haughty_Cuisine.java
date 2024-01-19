package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

/**
 * Haughty Cuisine 1.7
 * @author Ben Yaniero
 *
 */
public class Haughty_Cuisine {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		// 1 <= n <= 100 number of set menu items
		// 1 <= d <= 42 number of dishes, followed by list of the dishes
		// repeat #2 a n times
		
		int n = scan.nextInt();
		
		
		int m = rand.nextInt(n)+1;
		
		//System.out.println(m);
		
		for(int i = 0; i < m-1; i++) {
			scan.nextLine();
		}
		m = scan.nextInt();
		System.out.println(m);
		for(int i = 0; i < m; i++) {
			System.out.println(scan.next());
		}
		
	}
	
	
}
