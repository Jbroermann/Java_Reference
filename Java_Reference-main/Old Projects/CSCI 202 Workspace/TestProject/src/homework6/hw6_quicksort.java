package homework6;

import java.util.Arrays;

import jdk.dynalink.linker.ConversionComparator.Comparison;

public class hw6_quicksort {


	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>>
	void quickSort(T[] data)
	{
		quickSort(data, 0, data.length - 1);
	}
	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm.
	 *
	 * @param data the array to be sorted
	 * @param min the minimum index in the range to be sorted
	 * @param max the maximum index in the range to be sorted
	 */

	private static <T extends Comparable<T>>
	void quickSort(T[] data, int min, int max)
	{
		System.out.println(); //for readability
		System.out.print("Call quickSort method with data: " + Arrays.toString(data));
		System.out.print(" Min: " + data[min]);
		if(max > -1) {
			System.out.println(" Max: " + data[max]);
		}
		else {
			System.out.println(" Max = index: " + max);
		}



		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max);
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 *
	 * @param data the array to be sorted
	 * @param min the minimum index in the range to be sorted
	 * @param max the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>>
	int partition(T[] data, int min, int max)
	{
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		// use the middle data value as the partition element
		partitionelement = data[middle];
		System.out.println("Partition with pivot as " + partitionelement);
		// move it out of the way for now
		//System.out.println("Swap " + data[middle] + " and " + data[min]);
		swap(data, middle, min);
		left = min;
		right = max;

		while (left < right)
		{
			// search for an element that is > the partition element 
			while (left < right && data[left].compareTo(partitionelement) <= 0)
				left++;
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
				right--;
			// swap the elements
			if (left < right)
				//System.out.println("Swap " + data[left] + " and " + data[right]);
				swap(data, left, right);
		}
		// move the partition element into place
		//System.out.println("Swap " + data[min] + " and " + data[right]);
		swap(data, min, right);
		return right;
	}

	private static <T> void swap(T[] data, int index1, int index2) {
		T temp;
		temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
		System.out.print("Swap " + data[index1] + " and " + data[index2]);
		System.out.println(" New data: " + Arrays.toString(data));
	}


	public static void main(String[] args) {

		//Integer[] ray = { 90, 8, 7, 56, 123, 235, 9, 1, 653 };
		Integer[] ray= {3, 8, 12, 34, 54, 84, 91, 110};
		System.out.println("Unsorted List: " + Arrays.toString(ray));

		quickSort(ray);

		System.out.println("Sorted List: " + Arrays.toString(ray));

	}

}
