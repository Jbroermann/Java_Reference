package edu.unca.csci202;
/**
 * Interface for working with large integers.
 * @author Ben Yaniero
 *
 */
public interface LargeInteger extends Comparable<LargeInteger> {

	/**
	 * takes a LargeInteger; returns the LargeInteger sum of this and the argument.
	 * @param arg LargeInteger to be added to this
	 * @return sum of this and arg
	 */
	public LargeInteger add (LargeInteger arg);
	
	/**
	 * takes a LArgeInteger; returns the LargeInteger difference of this and the argument.
	 * @param arg LargeInteger to be subtracted from this
	 * @return difference of this and arg
	 */
	public LargeInteger subtract (LargeInteger arg);
	
	/**
	 * returns the negative of the LargeInteger
	 * @return the negative of the LargeInteger
	 */
	public LargeInteger negate();
	
	/**
	 * returns the absolute value of the LargeInteger
	 * @return the absolute value of the LargeInteger
	 */
	public LargeInteger abs();
	
	/**
	 * takes a LargeInteger; returns the LargeInteger product of this and the argument.
	 * @param arg LargeInteger to be multiplied by this
	 * @return product of this and arg
	 */
	public LargeInteger multiply(LargeInteger arg);
	
	/**
	 * takes a LargeInteger; returns the LargeInteger product of this and the argument.
	 * @param arg LargeInteger to be compared to this
	 * @return the LargeInteger that is the larger of this and arg
	 */
	public LargeInteger max(LargeInteger arg);
	
	/**
	 * takes a LargeInteger; returns the LargeInteger that is the larger of this LargeInteger and the argument.
	 * @param arg LargeInteger to be compared to this
	 * @return the LargeInteger that is the smaller of this and arg
	 */
	public LargeInteger min(LargeInteger arg);
	
	/**
	 * returns: 0 if this LargeInteger equals 0, 1 if it's positive, or -1 if it's negative
	 * @return 0 if this LargeInteger equals 0, 1 if it's positive, or -1 if it's negative
	 */
	public int signum();
	
}
