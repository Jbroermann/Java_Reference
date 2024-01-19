package edu.unca.csci202;
/**
 * Lab3
 * Meant to get practice using stacks via palindrome checking implementation
 * @author Ben Yaniero
 *
 */
public class ArrayPalindrome {

	ArrayStack<Character> charStackForward;
	ArrayStack<Character> charStackTemporary;
	ArrayStack<Character> charStackBackward;
	
	public ArrayPalindrome() {
		this.charStackForward = new ArrayStack();
		this.charStackTemporary = new ArrayStack();
		this.charStackBackward = new ArrayStack();
	}
	/**
	 * Checks to see if input is a palindrome
	 * @param input is the string that is to be checked
	 * @return true or false depending on if the input is a palindrome
	 */
	public boolean isPalindrome(String input){
		
		//clear my stacks
		clearStack(charStackForward);
		clearStack(charStackTemporary);
		clearStack(charStackBackward);
		
		//load character array into forward and temporary stacks
		char[] ray = input.toCharArray();
		for (int i = 0; i<ray.length; i++) { 
			charStackForward.push(ray[i]);
			charStackTemporary.push(ray[i]);
			
		}
		
		//load character array backwards into backward stack
		for (int i = 0; i<ray.length; i++) { 
			charStackBackward.push(charStackTemporary.pop());
		}
		
		//chekc input 4 "palindromeness"
		char temp1, temp2;
		for (int i = 0; i<ray.length; i++) {
			temp1 = charStackForward.pop();
			temp2 = charStackBackward.pop();
			if (temp1 != temp2) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Pops all the elements off of the stack, clearing it off
	 * @param stack is the stack to be cleared
	 */
	public void clearStack(ArrayStack stack) {
		while(!stack.isEmpty()) {
			stack.pop();
		}
	}
	/**
	 * Test method
	 * @param args ignored
	 */
	public static void main(String[] args) {
		String testInput1 = "racecar";
		String testInput2 = "racer";
		String testInput3 = "1234321";
		String testInput4 = "1234";
		String testInput5 = "Racecar";
		String testInput6 = " racecar";
		String testInput7 = "racecar ";
		
		testHelper(testInput1);
		testHelper(testInput2);
		testHelper(testInput3);
		testHelper(testInput4);
		testHelper(testInput5);
		testHelper(testInput6);
		testHelper(testInput7);

	}
	/**
	 * eases the test process, prints stuff
	 * @param testInput just like it sounds
	 */
	public static void testHelper(String testInput) {
		System.out.println("Is "+testInput+" a palindrome?");
		ArrayPalindrome PalArray1 = new ArrayPalindrome();
		boolean test = PalArray1.isPalindrome(testInput);
		System.out.println(test);
	}

}
