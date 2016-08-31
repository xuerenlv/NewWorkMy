package com.dynamic_programing;

public class Regular_Expression_Matching_10 {

	public static void main(String[] args) {
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("aab", "c*a*b"));
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("ab", ".*"));
		System.out.println(new Solution_Regular_Expression_Matching_10().isMatch("aa", ".*"));
	}

}

class Solution_Regular_Expression_Matching_10 {
	
	//  回溯法
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		if (p.length() >= 2 && p.charAt(1) == '*') {
			// '*' Matches zero or more of the preceding element.
			while (s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
				if (isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		} else if (s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
			return isMatch(s.substring(1), p.substring(1));
		}
		return false;
	}
	
	
	
	// 动态规划
	public boolean isMatch_dy(String s, String p) {
		int m=s.length(),n=p.length();
		boolean dp[][] = new boolean[m+1][n+1];

		dp[0][0]=true;
		
		for (int j = 1; j <= n; j++)
          dp[0][j] = '*' == p.charAt(j - 1) && dp[0][j - 2];
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(p.charAt(j-1) != '*'){
					dp[i][j] = dp[i-1][j-1] && (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.');
				}else{
					// 对应 对 前一个字符 匹配多次  ((s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && dp[i - 1][j]);
					dp[i][j] = dp[i][j-2] || ((s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && dp[i - 1][j]);
				}
			}
		}
		
		return dp[m][n];
	}
}

