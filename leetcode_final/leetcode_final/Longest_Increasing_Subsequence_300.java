package leetcode_final;

import java.util.ArrayList;

/**
 * Created by Xuehj on 16/6/14.
 */
public class Longest_Increasing_Subsequence_300 {
    public static void main(String[] a){
        int[] nums = {1,7,3,5,9,4,8};

        System.out.println(new Solution_Longest_Increasing_Subsequence_300().lengthOfLIS(nums));
    }
}

class Solution_Longest_Increasing_Subsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
            return nums.length;

        ArrayList<Integer> con = new ArrayList<>();
        con.add(nums[0]);
        for(int i=1;i<nums.length;i++){
        	System.out.println(con.toString());
            if(nums[i]<=con.get(0)){
                con.set(0,nums[i]);
            }else if(nums[i]>=con.get(con.size()-1)){	
                con.add(nums[i]);
            }else{
                int j=0;
                for (;j<con.size();j++){
                    if(nums[i]<=con.get(j))
                        break;
                }
                con.set(j,nums[i]);
            }
        }

        return  con.size();
    }
}
