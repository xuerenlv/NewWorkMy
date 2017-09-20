package com.array_question;

import java.util.ArrayList;
import java.util.List;

public class Longest_Consecutive_Sequence_128 {

	public static void main(String[] args) {
		int[] nums = { 0, -1 };
		System.out.println(new Solution_Longest_Consecutive_Sequence_128().longestConsecutive(nums));
	}

}

class Solution_Longest_Consecutive_Sequence_128 {
	// 这个就是运用了一个 list 的查找与删除
	// 对于每一个元素进行前后向搜索，因为搜索的同时进行删除，所以不会出现一个元素被搜索了两次
	public int longestConsecutive(int[] nums) {
		List<Integer> container = new ArrayList<Integer>();
		for (int i : nums) {
			container.add(i);
		}

		int res = 0;
		int l1, l2;
		while (!container.isEmpty()) {
			int num = container.remove(0);
			l1 = num + 1;
			l2 = num - 1;
			while (container.contains(l1)) {
				container.remove((Integer) l1);
				l1++;
			}
			while (container.contains(l2)) {
				container.remove((Integer) l2);
				l2--;
			}
			res = Math.max(res, l1 - l2 - 1);
		}

		return res;
	}
}