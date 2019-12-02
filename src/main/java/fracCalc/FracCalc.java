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
		String whole = "0";
		String numerator = "0";
		String denominator = "1";
		int length= secondNumber.length();
		int i =0;
		int j=0;
		while (i <length) {
			if (secondNumber.substring(i,i+1).equals("_")) {
				 j=i+1;
				i = length+1;	
			}
			i++;
		}
		int k =0; 
		int p=0;
		while (k <length) {
			if (secondNumber.substring(k,k+1).equals("/")) {
				 p=k+1;
				k = length+1;	
			}
			k++;
		}
		if (j==0) {
			j=1;
		}
		if (p==0) {
			p=1;
		}
		if (secondNumber.substring(j-1, j).equals("_")) {
			whole = secondNumber.substring(0, j-1);
			numerator = secondNumber.substring(j, p-1);
			denominator = secondNumber.substring(p);
		}
		else if (secondNumber.substring(p-1, p).equals("/")) {
			numerator = secondNumber.substring(0,p-1);
			denominator = secondNumber.substring(p);
		}
		else {
			whole = secondNumber;
		}
		String fwhole = "0";
		String fnumerator = "0";
		String fdenominator = "1";
		int flength= firstNumber.length();
		int fi =0;
		int fj=0;
		while (fi <flength) {
			if (firstNumber.substring(fi,fi+1).equals("_")) {
				 fj=fi+1;
				fi = flength+1;	
			}
			fi++;
		}
		int fk =0; 
		int fp=0;
		while (fk <flength) {
			if (firstNumber.substring(fk,fk+1).equals("/")) {
				 fp=fk+1;
				fk = flength+1;	
			}
			fk++;
		}
		//numerator can only be one digit right now. SO FIX THAT !!!
		if (fj==0) {
			fj=1;
		}
		if (fp==0) {
			fp=1;
		}
		if (firstNumber.substring(fj-1, fj).equals("_")) {
			fwhole = firstNumber.substring(0, fj-1);
			fnumerator = firstNumber.substring(fj, fp-1);
			fdenominator = firstNumber.substring(fp);
		}
		else if (firstNumber.substring(fp-1, fp).equals("/")) {
			fnumerator = firstNumber.substring(0,fp-1);
			fdenominator = firstNumber.substring(fp);
		}
		else {
			fwhole = firstNumber;
		}
		int iWhole= 0;
		int iDen = 0;
		int ifNum = 0;
		int isNum = 0;
		int fNum = 0;
		String answer= "0";
		int sign = 1;
		int fSign = 1;
		int sSign = 1;				
		if (firstNumber.charAt(0) == '-') { 
			sign = -1;
			 fSign=-1;}
		if (secondNumber.charAt(0) == '-') {
			sign *= (-1);
			 sSign = -1;
		}
		int fw = Math.abs(Integer.parseInt(fwhole));
		int w = Math.abs(Integer.parseInt(whole));
		int fd = Integer.parseInt(fdenominator);
		int d = Integer.parseInt(denominator);
		int fn =Math.abs(Integer.parseInt(fnumerator));
		int n = Math.abs(Integer.parseInt(numerator));
		
		if (operators.substring(0).equals("+")) {
			iWhole = fw*fSign+ w*sSign;
			iDen = fd*d;
			ifNum = fn*d*fSign;
			isNum = (n*fd)*sSign;
			fNum=ifNum*fSign + isNum*fSign;
			iWhole = iWhole + fNum/iDen;
			fNum = fNum%iDen;
				}

		if (operators.substring(0).equals("-")) {
			iWhole = fw*fSign- w*sSign;
			iDen = fd*d;
			ifNum = fn*d*fSign;
			isNum = n*fd*sSign;
			fNum=ifNum*fSign - isNum*sSign;
			iWhole = iWhole + fNum/iDen;
			fNum = fNum%iDen;
				}
		
		if (operators.substring(0).equals("*")) {
			
			ifNum = fd*fw+fn;
			isNum = d*w + n;
			fNum=ifNum*isNum;
			iDen = fd*d;
			iWhole=fNum/iDen;
			fNum=fNum%iDen;
			iWhole = iWhole*sign;
			if (iWhole==0) {
				fNum= fNum*sign;
			}
		}

		if (operators.substring(0).equals("/")) {
			ifNum = fd*fw+fn;
			isNum = d*w + n;
			fNum=ifNum*d;
			iDen = fd*isNum;
			iWhole=fNum/iDen;
			fNum = fNum;
			iDen = iDen;
			fNum=fNum%iDen;
			iWhole = iWhole*sign;
			if (iWhole==0) {
				fNum= fNum*sign;
			}
		}
		
		char op = operators.charAt(0);
		if ((op == '+'|| op=='/'|| op=='-'|| op=='*') && fNum==0) {
		 answer = (iWhole+"");
		}
		else if ((op == '+'|| op=='/'|| op=='-'|| op=='*') && iWhole==0) {
		answer =(fNum + "/"+iDen);
		}
		else if ((op == '+'|| op=='/'|| op=='-'|| op=='*')) {
		answer = (iWhole+"_"+Math.abs(fNum) + "/"+iDen);
		}


		return answer;
	}

}
