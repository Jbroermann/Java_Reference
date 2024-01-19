package edu.unca.csci202;
/**
 * Customer Objects
 * @author Ben Yaniero
 *
 */
public class Customer {
	private int items; //the number of grocery items
	private int timeToFinish; //time remaining for the customer's transaction to finish
	/**
	 * Constructor
	 * @param items is the number of grocery items
	 * @param processTime is the time it takes for the cashier to process (scan and bag) a single item
	 */
	public Customer(int items, int processTime) {
		this.items = items;
		timeToFinish = processTime*items;
	}
	/**
	 * Gets # of items
	 * @return # of items
	 */
	public int getItems() {
		return items;
	}
	/**
	 * Gets time remaining for the customer's transaction to finish
	 * @return time remaining for the customer's transaction to finish
	 */
	public int getTimeToFinish() {
		return timeToFinish;
	}
	/**
	 * Decrements time remaining for the customer's transaction to finish
	 */
	public void decrement() {
		timeToFinish--;
	}
}
