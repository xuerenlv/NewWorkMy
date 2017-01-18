package com.knap_stack;

public class ZeroOne_AND_Unbounded {
	public static void main(String[] args) {

	}
}

class KnapStack {
	int[] w_arr;
	int[] p_arr;
	int W;

	public KnapStack(int[] wa, int[] pa, int W) {
		w_arr = new int[wa.length];
		p_arr = new int[pa.length];
		this.W = W;

		for (int i = 0; i < wa.length; i++)
			w_arr[i] = wa[i];
		for (int i = 0; i < pa.length; i++)
			p_arr[i] = pa[i];
	}

	// 0-1
	public int bounedKnapStack() {
		int n = w_arr.length;
		int DP[][] = new int[n + 1][W + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= W; j++) {
				if (j < w_arr[i]) {
					DP[i + 1][j] = DP[i][j];
				} else {
					DP[i + 1][j] = Math.max(DP[i][j], DP[i][j - w_arr[i]] + p_arr[i]);
				}
			}
		}

		return DP[n][W];
	}

	// unbounded
	public int unbounedKnapStack() {
		int n = w_arr.length;
		int DP[][] = new int[n + 1][W + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= W; j++) {
				if (j < w_arr[i]) {
					DP[i + 1][j] = DP[i][j];
				} else {
					DP[i + 1][j] = Math.max(DP[i][j], DP[i + 1][j - w_arr[i]] + p_arr[i]);
				}
			}
		}

		return DP[n][W];
	}

}