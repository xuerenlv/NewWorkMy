package com.binary_search_question;

public class Find_the_Duplicate_Number_287 {

	public static void main(String[] args) {
		System.out.println(new Solution_Find_the_Duplicate_Number_287().findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
	}

}

class Solution_Find_the_Duplicate_Number_287 {
	// 感觉就是求链表环的起点
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1)
			return -1;
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
//			System.out.println(slow + " " + fast);
		} while (slow != fast);

		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}