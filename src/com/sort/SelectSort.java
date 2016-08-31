package com.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int v[] = { 1, 2, 4, 5, 76, 435, 8775, 3243, 786, 123, 12131, 43523, 354325, 654, 1231, 4234, 131, 1, 2, 4, 5,
				7, 9, 12, 13, 14, 16, 18, 19, 100, 21, 4123, 44, 23, 24, 25, 26, 27, 28, 29, 30, 45, 67, 89, 34, 56,
				345, 657, 34, 65, 76, 122, 433, 2, 11, 43, 65, 77, 12, 0, 45, 32, 111, 3, 5, 2, 1, 6, 8, 232, 12113,
				6576, 435, 8775, 3243, 786, 123, 12131, 43523, 354325, 654, 1231, 4234, 131, 1231, 4234, 131, 2134, 243,
				3241, 32, 421, 4, 43214, 3214, 413, 32, 43, 55, 6 };

		// --------------------------naive-------------------------------------------

		selectSort(v);

		// ---------------------------------------------------------------------

		System.out.println("************************************************");
		System.out.println(Arrays.toString(v));
		System.out.println("************************************************");
	}

	static void selectSort(int[] nums) {
		int e = nums.length - 1;

		for (int i = 0; i < e - 1; i++) {
			int small_index = i + 1;
			for (int j = i + 2; j <= e; j++) {
				if (nums[j] < nums[small_index])
					small_index = j;
			}
			if (nums[i] > nums[small_index]) {
				int temp = nums[i];
				nums[i] = nums[small_index];
				nums[small_index] = temp;
			}
		}

	}

}
