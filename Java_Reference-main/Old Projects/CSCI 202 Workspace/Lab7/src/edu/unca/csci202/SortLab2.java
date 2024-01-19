package edu.unca.csci202;

import java.util.Arrays;
import java.util.Random;

public class SortLab2 {

	public static String[] generateArray(int n, int minLength, int maxLength) {
		Random rand = new Random();
		int genLength = rand.nextInt(maxLength+1-minLength)+minLength; 
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		//String gen = "";
		String[] gens = new String[n];
		for(int i=0; i<gens.length; i++) {
			gens[i] = "";
		}
		//System.out.println(genLength);
		
		for(int k = 0; k < n; k++) {
			for (int i = 0; i<genLength; i++) {
				gens[k] += letters[rand.nextInt(letters.length)];
			}
		}
		
		
		
		return gens;
		
	}

	public static void main(String[] args) {

		/*String[] randoStrings = (generateArray(6, 1, 1));
		System.out.println("Unsorted: " + Arrays.toString(randoStrings));
		//Sorting.selectionSort(randoStrings);
		//Sorting.quickSort(randoStrings);
		//Arrays.sort(randoStrings);
		System.out.println("Sorted " + Arrays.toString(randoStrings));*/
		
	
		int trials = 10;
		int raySizeIncrement = 5000;
		//String[][] randoStrings = new String[trials][];
		for(int i = 0; i < trials; i++) {
			String[] randoStrings = generateArray(raySizeIncrement, 10, 20);
			
			//System.out.println("Unsorted: " + Arrays.toString(randoStrings));
			
			String[] toBeSelectionSorted = randoStrings;
			String[] toBeQuickSorted = randoStrings;
			String[] toBeArraySorted = randoStrings;
			
			long t1ss = System.nanoTime();
			Sorting.selectionSort(toBeSelectionSorted);
			long t2ss = System.nanoTime();
			
			long t1qs = System.nanoTime();
			Sorting.quickSort(toBeQuickSorted);
			long t2qs = System.nanoTime();
			
			long t1as = System.nanoTime();
			Arrays.sort(toBeArraySorted);
			long t2as = System.nanoTime();
			
			
			System.out.println("raySize: " + raySizeIncrement);
			System.out.println("Selection sort: " + (t2ss-t1ss)/1000000000.);
			System.out.println("Quick sort: " + (t2qs-t1qs)/1000000000.);
			System.out.println("Array sort: " + (t2as-t1as)/1000000000.);
			System.out.println();
			
			raySizeIncrement += 5000;
		}

		
		
	}

}
