/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String value = "";
		while (!value.equals("quit")) {
			System.out.println("Please enter your equation:");
			String equation = userInput.nextLine();
			System.out.println(produceAnswer(equation));
			// TODO: Read the input from the user and call produceAnswer with an equation
			value = userInput.nextLine();
		}

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {

		while (input.substring(0, 1).equals(" ")) {

			input = input.substring(1);
		}
		int first = input.indexOf(" ");
		String firstNumber = input.substring(0, first);
		String operators = input.substring(first + 1, first + 2);
		String secondNumber = input.substring(first + 3);
//		String whole = "0";
//		String numerator = "0";
//		String denominator = "1";
//		int length= secondNumber.length();
//		int i =1;
//		int j=0;
//		while (i <length+1 ) {
//			if (secondNumber.substring(i,i+1).equals("_")) {
//				 j=i;
//				i = length+1;	
//			}
//			i++;
//		}
//		int k =1; 
//		int p=0;
//		while (k <length+1 ) {
//			if (secondNumber.substring(k,k+1).equals("/")) {
//				 p=k;
//				k = length+1;	
//			}
//			k++;
//		}
//		//numerator can only be one digit right now. SO FIX THAT !!!
//		if (secondNumber.substring(j, j+1).equals("_")) {
//			whole = secondNumber.substring(0, j);
//			numerator = secondNumber.substring(j+1, k);
//			denominator = secondNumber.substring(j+3);
//		}
//		if (secondNumber.substring(k, k+1).equals("/")) {
//			numerator = secondNumber.substring(0,k);
//			denominator = secondNumber.substring(k+1);
//		}
//
//		System.out.println(length);
//		System.out.println(numerator);
//		System.out.println(denominator);
		// TODO: Implement this function to produce the solution to the input

		return secondNumber;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
