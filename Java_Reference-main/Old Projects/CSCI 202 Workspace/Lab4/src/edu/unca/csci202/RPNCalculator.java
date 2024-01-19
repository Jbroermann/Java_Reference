package edu.unca.csci202;

import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;
/**
 * Intended to evaluate postfix based on user input.
 * @author Ben Yaniero (some of it anyway)
 *
 */
public class RPNCalculator {

    private Stack<Double> calcStack; //Stack used to store input for calculation
    private int operandCount; //is incremented each for each operand seen
    private int operatorCount; //is incremented for each operator seen
    private boolean invalid; //is used to determine if the character was recognizable
    /**
     * constructor
     */
    public RPNCalculator() {
        calcStack = new Stack<Double>();
        this.operandCount = 0;
        this.operatorCount = 0;
        this.invalid = false;
    }
    /**
     * Initiates the calculator process.
     */
    public void run() {
        Scanner inputLineReader = new Scanner(System.in);
        String line = "";
        boolean quit = false;
        
        while (!quit) {
            while (line.equals("")) {
                System.out.print(":::> ");
                line = inputLineReader.nextLine().trim();
            }
            quit = interpretExpression(line);
            //if proper expression, result will be only element on stack
            printResult(quit);
            line = "";
        }
    
    }
    /**
     * Intended to parse through the user input and do the desired calculation
     * Some logic also occurs in the printResult method
     * @param line a single line of user input from console
     * @return returns true if user input is "q"
     */
    private boolean interpretExpression(String line) {
        Scanner lineParser = new Scanner(line);
        String token = "";
        boolean quit = false;
        double operand = 0.0;
        
        while (lineParser.hasNext()) {
            token = lineParser.next();
            //System.out.println("processing token "+token);
            if (token.equals("q")) {
                quit=true;
            }
            else if (token.equals("+")) {
            	this.operatorCount++;
            	try {
                	double right = calcStack.pop();
                	double left = calcStack.pop();
                	calcStack.push(left+right);
            	} catch (java.util.EmptyStackException e) {
            		System.out.println("Invalid input: not enough operands");
            		calcStack.push(Double.NaN);
            	}
            }
            else if (token.equals("-")) {
            	this.operatorCount++;
            	try {
                	double right = calcStack.pop();
                	double left = calcStack.pop();
                	calcStack.push(left-right);
            	} catch (java.util.EmptyStackException e) {
            		System.out.println("Invalid input: not enough operands");
            		calcStack.push(Double.NaN);
            	}
            }
            else if (token.equals("*")) {
            	this.operatorCount++;
            	try {
                	double right = calcStack.pop();
                	double left = calcStack.pop();
                	calcStack.push(left*right);
            	} catch (java.util.EmptyStackException e) {
            		System.out.println("Invalid input: not enough operands");
            		calcStack.push(Double.NaN);
            	}
            }
            else if (token.equals("/")) {
            	this.operatorCount++;
            	try {
                	double right = calcStack.pop();
                	double left = calcStack.pop();
                	calcStack.push(left/right);
            	} catch (java.util.EmptyStackException e) {
            		System.out.println("Invalid input: not enough operands");
            		calcStack.push(Double.NaN);
            	}
            }
            else {
            	this.operandCount++;
            	try{
            		operand = Double.parseDouble(token);
            		calcStack.push(operand);
            	} catch (java.lang.NumberFormatException e){
            		this.invalid = true;
            	}
            }
        }
        return quit;
    }
    /**
     * Should check for too many operands and invalid, which prompts unrecognized character
     * Then pops last element off the stack and prints it
     * clears instance variables
     * @param quit true if user inputs "q" false otherwise
     */
    private void printResult(boolean quit) {
        if (!quit) {
        	
        	
        	if (operandCount != 0 && operandCount > operatorCount+1 && !invalid) {
        		System.out.println("Invalid input: too many operands");
        		while(calcStack.size()!=0) {
        			calcStack.pop();
        		}
        		calcStack.push(Double.NaN);
        	}

        	if (invalid) {
        		System.out.println("Invalid input: unrecognized character");
        		while(calcStack.size()!=0) {
        			calcStack.pop();
        		}
        		calcStack.push(Double.NaN);
        	}
        	
        	
        	
            System.out.println(calcStack.pop());
            this.operandCount = 0;
            this.operatorCount = 0;
            this.invalid = false;
        }
    
    }
    /**
     * main method
     * @param args ignored
     */
    public static void main(String [] args) {
        RPNCalculator calc = new RPNCalculator();
        calc.run();
    }

}
