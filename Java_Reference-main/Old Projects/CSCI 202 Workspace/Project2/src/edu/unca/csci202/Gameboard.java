package edu.unca.csci202;

import java.util.Random;
import java.util.Scanner;

import java.util.Stack;
import java.util.EmptyStackException;

/**Contains all logic to facilitate "gameplay"
 * 
 * Specifications
 * 
 * Will have a two-dimensional array (an 8-by-8 grid)
 * 
 * Will contain a public run() method that runs the game
 * 
 * @author Ben Yaniero
 */
public class Gameboard {

	public int mines; //number of mines
	public Cell[][] grid; //gameboard cell array
	
	/**
	 * Constructor
	 */
	public Gameboard() {
		this.mines = 10;
		this.grid = new Cell[8][8];
		generateGrid();
	}
	/**
	 * initiates a new playable gameboard grid
	 */
	private void generateGrid() {
		Random rand = new Random();
		int randRow;
		int randCol;
		
		/* Empty board generator */
		for(int x=0; x<grid.length; x++) {
			for(int y=0; y<grid[0].length; y++) {
					grid[x][y] = new Cell(x, y, false, false);
			}
		}
		
		/* Random Mine Code */
		
		//First mine generator
		randRow = rand.nextInt(8);
		randCol = rand.nextInt(8);
		grid[randRow][randCol].setMine(true);
		
		//Mine generation after first mine is done
		for(int i=2; i<=this.mines; i++) {
			randRow = rand.nextInt(8);
			randCol = rand.nextInt(8);
			if (grid[randRow][randCol].isMine() == false) {
				grid[randRow][randCol].setMine(true);
			}
			else {
				i--;
			}
		}
		
		/* set adjMines values */
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				for(int k = -1; k <= 1; k++) {
					for(int L = -1; L <= 1; L++) {
						try {
							if(grid[i+L][j+k].isMine() == true) {
								grid[i][j].setAdjMines(grid[i][j].getAdjMines()+1);
							}
						} catch (java.lang.ArrayIndexOutOfBoundsException e) {} //I A M S O R R Y
					}
				}
			}
		}
	}
	/**
	 * Used to view mines on the gameboard
	 * also reprints as per spec
	 */
	private void peekMines() {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j].isMine() == true) {
					grid[i][j].setSymbol("M");
				}
			}
		}
		//peekAdj(); //FOR TESTING
		printGameboard();
		for(int x=0; x<grid.length; x++) {
			for(int y=0; y<grid[0].length; y++) {
				if(grid[x][y].isMine() == true && !grid[x][y].isGuessed()) {
					grid[x][y].setSymbol("-");
				}
			}
		}
	}
	/**
	 * Test method used to see the values of non-mine spaces
	 */
	private void peekAdj() {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j].isMine() == false) {
					grid[i][j].setSymbol(String.valueOf(grid[i][j].getAdjMines()));
				}
			}
		}
	}
	/**
	 * Runs the minesweeper game, broken into 2 methods.
	 */
	public void run() {
		Scanner scan = new Scanner(System.in);
		//Gameboard firstGame = new Gameboard();
		System.out.println("Welcome to Minesweeper!");
		String userInput;
		boolean userDoesNotWannaPlayAtAll = false;
		do {
			try {
				System.out.print("Would you like to play a game? (y/n): ");
				userInput = scan.nextLine();
				userInput = userInput.toLowerCase();
				if(userInput.compareTo("y") != 0 && userInput.compareTo("n") != 0) {
					throw new invalidInputException();
				}
				break;
			} catch (invalidInputException e) {
				System.out.println("Invalid input, please try again.");
			}
		} while(true);
		
		if (userInput.compareTo("y") == 0) {
			this.run2(scan);
		}
		else {
			System.out.println("Goodbye!");
			userDoesNotWannaPlayAtAll = true;
		}
		
		do {
			if (userDoesNotWannaPlayAtAll) {
				break;
			}
			System.out.println("Thank you for playing Minesweeper.");
			
			do {
				try {
					System.out.print("Would you like to play again? (y/n): ");
					userInput = scan.nextLine();
					userInput = userInput.toLowerCase();
					if(userInput.compareTo("y") != 0 && userInput.compareTo("n") != 0) {
						throw new invalidInputException();
					}
					break;
				} catch (invalidInputException e) {
					System.out.println("Invalid input, please try again.");
				}
			} while(true);
			if (userInput.compareTo("y") == 0) {
				Gameboard newGame = new Gameboard();
				newGame.run2(scan);
			}
			else {
				System.out.println("Goodbye!");
				break;
			}
			
		} while(true);
	}
	/**
	 * Also used to run the minesweeper game
	 * @param scanRun used to pass scanner between the run methods
	 */
	private void run2(Scanner scanRun) {
		boolean gameOver = false;
		boolean finished = false;
		String userInputRun;
		int userInputRow = -999;
		int userInputCol = -999;
		while(!gameOver) {
			printGameboard();
			do {
				try {
					System.out.print("Would you like to peek? (y/n): ");
					userInputRun = scanRun.nextLine();
					userInputRun = userInputRun.toLowerCase();
					if(userInputRun.compareTo("y") != 0 && userInputRun.compareTo("n") != 0) {
						throw new invalidInputException();
					}
					break;
				} catch (invalidInputException e) {
					System.out.println("Invalid input, please try again.");
				}
			} while(true);
			
			if(userInputRun.compareTo("y") == 0) {
				peekMines();
			}
			
			do {
				try {
					System.out.print("Please enter a row number: ");
					userInputRun = scanRun.nextLine();
					userInputRow = Integer.valueOf(userInputRun);
					if(userInputRow > 0 && userInputRow < 9) {
						break;
					}
					else {
						throw new invalidInputException();
					}
				} catch (invalidInputException e) {
					System.out.println("Invalid input, please try again.");
				} catch (java.lang.NumberFormatException ignore) {
					System.out.println("Invalid input, please try again.");
				}
			} while(true);
			
			do {
				try {
					System.out.print("Please enter a column number: ");
					userInputRun = scanRun.nextLine();
					userInputCol = Integer.valueOf(userInputRun);
					if(userInputCol > 0 && userInputCol < 9) {
						break;
					}
					else {
						throw new invalidInputException();
					}
				} catch (invalidInputException e) {
					System.out.println("Invalid input, please try again.");
				} catch (java.lang.NumberFormatException ignore) {
					System.out.println("Invalid input, please try again.");
				}
			} while(true);
			
			
			do {
				try {
					System.out.print("Does row "+ userInputRow + " and column "+ userInputCol+" contain a mine? (y/n): ");
					userInputRun = scanRun.nextLine();
					userInputRun = userInputRun.toLowerCase();
					if(userInputRun.compareTo("y") != 0 && userInputRun.compareTo("n") != 0) {
						throw new invalidInputException();
					}
					break;
				} catch (invalidInputException e) {
					System.out.println("Invalid input, please try again.");
				}
			} while(true);
			
			/*3 things can happen from here
			 *  "n" = correct --> display adj num
			 *  "y" = correct --> display M
			 *  "y/n" = incorrect --> gameOver
			 */
			
			userInputRow = userInputRow-1; //convert to index
			userInputCol = userInputCol-1; //convert to index
			
			if (userInputRun.compareTo("y") == 0) {
				if (grid[userInputRow][userInputCol].isMine() == true) {
					grid[userInputRow][userInputCol].setSymbol("M");
					grid[userInputRow][userInputCol].setGuessed(true);
				}
				else {
					gameOver = true;
				}
			} 
			else {
				if (grid[userInputRow][userInputCol].isMine() == false) {
					grid[userInputRow][userInputCol].setSymbol(String.valueOf(grid[userInputRow][userInputCol].getAdjMines()));
					grid[userInputRow][userInputCol].setGuessed(true);
					
					//Here is where I shall implement the expand method :)
					if (grid[userInputRow][userInputCol].getSymbol().equals("0")) {
						expand(grid[userInputRow][userInputCol]);
					}
					
					
				}
				else {
					gameOver = true;
				}
			}
			
			if(gameOver) {
				System.out.println("Boom! You lose.");
				break;
			}
			
			int guessedMinesCount = 0;
			for(int x=0; x<grid.length; x++) {
				for(int y=0; y<grid[0].length; y++) {
					if(grid[x][y].isMine() == true && grid[x][y].isGuessed()) {
						guessedMinesCount++;
					}
				}
			}
			
			if(guessedMinesCount == 10) {
				finished = true;
			}
			
			  if(!gameOver && finished) {
				  System.out.println("You win!");
				  break;
			  }
		}
		
		
		 
		
	}
	/**
	 * Prints the gameboard
	 */
	private void printGameboard() {
		for(int x=0; x<grid.length; x++) {
			for(int y=0; y<grid[0].length; y++) {
				System.out.print(grid[x][y].getSymbol()+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	/** Project 2 Method
	 * when a correctly guessed non-mine location has zero adjacent mines,
	 * the guess is effectively expanded in all directions
	 * until a non-zero number of adjacent mines is encountered.
	 * @param startCell indicates the cell picked by the user
	 */
	private void expand(Cell startCell) {
		Stack<Cell> expandStack = new Stack<Cell>();
		expandStack.push(startCell);
		Cell expandingCell;
		int expRow;
		int expCol;
		while(!expandStack.isEmpty()) {
			expandingCell = expandStack.pop();
			expRow = expandingCell.getRowNum();
			expCol = expandingCell.getColNum();
			for (int i=-1; i<=1; i++) {
				for (int j=-1; j<=1; j++) {
					try{
						grid[expRow+j][expCol+i].setSymbol(String.valueOf(grid[expRow+j][expCol+i].getAdjMines()));
						if (grid[expRow+j][expCol+i].getAdjMines() == 0 && !grid[expRow+j][expCol+i].isGuessed()) {
							grid[expRow+j][expCol+i].setGuessed(true);
							expandStack.push(grid[expRow+j][expCol+i]);
						}
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {} //I A M S O R R Y
				}
			}
		}
		
	}
}
