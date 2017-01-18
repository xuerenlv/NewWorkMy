package com.back_tracking_question;

import java.util.Arrays;

public class Combination_Sum_IV_377 {

	public static void main(String[] args) {

	}

}

class Solution_Combination_Sum_IV_377 {
	public int combinationSum4_digui(int[] nums, int target) {
		if (target == 0) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += combinationSum4(nums, target - nums[i]);
			}
		}
		return res;
	}

	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res = new int[target + 1];
		for (int i = 1; i < res.length; i++) {
			for (int num : nums) {
				if (num > i)
					break;
				else if (num == i)
					res[i] += 1;
				else
					res[i] += res[i - num];
			}
		}
		return res[target];
	}
	
//	public int combinationSum_dp(int[] nums, int target) {
//		Arrays.sort(nums);
//		
//		int[][] res = new int[target + 1][nums.length+1];
//		for (int i = 1; i < res.length; i++) {
//			for(int j=1;j<nums.length;j++){
//				if (nums[j] > i){
//					res[i][j] = res[i][j-1];
//					break;
//				}else if (nums[j] == i)
//					res[i][j] = res[i-1][j]+1;
//				else
//					res[i][j] = res[i-nums[j]][j]+res[nums[j]][j];
//			}
//		}
//		
//		return res[target][nums.length];
//	}
}