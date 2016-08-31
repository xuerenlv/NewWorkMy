/**
 * 
 */
package com.math_question;

/**
 * @author Xuehj
 *
 */
public class Super_Pow_372 {

	public static void main(String[] args) {
		Solution_Super_Pow_372 pow_n = new Solution_Super_Pow_372();

		int arr[] = { 2, 0, 0 };

		System.out.println(pow_n.superPow(2147483647, arr));
	}

}

class Solution_Super_Pow_372 {
	public int superPow(int a, int[] b) {

		int rdx = a % 1337;
		int re = 1;

		for (int i = b.length - 1; i >= 0; i--) {
			re = (re * pow(rdx, b[i])) % 1337;
			rdx = pow(rdx, 10) % 1337;
		}

		return re;
	}

	int pow(int base, int exp) {
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;

		int re = pow(base, exp >> 1) % 1337;
		re = (re * re) % 1337;

		if ((exp & 1) == 1) {
			re = (re * base) % 1337;
		}

		return re;
	}

}