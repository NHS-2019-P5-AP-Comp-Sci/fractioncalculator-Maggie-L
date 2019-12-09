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
			// This allows the user to enter as many equations as they want
			System.out.println("Please enter your equation:");
			String equation = userInput.nextLine();
			// reads the input of the user and uses the method to return a value
			System.out.println(produceAnswer(equation));
			value = userInput.nextLine();
		}

	}

	public static String produceAnswer(String input) {
		//Splits the user input into 3 parts
		int first = input.indexOf(" ");
		String firstNumber = input.substring(0, first);
		String operators = input.substring(first + 1, first + 2);
		String secondNumber = input.substring(first + 3);
		// Splits the second number into 3 parts
		String whole = "0";
		String numerator = "0";
		String denominator = "1";
		char op = operators.charAt(0);
		int length = secondNumber.length();
		int i = 0;
		int j = 0;
		while (i < length) {
			if (secondNumber.substring(i, i + 1).equals("_")) {
				j = i + 1;
				i = length + 1;
			}
			i++;
		}
		int k = 0;
		int p = 0;
		while (k < length) {
			if (secondNumber.substring(k, k + 1).equals("/")) {
				p = k + 1;
				k = length + 1;
			}
			k++;
		}
		if (j == 0) {
			j = 1;
		}
		if (p == 0) {
			p = 1;
		}
		if (secondNumber.substring(j - 1, j).equals("_")) {
			whole = secondNumber.substring(0, j - 1);
			numerator = secondNumber.substring(j, p - 1);
			denominator = secondNumber.substring(p);
		} else if (secondNumber.substring(p - 1, p).equals("/")) {
			numerator = secondNumber.substring(0, p - 1);
			denominator = secondNumber.substring(p);
		} else {
			whole = secondNumber;
		}
		
		//Splits the first number into 3 parts 
		String fwhole = "0";
		String fnumerator = "0";
		String fdenominator = "1";
		int flength = firstNumber.length();
		int fi = 0;
		int fj = 0;
		while (fi < flength) {
			if (firstNumber.substring(fi, fi + 1).equals("_")) {
				fj = fi + 1;
				fi = flength + 1;
			}
			fi++;
		}
		int fk = 0;
		int fp = 0;
		while (fk < flength) {
			if (firstNumber.substring(fk, fk + 1).equals("/")) {
				fp = fk + 1;
				fk = flength + 1;
			}
			fk++;
		}
		if (fj == 0) {
			fj = 1;
		}
		if (fp == 0) {
			fp = 1;
		}
		if (firstNumber.substring(fj - 1, fj).equals("_")) {
			fwhole = firstNumber.substring(0, fj - 1);
			fnumerator = firstNumber.substring(fj, fp - 1);
			fdenominator = firstNumber.substring(fp);
		} else if (firstNumber.substring(fp - 1, fp).equals("/")) {
			fnumerator = firstNumber.substring(0, fp - 1);
			fdenominator = firstNumber.substring(fp);
		} else {
			fwhole = firstNumber;
		}


		int iWhole = 0;
		int iDen = 0;
		int ifNum = 0;
		int isNum = 0;
		int fNum = 0;
		String answer = "0";
		// Deals with the negative and postive values of the numbers
		int sign = 1;
		int fSign = 1;
		int sSign = 1;
		if (firstNumber.charAt(0) == '-') {
			sign = -1;
			fSign = -1;
		}
		if (secondNumber.charAt(0) == '-') {
			sign *= (-1);
			sSign = -1;
		}
		//turns every number to an integer and positive
		int fw = Math.abs(Integer.parseInt(fwhole));
		int w = Math.abs(Integer.parseInt(whole));
		int fd = Integer.parseInt(fdenominator);
		int d = Integer.parseInt(denominator);
		int fn = Math.abs(Integer.parseInt(fnumerator));
		int n = Math.abs(Integer.parseInt(numerator));
		// turns the number into an improper fraction with the same denominator
		ifNum = (fd * fw + fn) * d * fSign;
		isNum = (d * w + n) * fd * sSign;
		iDen = fd * d;

		//does the operation
		if (operators.substring(0).equals("+")) {
			fNum = ifNum + isNum;
		}

		if (operators.substring(0).equals("-")) {
			fNum = ifNum - isNum;
		}

		if (operators.substring(0).equals("*")) {
			fNum = ifNum * isNum;
			iDen = iDen * iDen;

		}

		if (operators.substring(0).equals("/")) {
			fNum = ifNum * iDen;
			iDen = iDen * isNum;

		}
		//turns the answer back into a mixed number
		iWhole = Math.abs(fNum) / Math.abs(iDen);

		// puts the correct sign on the number, ie. postive or negative
		if ((fNum < 0 || iDen < 0) && (op == '*' || op == '/')) {
			iWhole = iWhole * sign;
		}
		if ((op == '+' || op == '-') && fNum < 0) {
			iWhole = iWhole * (-1);
			System.out.println(iWhole);
		}
		fNum = fNum % iDen;
		iDen = Math.abs(iDen);
		if (iWhole == 0 && op == '/' || op == '*') {
			fNum = fNum * sign;
		}

		//simplifies the fraction
		for (int divisor = Math.abs(fNum); divisor > 0; divisor--) {
			if (fNum % divisor == 0 && iDen % divisor == 0) {
				fNum = fNum / divisor;
				iDen = iDen / divisor;
			}
		}
		
		// puts the answer in the right format
		if (fNum == 0) {
			answer = (iWhole + "");
		} else if (iWhole == 0) {
			answer = (fNum + "/" + iDen);
		} else {
			answer = (iWhole + "_" + Math.abs(fNum) + "/" + iDen);
		}

		return answer;
	}

}
