package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Xuehj on 16/7/14.
 */
public class Intersection_of_Two_Arrays_349 {
    public static void main(String[] a){
        int[] nums1={1,2};
        int[] nums2={1,1};

        int[] reaa = new Solution_Intersection_of_Two_Arrays_349().intersection(nums1,nums2);
    }

}


class Solution_Intersection_of_Two_Arrays_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[0];
        if(nums1.length==0 || nums2.length==0)
            return res;

        if(nums1.length>nums2.length)
            return intersection(nums2,nums1);

        ArrayList res_li = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i=0;i<nums1.length;i++){
            if(i>0 && nums1[i]==nums1[i-1])
                continue;
            if(bin_find(nums2,nums1[i]))
                res_li.add(nums1[i]);
        }

        res = new int[res_li.size()];
        for(int i=0;i<res_li.size();i++){
            res[i]=(int)res_li.get(i);
        }

        return res;

    }

    boolean bin_find(int[] nums,int val){
        int start = 0,end = nums.length-1;
        while (start<=end){
//            System.out.println(start+"xx"+end);
            int mid = start + ((end-start)>>1);
            if(nums[mid]==val)
                return true;
            if(nums[mid]>val){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }


}