package com.sort;

import java.util.Arrays;

public class ni_xu_dui {

	public static void main(String[] args) {
		System.out.println(inverse_num(new int[] { 7, 88, 12, 43, 63, 1, 1, 6, 75, 21, 6, 5, 6, 4 }));
	}

	static int inverse_num(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] cp = new int[nums.length];
		System.arraycopy(nums, 0, cp, 0, nums.length);

		return inverse_pair_core(nums, cp, 0, nums.length - 1);
	}

	static int inverse_pair_core(int[] nums, int[] cp, int start, int end) {
		if (start == end)
			return 0;

		int len = (end - start) >> 1;
		int left = inverse_pair_core(nums, cp, start, start + len);
		int right = inverse_pair_core(nums, cp, start + len + 1, end);

		int i = start + len;
		int j = end;
		int indexcopy = end;
		int count = 0;

		while (i >= start && j >= start + len + 1) {
			if (nums[i] > nums[j]) {
				cp[indexcopy--] = nums[i--];
				count += j - start - len;
			} else {
				cp[indexcopy--] = nums[j--];
			}
		}

		while (i >= start) {
			cp[indexcopy--] = nums[i];
			i--;
		}
		while (j >= start + len + 1) {
			cp[indexcopy--] = nums[j];
			j--;
		}

		return left + right + count;
	}

}
