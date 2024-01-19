package edu.unca.csci202;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortLab {

	public static void selectionSort(int[] array) {
		int min;
		int temp;
		for (int i=0; i<array.length-1; i++) {
			min = i;
			for(int j=i+1; j<array.length; j++) {
				if(array[j]<array[min]) {
					min = j;
				}
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}
	
	public static void insertionSort(int[] array) {
		int temp;
		for(int i=1; i<array.length; i++) {
			for (int j=i; array[j]<array[j-1]; j--) {
				temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				if(j == 1) {
					break;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] array) {
		int temp;
		int stepNumber = 2;
		for(int i=array.length-1; i >= 0; i--) {
			for (int j=0; j<=i-1; j++) {
				
				
				if(array[j]>=array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				//System.out.println(stepNumber+". "+Arrays.toString(array) + " Index: " + (j+1));
				//System.out.println(Arrays.toString(array));
				stepNumber++;
			}
		}
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("What sorting method would you like to use: ");
		String alg = scan.next();
		alg = alg.toLowerCase();
		System.out.println("Would you like to select a number? (y/n)");
		String choice = scan.next();
		choice = choice.toLowerCase();
		if (choice.compareTo("n") == 0) {
			//do something
			
			/*for(int i=50000; i<=300000; i+=50000) {
			
			}*/
			
			//unfinished
		}
		else
		{
			System.out.println("Type a number: ");
			int num = scan.nextInt();
			
			
			int[] array = new int[num];
			Random rand = new Random();
			int randomNum;
			for(int i=0; i<array.length; i++) {
				randomNum = rand.nextInt(100);
				array[i] = randomNum;
			}
			//System.out.print("Unsorted: ");
			//System.out.println(Arrays.toString(array));
			long time1=0;
			long time2=0;
			switch(alg) {
			case("selection"):
				time1 = System.nanoTime();
				selectionSort(array);
				time2 = System.nanoTime();
				//System.out.print("Selection Sorted: ");
			break;
			case("insertion"):
				time1 = System.nanoTime();
				insertionSort(array);
				time2 = System.nanoTime();
				//System.out.print("Insertion Sorted: ");
			break;
			case("bubble"):
				time1 = System.nanoTime();
				bubbleSort(array);
				time2 = System.nanoTime();
				//System.out.print("Bubble Sorted: ");
			break;
			default:
				System.out.println("Invalid Input");
			break;
			}
			//System.out.println(Arrays.toString(array));
			double sortTime = (time2-time1)/1000000000;
			System.out.println("Sorting Time: "+sortTime);
		}
		
		
	}
	
	

}
