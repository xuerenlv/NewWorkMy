package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuehj on 16/6/27.
 */
public class Remove_Invalid_Parentheses_301 {
	public static void main(String[] a) {
		String s = "()())()";

		List<String> res = new Solution_Remove_Invalid_Parentheses_301().removeInvalidParentheses(s);
		System.out.println(res.toString());
	}
}

// very good , accepted
class Solution_Remove_Invalid_Parentheses_301 {
	
	
	// 完全的回溯法
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		int[] minimum = new int[1];
		minimum[0] = Integer.MAX_VALUE;

		int start = 0, end = s.length() - 1, zuo_kuohao_num = 0, cur_change = 0;
		String cur = "";
		back_tracking(s, start, end, minimum, zuo_kuohao_num, res, cur_change, cur);
		return res;
	}

	private void back_tracking(String s, int start, int end, int[] minimum, int zuo_kuohao, List<String> res,
			int cur_change, String cur) {
		if (start > end) {
			if (zuo_kuohao == 0) {
				if (cur_change == minimum[0]) {
					if (!res.contains(cur)) {
						res.add(cur);
					}
				}
				if (cur_change < minimum[0]) {
					minimum[0] = cur_change;
					res.clear();
					res.add(cur);
				}
			}
			return;
		}

		if (s.charAt(start) == '(') {
			back_tracking(s, start + 1, end, minimum, zuo_kuohao + 1, res, cur_change, cur + "(");
			back_tracking(s, start + 1, end, minimum, zuo_kuohao, res, cur_change + 1, cur);
			return;
		}
		if (s.charAt(start) == ')') {
			if (zuo_kuohao != 0)
				back_tracking(s, start + 1, end, minimum, zuo_kuohao - 1, res, cur_change, cur + ")");
			back_tracking(s, start + 1, end, minimum, zuo_kuohao, res, cur_change + 1, cur);
			return;
		}

		back_tracking(s, start + 1, end, minimum, zuo_kuohao, res, cur_change, cur + s.charAt(start));
	}
}