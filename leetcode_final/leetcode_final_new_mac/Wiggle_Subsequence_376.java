package leetcode_final_new_mac;

public class Wiggle_Subsequence_376 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Wiggle_Subsequence_376 {
	
	// 对于每一个点 记录两个状态，这样的 dp 没有掌握
	public int wiggleMaxLength_dp(int[] nums) {

		if (nums.length == 0)
			return 0;

		int[] up = new int[nums.length];
		int[] down = new int[nums.length];

		up[0] = 1;
		down[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				up[i] = down[i - 1] + 1;
				down[i] = down[i - 1];
			} else if (nums[i] < nums[i - 1]) {
				down[i] = up[i - 1] + 1;
				up[i] = up[i - 1];
			} else {
				down[i] = down[i - 1];
				up[i] = up[i - 1];
			}
		}

		return Math.max(down[nums.length - 1], up[nums.length - 1]);
	}

	public int wiggleMaxLength(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}
		int result = 2;
		boolean smallReq = nums[k] < nums[k + 1];
		for (int i = k + 1; i < nums.length - 1; i++) {
			if ((smallReq && nums[i + 1] < nums[i]) || (!smallReq && nums[i + 1] > nums[i])) {
				result++;
				smallReq = !smallReq;
			}
		}
		return result;
	}
}