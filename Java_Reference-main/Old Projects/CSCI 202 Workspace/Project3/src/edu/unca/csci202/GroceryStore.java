package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;

/**
 * A simulated GroceryStore
 * @author Ben Yaniero
 *
 */
public class GroceryStore {

	private ArrayList<Queue<Customer>> checkOutLines; //List containing the checkout line queues
	
	private int steps; // number of time steps to run
	private int lines; // number of lines
	private double arrivalProb; // customer arrival probability
	private int timePerItem; // the time per item
	private int maxItems; // maximum number of items
	private int maxLengths[]; // contains maximum length of each queue
	private int customersLeft[]; // contains customers left in the queue when simulation ends
	
	private int totalServed; // total customers served

	/**
	 * Constructor
	 * @param queNum is the number of checkout lines
	 * @throws notEnoughQueuesException is thrown when there aren't enough queues
	 */
	public GroceryStore(int queNum) throws notEnoughQueuesException {
		this.checkOutLines = new ArrayList<Queue<Customer>>();
		int count = queNum;
		if (queNum < 1) {
			throw new notEnoughQueuesException();
		}
		else {
			for(int i = 0; i < count; i++) {
				ArrayDeque<Customer> Q = new ArrayDeque<Customer>();
				checkOutLines.add(Q);
			}
		}
		
		this.steps = -999;
		this.lines = queNum;
		this.arrivalProb = -999;
		this.timePerItem = -999;
		this.maxItems = -999;
		this.maxLengths = new int[lines];
		Arrays.fill(maxLengths, 0);
		this.customersLeft = new int[lines];
		Arrays.fill(customersLeft, 0);
		
	}
	/**
	 * Loop for the given number of time steps, running the simulation. 
	 * At the beginning of a run simulation, the checkout lines should be empty.
	 * 
	 * @param steps number of time steps to execute
	 * @param arrivalProb probability (values between 0 and 1) that a customer will appear with each time step
	 * @param timePerItem the time it takes to process (scan and bag) a single item
	 * @param maxItems the maximum number of items a customer might have
	 * @throws notEnoughQueuesException 
	 */
	public void run(int steps, double arrivalProb, int timePerItem, int maxItems) throws notEnoughQueuesException {
		for(int i = 0; i < lines; i++) {
			checkOutLines.get(i).clear();
		}
		this.steps = -999;
		this.arrivalProb = -999;
		this.timePerItem = -999;
		this.maxItems = -999;
		Arrays.fill(maxLengths, 0);
		Arrays.fill(customersLeft, 0);
		this.totalServed = 0;
		
		Random gen = new Random();
		int simulationDuration = steps;
		Queue<Customer> shortestQueue;
		
		for (int time=0; time<simulationDuration; time++) {
			if (gen.nextDouble() <= arrivalProb) {
				shortestQueue = getShortestQueue();
				Customer customer = new Customer(gen.nextInt(maxItems) + 1, timePerItem);
				shortestQueue.add(customer);
			}
			for(int i = 0; i < lines; i++) { 
				if(maxLengths[i] < checkOutLines.get(i).size()) {
					maxLengths[i] = checkOutLines.get(i).size();
				}
				
				if (!checkOutLines.get(i).isEmpty()) {
					checkOutLines.get(i).element().decrement(); //This assumes that customers arrive at the top of the second, thus can both arrive and be checked out in 1 cycle
					if (checkOutLines.get(i).element().getTimeToFinish() <= 0) {
						checkOutLines.get(i).remove();
						totalServed++;
					}
				}
			}
		}
		
		this.steps = steps;
		this.arrivalProb = arrivalProb;
		this.timePerItem = timePerItem;
		this.maxItems = maxItems;
		for(int i = 0; i < lines; i++) { 
			customersLeft[i] = checkOutLines.get(i).size();
		}
	}
	/**
	 * Returns shortest queue in the grocery store
	 * @return shortest queue in the grocery store
	 * @throws notEnoughQueuesException 
	 */
	private Queue<Customer> getShortestQueue() throws notEnoughQueuesException {
		if(this.checkOutLines.isEmpty()) {
			throw new notEnoughQueuesException();
		}
		Queue<Customer> min = this.checkOutLines.get(0);
		for(int i = 0; i < this.lines; i++) {
			if (this.checkOutLines.get(i).size() < min.size()) {
				min = this.checkOutLines.get(i);
			}
		}
		
		return min;
		
	}
	/**
	 * Prints the following information for the most recent call to run
	 * 	simulation setup info:
	 * 		the number of time steps run
	 * 		the number of lines
	 * 		the customer arrival probability
	 * 		the time per item
	 * 		the maximum number of items
	 * 
	 * 	for each checkout line:
	 * 		the maximum length of each queue
	 * 		the number of customers left in each queue
	 * 
	 * 	the total number of customers served (the number that finished checking out)
	 * 
	 */
	public void printData() {
		System.out.println("Number of timesteps: " + steps);
		System.out.println("Number of lines: " + lines);
		System.out.println("Probability of customer arriving: " + arrivalProb);
		System.out.println("Time per item: " + timePerItem);
		System.out.println("Maximum number of items: " + maxItems);

		for (int i = 0; i < lines; i++) {
			System.out.println("Maximum length of line "+ i + " is: " + maxLengths[i]);
			System.out.println("Customers left in line "+ i + " is: " + customersLeft[i]);
		}
		
		System.out.println("Total number of customers served is: " + totalServed);
	}
}
