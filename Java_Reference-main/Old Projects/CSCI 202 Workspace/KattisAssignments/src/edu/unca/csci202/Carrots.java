package edu.unca.csci202;

import java.util.Scanner;

public class Carrots {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int P = scan.nextInt();
		scan.nextLine();
		while (N > 0) {
			scan.nextLine();
			N--;
		}
		
		System.out.println(P);
		
	}

}
