package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Stack;

/**
 * implements LargeInteger using an ArrayList
 * @author Ben Yaniero
 *
 */
public class ArrayLargeInteger implements LargeInteger {
	private static final ArrayLargeInteger ZERO = new ArrayLargeInteger("0");
//	private static final ArrayLargeInteger ONE = new ArrayLargeInteger("1");
//	private static final int TEN = 10;

	public ArrayList<Integer> value;
	public boolean isNegative = false;


	/**
	 * Constructor
	 * @param rep contains the string representation of the intended LargeInteger
	 */
	public ArrayLargeInteger(String rep) {
		/* Usage examples as follows:
		 * new ArrayLargeInteger("123123412312340120341234000000")
		 * new ArrayLargeInteger("-922333221341231") //to create a negative number, the first character in the constructor argument String should be '-'
		 */

		this.value = new ArrayList<Integer>();
		char[] ray = rep.toCharArray();
		for(int i = 0; i<ray.length; i++) {
			if(i==0 && ray[i] == '-') {
				this.isNegative = true;
			} else {
				this.value.add(Character.getNumericValue(ray[i]));
			}
			this.removeLeadingZeros();

		}

	}
	@Override
	public LargeInteger add(LargeInteger arg) {
		ArrayLargeInteger saveMe = new ArrayLargeInteger(this.toString());
		ArrayLargeInteger comp = new ArrayLargeInteger(arg.toString());

		/* Determine Which Has More Digits and Correct Size */
		int placeDif = 0;
		if(this.value.size() > comp.value.size()) {
			placeDif = this.value.size() - comp.value.size();
			for(int i = 0; i < placeDif; i++) {
				comp.value.add(0, 0);
			}
		} 
		else if (this.value.size() < comp.value.size()) {
			placeDif = comp.value.size() - this.value.size();
			for(int i = 0; i < placeDif; i++) {
				this.value.add(0, 0);
			}
		}

		/* Create Empty Result Array */
		ArrayLargeInteger result = new ArrayLargeInteger("");
		for(int i = 0; i < this.value.size(); i++) {
			result.value.add(0);
		}

		/* Both Positive or Negative */
		if (!this.isNegative == !comp.isNegative) {
			int carry = 0;
			for(int i = this.value.size()-1; i >= 0; i--) {
				int intSum = this.value.get(i) + comp.value.get(i) + carry;
				if(intSum > 9 && i!=0) {
					carry = 1;
					intSum = intSum - 10;
				}
				else carry = 0;
				result.value.set(i, intSum);
			}
			if(this.isNegative) {
				result.isNegative = true;
			}
		}
		/* This is Negative */
		else if (this.isNegative) { // -this + comp --> comp - this
			flipSign(this);
			result = new ArrayLargeInteger(comp.subtract(this).toString());
		}
		/* Argument is Negative */
		else if (comp.isNegative) { // this + (-comp) --> this - comp
			flipSign(comp);
			result = new ArrayLargeInteger(this.subtract(comp).toString());
		}
		LargeInteger finalResult = new ArrayLargeInteger(result.toString());
		this.value = saveMe.value; // bandaid
		this.isNegative = saveMe.isNegative;
		return finalResult;
	}
	@Override
	public LargeInteger subtract(LargeInteger arg) {
		ArrayLargeInteger saveMe = new ArrayLargeInteger(this.toString());
		ArrayLargeInteger comp = new ArrayLargeInteger(arg.toString());

		/* Determine Which Has More Digits and Correct Size */
		int placeDif = 0;
		if(this.value.size() > comp.value.size()) {
			placeDif = this.value.size() - comp.value.size();
			for(int i = 0; i < placeDif; i++) {
				comp.value.add(0, 0);
			}
		} 
		else if (this.value.size() < comp.value.size()) {
			placeDif = comp.value.size() - this.value.size();
			for(int i = 0; i < placeDif; i++) {
				this.value.add(0, 0);
			}
		}

		/* Create Empty Result Array */
		ArrayLargeInteger result = new ArrayLargeInteger("");
		for(int i = 0; i < this.value.size(); i++) {
			result.value.add(0);
		}
		
		/* Both Positive or Negative */
		if (!this.isNegative == !comp.isNegative) {
			//if this is bigger than comp, switch them and negate the answer
			if (this.isNegative && comp.isNegative) {
				result.isNegative = true;
			}
			if (absValComp(this, comp) < 0) {
				if(result.isNegative) {
					result.isNegative = false;
				}
				else result.isNegative = true;
				ArrayLargeInteger temp = new ArrayLargeInteger(this.toString());
				this.value = comp.value;
				comp.value = temp.value;
				placeDif = 0;
				if(this.value.size() > comp.value.size()) {
					placeDif = this.value.size() - comp.value.size();
					for(int i = 0; i < placeDif; i++) {
						comp.value.add(0, 0);
					}
				} 
				else if (this.value.size() < comp.value.size()) {
					placeDif = comp.value.size() - this.value.size();
					for(int i = 0; i < placeDif; i++) {
						this.value.add(0, 0);
					}
				}
			}
			int borrow = 0;
			for(int i = this.value.size()-1; i >= 0; i--) {
				int nextBorrow = 0;
				this.value.set(i, this.value.get(i)+borrow);
				if(this.value.get(i) < comp.value.get(i)) {
					nextBorrow = -1;
					this.value.set(i, this.value.get(i)+10);
				}
				int intDif = this.value.get(i) - comp.value.get(i);
				result.value.set(i, intDif);
				borrow = nextBorrow;
			}

		}
		/* This is Negative */
		else if (this.isNegative) { // -this - comp --> -this + -comp
			flipSign(comp);
			result = new ArrayLargeInteger(this.add(comp).toString());
		}
		/* Argument is Negative */
		else if (comp.isNegative) { // this - (-comp) --> this + comp
			flipSign(comp);
			result = new ArrayLargeInteger(this.add(comp).toString());
		}
		
		LargeInteger finalResult = new ArrayLargeInteger(result.toString());
		this.value = saveMe.value; //bandaid
		this.isNegative = saveMe.isNegative;
		return finalResult;
	}
	@Override
	public LargeInteger negate() {
		ArrayLargeInteger temp = new ArrayLargeInteger(this.toString());

		temp.isNegative=true;
		return temp;
	}
	@Override
	public LargeInteger abs() {
		ArrayLargeInteger temp = new ArrayLargeInteger(this.toString());

		temp.isNegative=false;
		return temp;
	}
	@Override
	public LargeInteger multiply(LargeInteger arg) {
		ArrayLargeInteger saveMe = new ArrayLargeInteger(this.toString());
		ArrayLargeInteger comp = new ArrayLargeInteger(arg.toString());
		
		//Handle zero case
		if (this.value.equals(ZERO.value) || comp.value.equals(ZERO.value)) {
			return ZERO;
		}
		
		/* Determine Which Has More Digits and Correct Size */
		int placeDif = 0;
		if(this.value.size() > comp.value.size()) {
			placeDif = this.value.size() - comp.value.size();
			for(int i = 0; i < placeDif; i++) {
				comp.value.add(0, 0);
			}
		} 
		else if (this.value.size() < comp.value.size()) {
			placeDif = comp.value.size() - this.value.size();
			for(int i = 0; i < placeDif; i++) {
				this.value.add(0, 0);
			}
		}

		/* Create Empty Result Array */
		ArrayLargeInteger result = new ArrayLargeInteger("");
		for(int i = 0; i < this.value.size(); i++) {
			result.value.add(0);
		}
		
		/* Handle Signs */
		boolean signFlag;
		if(this.signum() == comp.signum()) {
			signFlag = false;
			//result.isNegative = false;
		} else {
			signFlag = true;
			//result.isNegative = true;
		}
		this.isNegative = false;
		comp.isNegative = false;
		
//		System.out.println(this.toString());
//		System.out.println(comp.toString());
//		System.out.println(result.toString());
		
//		/* Easy Way Out */
//		// Too Slow...
//		while (!comp.value.equals(ZERO.value)) {
//			result = new ArrayLargeInteger (result.add(this).toString());
//			//System.out.println(result.toString());
//			comp = new ArrayLargeInteger(comp.subtract(ONE).toString());
//		}
		
		/* Baby Multiplication */
		int placeCount = 0;
		
		for (int i = comp.value.size()-1; i >= 0; i--) {
			//System.out.println("i: " + i);
			ArrayLargeInteger temp = new ArrayLargeInteger(""); //used for addition
			
			int carry = 0;
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = this.value.size()-1; j >= 0; j--) {
				
				int digitProduct = this.value.get(j) * comp.value.get(i) + carry;
				carry = digitProduct / 10;
				//System.out.println("Carry: " + carry);
				digitProduct = digitProduct % 10;
				//System.out.println("Digit Product: " + digitProduct);
				//temp.value.add(digitProduct);
				stack.push(digitProduct);
			}
			if(carry != 0) {
				stack.push(carry);
			}
			while(!stack.isEmpty()) {
				temp.value.add(stack.pop());
			}
			
			for(int z = 0; z < placeCount; z++) {
				temp.value.add(0);
			}
			placeCount++;
			//System.out.println("temp: " + temp.toString());
			result = new ArrayLargeInteger(result.add(temp).toString());
			//System.out.println("result: " + result.toString());
		}
		
		
		//Use sign flag to determine sign
		result.isNegative = signFlag;
		//System.out.println("Result: " + result.toString());
		LargeInteger finalResult = new ArrayLargeInteger(result.toString());
		this.value = saveMe.value; //bandaid
		this.isNegative = saveMe.isNegative;
		return finalResult;
	}
	@Override
	public LargeInteger max(LargeInteger arg) {
		ArrayLargeInteger comp = new ArrayLargeInteger(arg.toString());
		if(this.equals(comp)) {
			return this;
		}
		if(this.signum() < comp.signum()) {
			return comp;
		}
		if(this.signum() > comp.signum()) {
			return this;
		}
		if(this.value.size() == comp.value.size()) {
			for(int i = 0; i < this.value.size(); i++) {
				int temp = Integer.compare(this.value.get(i), comp.value.get(i));
				if (temp == 0) {
					continue;
				}
				else {
					if(temp > 0) {
						return this;
					}
					else return comp;
				}
			}
		}
		if (this.value.size() > comp.value.size()) {
			return this;
		}
		else return comp;
	}
	@Override
	public LargeInteger min(LargeInteger arg) {
		LargeInteger max = this.max(arg);
		if(max.equals(this)) {
			return arg;
		}
		return this;
	}
	@Override
	public int signum() {
		if(this.toString().equals("0")) {
			return 0;
		}
		else if (this.isNegative) {
			return -1;
		}
		return 1;
	}
	@Override
	public String toString() {
		String str = "";
		if(this.isNegative) {
			str += "-";
		}
		for(int i = 0; i<value.size(); i++) {
			str += value.get(i);
		}
		return str;
	}
	public boolean equals(LargeInteger arg) {
		ArrayLargeInteger comp = new ArrayLargeInteger(arg.toString());
		String str1 = this.toString();
		String str2 = comp.toString();
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}
	@Override
	public int compareTo(LargeInteger arg) {
		if (this.equals(arg)) {
			return 0;
		}
		if (this.max(arg).equals(this)) {
			return 1;
		}
		return -1;
	}
	/**
	 * helper method used to remove leading zeros after operations
	 */
	private void removeLeadingZeros() {
		while (this.value.indexOf(0) == 0) {
			this.value.remove(0);
		}
		if (this.value.isEmpty()) {
			this.value.add(0);
		}

	}
	/**
	 * Compares the absolute value of two numbers
	 * @param i1 first number
	 * @param i2 second number
	 * @return returns the .compareTo result of the absolute value of the two numbers
	 */
	private int absValComp(LargeInteger i1, LargeInteger i2) {
		ArrayLargeInteger abs1 = new ArrayLargeInteger(i1.toString());
		ArrayLargeInteger abs2 = new ArrayLargeInteger(i2.toString());
		abs1.abs();
		//System.out.println(abs1.toString());
		abs2.abs();
		//System.out.println(abs2.toString());
		return abs1.compareTo(abs2);

	}
	/**
	 * Flips the sign of the ArrayLargeInteger provided
	 * @param arg number to be sign flipped
	 */
	private static void flipSign(ArrayLargeInteger arg) {
		if(arg.isNegative) {
			arg.isNegative = false;
		} else arg.isNegative = true;
	}

}
