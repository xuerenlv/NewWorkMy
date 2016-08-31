package leetcode_final;

/**
 * Created by Xuehj on 16/6/30.
 */
public class Range_Sum_Query_Immutable_303 {
    public static void main(String[] a){
        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}


class NumArray {
    int[] start_to_cur;

    public NumArray(int[] nums) {
        start_to_cur = new int[nums.length+1];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            start_to_cur[i] = sum;
            sum+= nums[i];
        }
        start_to_cur[nums.length] = sum;
    }

    public int sumRange(int i, int j) {
        return start_to_cur[j+1]-start_to_cur[i];
    }
}