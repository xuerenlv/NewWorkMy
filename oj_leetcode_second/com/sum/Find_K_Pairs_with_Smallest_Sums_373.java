/**
 * 
 */
package com.sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuehj
 *
 */
public class Find_K_Pairs_with_Smallest_Sums_373 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

class Solution_Find_K_Pairs_with_Smallest_Sums_373 {
	
	// 6666
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return ret;
		}

		int[] index = new int[nums1.length];
		while (k-- > 0) {
			int min_val = Integer.MAX_VALUE;
			int in = -1;
			for (int i = 0; i < nums1.length; i++) {
				if (index[i] >= nums2.length) {
					continue;
				}
				if (nums1[i] + nums2[index[i]] < min_val) {
					min_val = nums1[i] + nums2[index[i]];
					in = i;
				}
			}
			if (in == -1) {
				break;
			}
			int[] temp = { nums1[in], nums2[index[in]] };
			ret.add(temp);
			index[in]++;
		}
		return ret;
	}

}