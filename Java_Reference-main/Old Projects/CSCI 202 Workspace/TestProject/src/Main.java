import java.util.Arrays;

public class Main {

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
	
	public static void selectionSort(int[] array) {
		
	}
	
	public static void main(String[] args) {
		int[] testArray = {2, 5, 7, 1, 2};
		int[] hw1TestArray = {90, 8, 7, 56, 123, 235, 9, 1, 653};
		int[] hw1TestArray2 = {3, 8, 12, 34, 54, 84, 91, 110};
		/*System.out.println(Arrays.toString(testArray));
		insertionSort(testArray);
		System.out.println(Arrays.toString(testArray));
		*/
		//System.out.println(Arrays.toString(hw1TestArray));
		bubbleSort(hw1TestArray2);
		System.out.println(Arrays.toString(hw1TestArray2));
		
	}
		
		

}
