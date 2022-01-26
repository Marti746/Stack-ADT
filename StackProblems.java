import java.util.Arrays;
/**
 * 
 * @author David Martin
 * Ready to be put on GitHub
 * Stack Implementations with problems to show full range of stack Data Structure
 *
 */

public class StackProblems {

	public static void main(String[] args) {

		// Do initial testing here.
		// For example, here is a basic test of the sum method:
		ArrayStack<Integer> stk;

		stk = new ArrayStack<>();
		stk.push(4);
		stk.push(1);
		stk.push(2);
		stk.push(2);
		stk.push(7);
		stk.push(2);
		stk.push(8);
		stk.push(8);
		stk.push(8);
		stk.push(4);

		//Integer[] nums = stk.toArray();
		//System.out.println("46? " + sum(stk));
		//pushUnder(stk, 5);
		//System.out.println(stk);
		//System.out.println(copyStack(stk));
		//System.out.print("28?" + sumSkipDuplicates(stk));
		System.out.println(stringToStack("41aa22728884"));		
	}

	/*
	 * Computes the sum of all the numbers in the ArrayStack. 
	 * It's okay to destroy the ArrayStack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		if (data.isEmpty()) return 0;
		int sum = data.pop();
		while (!data.isEmpty())
			sum += data.pop();
		return sum;
	}

	/*
	 * Puts an integer under the top item in an ArrayStack. 
	 * If the ArrayStack is empty, just put the item on the top. 
	 * For example: if 		stk starting at the top is: 7, 8, 5, 11, 
	 * 				then 	pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11
	 * 
	 * For example: if 		stk is empty,  
	 * 				then 	pushUnder(stk, 20) would result in: 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		if (data.isEmpty())	{
			data.push(value);
		} else {
			int top = data.pop();
			data.push(value);
			data.push(top);
		}
	}


	/*
	 * Computes the sum of all the numbers in the ArrayStack. However, if two or
	 * more numbers in a row are equal, only add one of them. So, for example, if the
	 * ArrayStack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would
	 * be added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		if (data.isEmpty()) {
			return 0;
		}
		//int sum,last = data.pop();
		int sum, last, top;
		last = sum = data.pop();
		while (!data.isEmpty()) {
			top = data.pop();
			if (top != last) {
				sum += top;
				last = top;
			}
		} // end while
		return sum;
	} // end sumSkipDuplicates

	/*
	 * Puts all of the characters of a string into an ArrayStack, with the first
	 * character of the string at the bottom of the ArrayStack and the last character
	 * of the string at the top of the ArrayStack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> words = new ArrayStack<>();
		for (int i = 0; i < s.length(); i++) {
			Character temp = (s.charAt(i));
			words.push(temp);
		}
		return words;
	}

	/*
	 * Returns an exact copy of the given ArrayStack.  At the end of this method
	 * the original stack should be the same as when it started, and a new copy
	 * of that ArrayStack should be returned.  YOU MAY USE ADDITIONAL ArrayStacks AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		//if (s.isEmpty())	return s;
		ArrayStack<Integer> n = new ArrayStack<>();
		ArrayStack<Integer> ret = new ArrayStack<>();
		while (!s.isEmpty()) {
			n.push(s.pop());
		}
		while (!n.isEmpty()) {
			s.push(n.peek());
			ret.push(n.pop());
		}
		return ret;
	}

	/*
	 * Reverses a given ArrayStack, so that the top of the ArrayStack becomes the bottom
	 * and the bottom becomes the top. YOU MAY USE ADDITIONAL ArrayStack AS NEEDED
	 * BUT YOU MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> temp = new ArrayStack<>();
		ArrayStack<Integer> hold = new ArrayStack<>();
		while(!s.isEmpty()) {
			temp.push(s.pop());
		}
		while(!temp.isEmpty()) {
			hold.push(temp.pop());
		}
		while(!hold.isEmpty()) {
			s.push(hold.pop());
		}
	}

	/*
	 * A palindrome reads the same forward and backward. Use an ArrayStack to
	 * determine if a given string is a palindrome. Challenge: try not to use
	 * any additional variables (except a counter for any loop). Just the given
	 * string and an ArrayStack of Characters.
	 */
	public static boolean isPalindrome(String s) {
		ArrayStack<Character> palin = new ArrayStack<>();
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			palin.push(s.charAt(i));	
		}
		while (!palin.isEmpty()) {
			char temp = palin.pop();
			str += temp;
		}
		if (str.equals(s)) {
			return true;
		} else 	return false;
	
	}

}
