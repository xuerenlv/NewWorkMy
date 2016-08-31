package leetcode_final;

/**
 * Created by Xuehj on 16/7/10.
 */
public class Patching_Array_330 {
    public static void main(String[] a){

    }
}




class Solution_Patching_Array_330 {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0,i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss+1;
                added++;
            }
        }
        return added;
    }
}