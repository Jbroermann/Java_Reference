package edu.unca.csci202;

import java.util.Scanner;


/**Minesweeper Game
 * 
 * Specifications
 * 
 * contains the main() method
 * 
 * main() should create an instance of the Gameboard class
 * and call it's run() method. All other program logic will
 * be implemented in the Gameboard class.
 * 
 * @author Ben Yaniero
 *
 */
public class Minesweeper {
	/**
	 * main method
	 * @param args ignored
	 */
	public static void main(String[] args) {
		Gameboard firstGame = new Gameboard();
		firstGame.run();
	}

}
