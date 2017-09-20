package com.run_te;

import java.util.Arrays;

public class t3 {

	public static void main(String[] args) {
//		int[] nums = { 1, 3, 4 };
//
//		System.out.println(Arrays.binarySearch(nums, 0, 3, 4));
		
		testTryCatch();
		
		
//		System.out.println(Integer.parseInt("2817.09898"));

	}

	static int testTryCatch() {
		int ret = 0;
		try {
			throw new Exception();
		} catch (Exception e) {
			ret = 1;
			return ret;
		} finally {
			ret = 2;
			System.out.println("finally");
		}
	}
}
