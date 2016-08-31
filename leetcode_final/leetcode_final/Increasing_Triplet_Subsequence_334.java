package leetcode_final;

import java.util.ArrayList;

/**
 * Created by Xuehj on 16/7/12.
 */
public class Increasing_Triplet_Subsequence_334 {
    public static void main(String[] a){

    }
}


class Solution_Increasing_Triplet_Subsequence_334 {

    public boolean increasingTriplet(int[] nums) {
        ArrayList<Integer> con = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list_swap(con,nums[i]);
            if(con.size()==3)
                return true;
        }
        return false;
    }


    void list_swap(ArrayList<Integer> li,int small){
        int i=0;
        while (i<li.size()){
            if(small==li.get(i))
                return;
            if(small>li.get(i)){
                i++;
                continue;
            }else{
                li.set(i,small);
            }
        }
        li.add(small);
    }
}