package edu.unca.csci202;
/**Cells contain Gameboard data
 * 
 * Specifications
 * 
 * represents each square on the game board
 * should be a String or a char
 * 
 * a hyphen means that a guess for that cell has not yet been made
 * 
 * a digit means that a guess for that cell does not contain a mine
 * and that the guess was correct. In this case, the digit represents
 * the number of adjacent cells that contain a mine. By adjacent we mean
 * the up to eight cells that are touching the cell in question. The eight
 * cells include the four cells that are directly north, south, east, and
 * west, as well as the four corner cells that are north-east, south-east,
 * south-west, and north-west. 
 * Note the digit is a character, not an int.
 * 
 * the character M means that a guess has been made that the cell does
 * contain a mine and the guess was correct. In this case, the M indicates
 * that the cell contains a mine.
 * 
 * @author Ben Yaniero
 * 
 */
public class Cell {
	
	private int rowNum; //row index
	private int colNum; //column index
	private boolean isMine; //does this cell contain a mine
	private int adjMines = 0; //# of adjacent mines
	private boolean isGuessed; //has this cell been previously guessed
	private String symbol; //what to print
	/**
	 * Constructor 
	 * 
	 * @param xLoc row number
	 * @param yLoc column number
	 * @param isMine is it a mine?
	 * @param isGuessed has it been guessed?
	 */
	public Cell(int xLoc, int yLoc, boolean isMine, boolean isGuessed) {
		this.rowNum = xLoc;
		this.colNum = yLoc;
		this.isMine = isMine;
		this.isGuessed = isGuessed;
		this.symbol = "-";
	}

	/**
	 * toString override
	 * will print [xLoc, yLoc]
	 */
	@Override
	public String toString() { //toString will print [xLoc, yLoc]
		return "[" + this.rowNum + ", " + this.colNum + "]";
	}
	/**
	 * gets the row number
	 * @return rowNum row number
	 */
	public int getRowNum() {
		return rowNum;
	}
	/**
	 * sets the row number
	 * @param rowNum row number
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	/**
	 * gets column number
	 * @return colNum column number
	 */
	public int getColNum() {
		return colNum;
	}
	/**
	 * sets column number
	 * @param colNum column number
	 */
	public void setColNum(int colNum) {
		this.colNum = colNum;
	}
	/**
	 * gets isMine
	 * @return isMine true is a mine
	 */
	public boolean isMine() {
		return isMine;
	}
	/**
	 * sets isMine
	 * @param isMine true is a mine
	 */
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	/**
	 * gets # of adjacent mines
	 * @return adjMines # of adjacent mines
	 */
	public int getAdjMines() {
		return adjMines;
	}
	/**
	 * sets # of adjacent mines
	 * @param adjMines # of adjacent mines
	 */
	public void setAdjMines(int adjMines) {
		this.adjMines = adjMines;
	}
	/**
	 * gets isGuessed
	 * @return isGuessed true has been guessed
	 */
	public boolean isGuessed() {
		return isGuessed;
	}
	/**
	 * sets isGuessed
	 * @param isGuessed true has been guessed
	 */
	public void setGuessed(boolean isGuessed) {
		this.isGuessed = isGuessed;
	}
	/**
	 * gets cells current symbol
	 * @return symbol what is printed on the gameboard
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * sets cells current symbol
	 * @param symbol what is printed on the gameboard
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
