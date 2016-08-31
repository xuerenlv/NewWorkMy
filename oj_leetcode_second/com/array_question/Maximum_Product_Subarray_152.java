package com.array_question;

public class Maximum_Product_Subarray_152 {

	public static void main(String[] args) {
		int[] nums = { -2, 3, -4 };
		System.out.println(new Solution_Maximum_Product_Subarray_152().maxProduct(nums));
	}

}

class Solution_Maximum_Product_Subarray_152 {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int max_local = nums[0];
		int min_local = nums[0];
		int global = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int max_copy = max_local;
			// 因为这里是乘积，所以要同时纪录最大值与最小值
			max_local = Math.max(Math.max(max_copy * nums[i], nums[i]), min_local * nums[i]);
			min_local = Math.min(Math.min(max_copy * nums[i], nums[i]), min_local * nums[i]);
			global = Math.max(global, max_local);
		}

		return global;
	}
}