package edu.unca.csci202;

import java.util.Scanner;

public class Bijele {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		// input format
		// x x x x x x
		// [kings] [queens] [rooks] [bishops] [knights] [pawns]
		
		int kings = scan.nextInt();
		int queens = scan.nextInt();
		int rooks = scan.nextInt();
		int bishops = scan.nextInt();
		int knights = scan.nextInt();
		int pawns = scan.nextInt();
		
		int neededKings = 1;
		int neededQueens = 1;
		int neededRooks = 2;
		int neededBishops = 2;
		int neededKnights = 2;
		int neededPawns = 8;
		
		
		String output = "";
		output += diff(kings, neededKings) + " ";
		output += diff(queens, neededQueens) + " ";
		output += diff(rooks, neededRooks) + " ";
		output += diff(bishops, neededBishops) + " ";
		output += diff(knights, neededKnights) + " ";
		output += diff(pawns, neededPawns);
		System.out.println(output);
		
		
		
	}
	
	static int diff(int have, int need) {
		int diff = 0;
		
		diff = need-have;
		
		return diff;
	}

}
