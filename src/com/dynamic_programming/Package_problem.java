package com.dynamic_programming;

public class Package_problem {

	public static void main(String[] args) {
		int[] A = {3,2,5,32,1,21,4};
		System.out.println(new package_pro().backPack(100, A));
	}

}

class package_pro {

	// m:背包大小
	// items: 物品的大小
	public int backPack(int m, int[] A) {
		int[][] dp = new int[m + 1][A.length];

		for (int j = 1; j <= m; j++) {
			if (A[0] <= j) {
				dp[j][0] = A[0];
			}
			for (int i = 1; i < A.length; i++) {
				if (A[i] > j) {
					dp[j][i] = dp[j][i - 1];
				} else {
					dp[j][i] = Math.max(dp[j - A[i]][i-1] + A[i], dp[j][i - 1]);
				}
			}
		}
		return dp[m][A.length - 1];
	}

}