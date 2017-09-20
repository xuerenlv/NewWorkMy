package com.string_manu;

public class Longest_Palindromic_Substring_5 {

	public static void main(String[] args) {
		String s = "xhjxhjxhx";
		System.out.println(new Solution_Longest_Palindromic_Substring_5().longestPalindrome(s));
	}

}

// 子串中的最长回文字符串
class Solution_Longest_Palindromic_Substring_5 {
	public String longestPalindrome_best(String s) {
		int n = s.length();
		String res = null;

		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}

	private int max = 0;
	private String res = "";

	public String longestPalindrome_better(String s) {
		if (s.length() == 1) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			checkPalindromeExpand(s, i, i);
			checkPalindromeExpand(s, i, i + 1);
		}
		return res;
	}

	public void checkPalindromeExpand(String s, int low, int high) {
		while (low >= 0 && high < s.length()) {
			if (s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > max) {
					max = high - low + 1;
					res = s.substring(low, high + 1);
				}
				low--;
				high++;
			} else {
				return;
			}
		}
	}

	// 很强大，看人家的
	public String longestPalindrome(String s) {
		int longest_len = 0;
		String longest = "";

		// 子串长为奇数
		for (int c = 0; c < s.length(); c++) {
			int i = 1;
			int len = 1;
			while (true) {
				int start = c - i;
				int end = c + i;
				if (start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end))
					break;
				len = end - start + 1;
				i += 1;
			}
			if (len > longest_len) {
				longest_len = len;
				longest = s.substring(c - len / 2, c + len / 2 + 1);
			}
		}

		// 子串长为偶数
		for (int c = 0; c < s.length(); c++) {
			int i = 1;
			int len = 0;
			while (true) {
				int start = c - i;
				int end = c + i - 1;
				if (start < 0 || end >= s.length() || s.charAt(start) != s.charAt(end))
					break;
				len = end - start + 1;
				i += 1;
			}
			if (len > longest_len) {
				longest_len = len;
				longest = s.substring(c - len / 2, c + len / 2);
			}
		}

		return longest;
	}
}