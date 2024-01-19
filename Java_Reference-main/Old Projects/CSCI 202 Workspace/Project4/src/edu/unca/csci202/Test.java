package edu.unca.csci202;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Test {

	public static String[] generateStrings(int n, int minLength, int maxLength) {
		Random rand = new Random();
		int genLength = rand.nextInt(maxLength+1-minLength)+minLength; 
		char[] letters = "0123456789".toCharArray();
		String[] gens = new String[n];
		for(int i=0; i<gens.length; i++) {
			gens[i] = "";
		}
		for(int k = 0; k < n; k++) {
			for (int i = 0; i<genLength; i++) {
				gens[k] += letters[rand.nextInt(letters.length)];
			}
		}
		return gens;
	}
	public static void printDoubleArray(double[] ray) {
		for (int i = 0; i < ray.length; i++) {
			System.out.println(ray[i]);
		}
		System.out.println("END");
		System.out.println("END");
		System.out.println("END");
	}
	public static void main(String[] args) {
		
		//Showing how Large Integer Data Scales with Length
		int trials = 1;
		double[] largeResults = new double[trials];
		String[] test = generateStrings(trials, 10000, 10000);
		for (int i = 0; i < test.length; i++) {
			LargeInteger large = new ArrayLargeInteger(test[i]);
			
			long time1 = System.nanoTime();
			large.multiply(large);
			long time2 = System.nanoTime();
			largeResults[i] = ((time2-time1)/1000000000.);
			
		}
		printDoubleArray(largeResults);
		
		/* Interfaces Specified by LargeInteger Interface
		 * add
		 * subtract
		 * negate
		 * abs
		 * multiply
		 * max
		 * min
		 * signum
		 */
//		LargeInteger test = new ArrayLargeInteger("-1234");
//		//System.out.println(test);
//		test.add(test);
//		System.out.println(test);
//		test.subtract(test);
//		System.out.println(test);
//		test.abs();
//		System.out.println(test);
//		test.multiply(test);
//		System.out.println(test);
//		test.max(test);
//		System.out.println(test);
//		test.min(test);
//		System.out.println(test);
//		test.signum();
//		System.out.println(test);
		
//		BigInteger test = new BigInteger("-1234");
//		System.out.println(test);
//		test.add(test);
//		System.out.println(test);
//		test.subtract(test);
//		System.out.println(test);
//		test.abs();
//		System.out.println(test);
//		test.multiply(test);
//		System.out.println(test);
//		test.max(test);
//		System.out.println(test);
//		test.min(test);
//		System.out.println(test);
//		test.signum();
//		System.out.println(test);
		

		//System.out.println(addTest1.add(addTest2).toString());
		//System.out.println(pos.add(neg).toString());
		//System.out.println(neg.add(pos).toString());
		//System.out.println();
		
//		ArrayLargeInteger mult1 = new ArrayLargeInteger("123434343456789600059000000000000");
//		ArrayLargeInteger mult2 = new ArrayLargeInteger("-92233720368547758089");
//		System.out.println(mult1.multiply(mult2));


		/* Interfaces Specified by LargeInteger Interface
		 * add
		 * subtract
		 * negate
		 * abs
		 * multiply
		 * max
		 * min
		 * signum
		 */
//		int trials = 10;
//		String[] test = generateStrings(trials, 1, 100);
//		double[] bigAddResults = new double[trials];
//		double[] largeAddResults = new double[trials];
//		double[] bigSubResults = new double[trials];
//		double[] largeSubResults = new double[trials];
//		double[] bigNegResults = new double[trials];
//		double[] largeNegResults = new double[trials];
//		double[] bigAbsResults = new double[trials];
//		double[] largeAbsResults = new double[trials];
//		double[] bigMultResults = new double[trials];
//		double[] largeMultResults = new double[trials];
//		double[] bigMaxResults = new double[trials];
//		double[] largeMaxResults = new double[trials];
//		double[] bigMinResults = new double[trials];
//		double[] largeMinResults = new double[trials];
//		double[] bigSigResults = new double[trials];
//		double[] largeSigResults = new double[trials];
//		//System.out.println(Arrays.toString(test));
//		for (int i = 0; i < test.length; i++) {
//			BigInteger big = new BigInteger(test[i]);
//			LargeInteger large = new ArrayLargeInteger(test[i]);
//			
//			//ADD
//			long time1 = System.nanoTime();
//			big.add(big);
//			long time2 = System.nanoTime();
//			bigAddResults[i] = ((time2-time1)/1000000000.);
//			//System.out.println("Big Add Time:   " + (time1-time2)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.add(large);
//			time2 = System.nanoTime();
//			largeAddResults[i] = ((time2-time1)/1000000000.);
//			//System.out.println("Large Add Time: " + (time1-time2)/1000000000.);
//			
//			//SUBTRACT
//			time1 = System.nanoTime();
//			big.subtract(big);
//			time2 = System.nanoTime();
//			bigSubResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.subtract(large);
//			time2 = System.nanoTime();
//			largeSubResults[i] = ((time2-time1)/1000000000.);
//			
//			//NEGATE
//			time1 = System.nanoTime();
//			big.negate();
//			time2 = System.nanoTime();
//			bigNegResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.negate();
//			time2 = System.nanoTime();
//			largeNegResults[i] = ((time2-time1)/1000000000.);
//			
//			//ABS
//			time1 = System.nanoTime();
//			big.abs();
//			time2 = System.nanoTime();
//			bigAbsResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.abs();
//			time2 = System.nanoTime();
//			largeAbsResults[i] = ((time2-time1)/1000000000.);
//			
//			//MULTIPLY
//			time1 = System.nanoTime();
//			big.multiply(big);
//			time2 = System.nanoTime();
//			bigMultResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.multiply(large);
//			time2 = System.nanoTime();
//			largeMultResults[i] = ((time2-time1)/1000000000.);
//			
//			//MAX
//			time1 = System.nanoTime();
//			big.max(big);
//			time2 = System.nanoTime();
//			bigMaxResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.max(large);
//			time2 = System.nanoTime();
//			largeMaxResults[i] = ((time2-time1)/1000000000.);
//			
//			//MIN
//			time1 = System.nanoTime();
//			big.min(big);
//			time2 = System.nanoTime();
//			bigMinResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.min(large);
//			time2 = System.nanoTime();
//			largeMinResults[i] = ((time2-time1)/1000000000.);
//			
//			//SIGNUM
//			time1 = System.nanoTime();
//			big.signum();
//			time2 = System.nanoTime();
//			bigSigResults[i] = ((time2-time1)/1000000000.);
//			
//			time1 = System.nanoTime();
//			large.signum();
//			time2 = System.nanoTime();
//			largeSigResults[i] = ((time2-time1)/1000000000.);
//			
//		}
//		System.out.println("Add Results");
//		System.out.println("Add Results");
//		System.out.println("Add Results");
//		printDoubleArray(bigAddResults);
//		printDoubleArray(largeAddResults);
//		
//		System.out.println("Subtraction Results");
//		System.out.println("Subtraction Results");
//		System.out.println("Subtraction Results");
//		printDoubleArray(bigSubResults);
//		printDoubleArray(largeSubResults);
//		
//		System.out.println("Negate Results");
//		System.out.println("Negate Results");
//		System.out.println("Negate Results");
//		printDoubleArray(bigNegResults);
//		printDoubleArray(largeNegResults);
//		
//		System.out.println("ABS Results");
//		System.out.println("ABS Results");
//		System.out.println("ABS Results");
//		printDoubleArray(bigAbsResults);
//		printDoubleArray(largeAbsResults);
//		
//		System.out.println("Multiply Results");
//		System.out.println("Multiply Results");
//		System.out.println("Multiply Results");
//		printDoubleArray(bigMultResults);
//		printDoubleArray(largeMultResults);
//		
//		System.out.println("Max Results");
//		System.out.println("Max Results");
//		System.out.println("Max Results");
//		printDoubleArray(bigMaxResults);
//		printDoubleArray(largeMaxResults);
//		
//		System.out.println("Min Results");
//		System.out.println("Min Results");
//		System.out.println("Min Results");
//		printDoubleArray(bigMinResults);
//		printDoubleArray(largeMinResults);
//		
//		System.out.println("Signum Results");
//		System.out.println("Signum Results");
//		System.out.println("Signum Results");
//		printDoubleArray(bigSigResults);
//		printDoubleArray(largeSigResults);
//		
//		String test = "123434343456789600059000000000000";
//		String testArg = "-92233720368547758089";
		//String test = "581723509918123984797283848729384724724724727472739784287349283472772777109487150";
		//String testArg = "2384690167";
		//String test = "812309471";
		//String testArg = "786580956907578687484158484698546854698541689651487913564896513";
		
//		BigInteger big = new BigInteger(test);
//		LargeInteger large = new ArrayLargeInteger(test);
//		
//		BigInteger bigArg = new BigInteger(testArg);
//		LargeInteger largeArg = new ArrayLargeInteger(testArg);
//		
//		System.out.println("BigInteger:   " + big);
//		System.out.println("LargeInteger: " + large);
//		System.out.println("BigIntegerArg:   " + bigArg);
//		System.out.println("LargeIntegerArg: " + largeArg);
//		
		/* Interfaces Specified by LargeInteger Interface
		 * add
		 * subtract
		 * negate
		 * abs
		 * multiply
		 * max
		 * min
		 * signum
		 */
		//ADD
//		long time1 = System.nanoTime();
//		BigInteger bigResult = big.add(bigArg);
//		long time2 = System.nanoTime();
//		System.out.println("Big Add Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		LargeInteger largeResult = large.add(largeArg);
//		time2 = System.nanoTime();
//		System.out.println("Large Add Time: " + (time1-time2)/1000000000.);
		
		//SUBTRACT
//		time1 = System.nanoTime();
//		big.subtract(bigArg);
//		time2 = System.nanoTime();
//		System.out.println("Big Subtract Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.subtract(largeArg);
//		time2 = System.nanoTime();
//		System.out.println("Large Subtract Time: " + (time1-time2)/1000000000.);
		
		//NEGATE
//		time1 = System.nanoTime();
//		big.negate();
//		time2 = System.nanoTime();
//		System.out.println("Big Negate Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.negate();
//		time2 = System.nanoTime();
//		System.out.println("Large Negate Time: " + (time1-time2)/1000000000.);
		
		//ABS
//		time1 = System.nanoTime();
//		big.abs();
//		time2 = System.nanoTime();
//		System.out.println("Big ABS Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.abs();
//		time2 = System.nanoTime();
//		System.out.println("Large ABS Time: " + (time1-time2)/1000000000.);
		
		//MULTIPLY
//		time1 = System.nanoTime();
//		big.multiply(bigArg);
//		time2 = System.nanoTime();
//		System.out.println("Big Multiply Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.multiply(largeArg);
//		time2 = System.nanoTime();
//		System.out.println("Large Multiply Time: " + (time1-time2)/1000000000.);
		
		//MAX
//		time1 = System.nanoTime();
//		big.max(bigArg);
//		time2 = System.nanoTime();
//		System.out.println("Big Max Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.max(largeArg);
//		time2 = System.nanoTime();
//		System.out.println("Large Max Time: " + (time1-time2)/1000000000.);
		
		//MIN
//		time1 = System.nanoTime();
//		big.min(bigArg);
//		time2 = System.nanoTime();
//		System.out.println("Big Min Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.min(largeArg);
//		time2 = System.nanoTime();
//		System.out.println("Large Min Time: " + (time1-time2)/1000000000.);
		
		//SIGNUM
//		time1 = System.nanoTime();
//		big.signum();
//		time2 = System.nanoTime();
//		System.out.println("Big Signum Time:   " + (time1-time2)/1000000000.);
//		
//		time1 = System.nanoTime();
//		large.signum();
//		time2 = System.nanoTime();
//		System.out.println("Large Signum Time: " + (time1-time2)/1000000000.);
		
//		System.out.println("BigInteger:   " + big);
//		System.out.println("LargeInteger: " + large);
//		System.out.println("BigIntegerArg:   " + bigArg);
//		System.out.println("LargeIntegerArg: " + largeArg);
//		System.out.println("BigInteger Result:   " + bigResult);
//		System.out.println("LargeInteger Result: " + largeResult);
		
		
		
		
		
		
		
		

		// Creates Random Test Cases 
		// (Used to test add/subtract/multiply while they were still not working)
		int caseNum = 0;
		for (int i = 0; i < caseNum; i++) {

			Random rand = new Random();
			int max = 9999;
			int min = -9999;
			int rnum1 = rand.nextInt(max - min + 1) + min;
			int rnum2 = rand.nextInt(max - min + 1) + min;
			
			//Override random values to test specific ones
//			rnum1 = 5331;
//			rnum2 = 8505;
			
			//		System.out.println(rnum1);
			//		System.out.println(rnum2);

			String str1 = String.valueOf(rnum1);
			String str2 = String.valueOf(rnum2);
			//		System.out.println(str1);
			//		System.out.println(str2);

			ArrayLargeInteger testAdd = new ArrayLargeInteger(str1);
			ArrayLargeInteger test2Add = new ArrayLargeInteger(str2);

			//Addition
			int regularSum = rnum1 + rnum2;
			LargeInteger largeSum = testAdd.add(test2Add);
			int largeSumInt = Integer.parseInt(largeSum.toString());
			
			if(regularSum != largeSumInt) {
				System.out.println("Bad Addition at iteration: " + (i+1));
				System.out.println("Random Number 1: " + rnum1);
				System.out.println("Random Number 2: " + rnum2);
				System.out.println("Regular Sum: " + regularSum);
				System.out.println("Large Integer Sum: " + largeSumInt);
				System.out.println();
			}

			//Subtraction
			ArrayLargeInteger testSub = new ArrayLargeInteger(str1);
			ArrayLargeInteger test2Sub = new ArrayLargeInteger(str2);
			int regularDif = rnum1 - rnum2;
			LargeInteger largeDif = testSub.subtract(test2Sub);
			int largeDifInt = Integer.parseInt(largeDif.toString());
			
			if(regularDif != largeDifInt) {
				System.out.println("Bad Subtraction at iteration: " + (i+1));
				System.out.println("Random Number 1: " + rnum1);
				System.out.println("Random Number 2: " + rnum2);
				System.out.println("Regular Difference: " + regularDif);
				System.out.println("Large Integer Difference: " + largeDifInt);
				System.out.println();
			}
			
			//Multiplication (Mostly Untested)
			ArrayLargeInteger testMult = new ArrayLargeInteger(str1);
			ArrayLargeInteger test2Mult = new ArrayLargeInteger(str2);
			int regularProduct = rnum1 * rnum2;
			LargeInteger largeProduct = testMult.multiply(test2Mult);
			int largeProductInt = Integer.parseInt(largeProduct.toString());
			
			if(regularProduct != largeProductInt) {
				System.out.println("Bad Multiplication at iteration: " + (i+1));
				System.out.println("Random Number 1: " + rnum1);
				System.out.println("Random Number 2: " + rnum2);
				System.out.println("Regular Product: " + regularProduct);
				System.out.println("Large Integer Product: " + largeProductInt);
				System.out.println();
			}
			
		}
		//System.out.println("Test Completed");



	}

}
