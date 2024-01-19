package edu.unca.csci202;
/**
 * Creates instances of GroceryStore for testing
 * Contains main method
 * @author Ben Yaniero
 *
 */
public class StoreDriver {

	/**
	 * Used to test grocery store simulations
	 * @param args ignored
	 * @throws notEnoughQueuesException thrown when there is less than 1 queue
	 */
	public static void main(String[] args) throws notEnoughQueuesException {
		/* Prompt Test */
		GroceryStore g1 = new GroceryStore(5);
		
		g1.run(1000, 0.1, 1, 50);
		g1.printData();
		
		g1.run(1000, 0.1, 2, 50);
		g1.printData();
		
		/* Prompt Test */
//		GroceryStore store = new GroceryStore(2);
//		store.run(300, 0.3, 2, 10);
//		store.printData();
		
		
		/* Repeated Test */
//		GroceryStore store = new GroceryStore(2);
//		store.run(300, 0.3, 2, 10);
//		store.printData();
//		
//		store.run(300, 0.3, 2, 10);
//		store.printData();
		
		/* No Lines Test */
//		GroceryStore store2 = new GroceryStore(0);
//		store2.run(10, 1, 1, 1);
//		store2.printData();
		
		/* One Line Test */
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(10, 1, 1, 1);
//		store2.printData();
		
		/* 1 line
		 * 1 cycle
		 * 1 customer/cycle
		 * 1 item/cycle
		 * 1 item max
		 * Expected # served = 1
		 */
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(1, 1, 1, 1);
//		store2.printData();
		
		/* 1 line
		 * 2 cycles
		 * 1 customer/cycle
		 * 1 item / 2 cycle
		 * 1 item max
		 * Expected # served = 1
		 */
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(2, 1, 2, 1);
//		store2.printData();
		
		/* 1 line
		 * 1 cycle
		 * 1 customer / 2 cycle
		 * 1 item/cycle
		 * 1 item max
		 * Expected # served = ~1 or 0
		 */
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(1, .5, 1, 1);
//		store2.printData();
		
		/* 1 line
		 * 100 cycles
		 * 1 customer / 1 cycle
		 * 1 item/ 1 cycle
		 * 100 item max
		 * Expected # served = ~1
		 */
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(100, 1, 1, 100);
//		store2.printData();
		
		/* Many Lines Tests */
//		GroceryStore store2 = new GroceryStore(100);
//		store2.run(10, 1, 1, 1);
//		store2.printData();
		
//		GroceryStore store2 = new GroceryStore(1);
//		store2.run(100, 1, 1, 1);
//		store2.printData();

	}

}
