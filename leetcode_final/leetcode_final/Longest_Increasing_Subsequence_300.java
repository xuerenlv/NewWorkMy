package leetcode_final;

import java.util.ArrayList;

/**
 * Created by Xuehj on 16/6/14.
 */
public class Longest_Increasing_Subsequence_300 {
	public static void main(String[] a) {
		int[] nums = { 1, 7, 3, 5, 9, 4, 8 };

		System.out.println(new Solution_Longest_Increasing_Subsequence_300().lengthOfLIS(nums));
		System.out.println(new Solution_Longest_Increasing_Subsequence_300().lengthOfLIS_2(nums));
	}
}

class Solution_Longest_Increasing_Subsequence_300 {

	// 尝试使用二维动态规划解决
	
	public int lengthOfLIS_2(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int n = nums.length;
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (nums[i - 1] > nums[j - 1] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		return dp[n];
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;

		ArrayList<Integer> con = new ArrayList<>();
		con.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			System.out.println(con.toString());
			if (nums[i] <= con.get(0)) {
				con.set(0, nums[i]);
			} else if (nums[i] >= con.get(con.size() - 1)) {
				con.add(nums[i]);
			} else {
				int j = 0;
				for (; j < con.size(); j++) {
					if (nums[i] <= con.get(j))
						break;
				}
				con.set(j, nums[i]);
			}
		}

		return con.size();
	}
}
