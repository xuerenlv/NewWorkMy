package com.array_question;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array_215 {

	public static void main(String[] args) {

	}

}

class Solution_Kth_Largest_Element_in_an_Array_215 {

	public int findKthLargest_2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k)
			return Integer.MAX_VALUE;
		return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
	}

	public int findKthLargest(int[] nums, int start, int end, int k) {
		int i = start;
		int j = end;

		int x = nums[i]; // 取左边元素为划分元素
		while (i < j) {
			while (i < j && nums[j] > x) {
				j--;
			}
			if (i < j) {
				nums[i] = nums[j];
				i++;
			}
			while (i < j && nums[i] < x) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = x;

		if (i == k) {
			return x;
		} else if (i < k) {
			return findKthLargest(nums, i + 1, end, k);
		} else {
			return findKthLargest(nums, start, i - 1, k);
		}
	}

	// ***********************************************************
	public int findKthLargest(int[] nums, int k) {
		int[] k_num = new int[k];

		for (int i = 0; i < k; i++) {
			k_num[i] = nums[i];
		}

		// 这里用的是一个优先级队列的思想
		Arrays.sort(k_num);
		int num;
		for (int i = k; i < nums.length; i++) {
			num = nums[i];
			if (num <= k_num[0])
				continue;
			insert(k_num, num);
		}

		return k_num[0];
	}

	void insert(int[] nums, int num) {
		int len = nums.length;
		nums[0] = num;// 最小值覆盖，然后进行一个排序
		for (int i = 0; i < len - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				swap(nums, i, i + 1);
			}
		}
	}

	void swap(int[] num, int i, int j) {
		int temp;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}