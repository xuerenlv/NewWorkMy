package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Xuehj on 16/7/14.
 */
public class Intersection_of_Two_Arrays_II_350 {
    public static void main(String[] a){
        int[] nums1={2,2};
        int[] nums2={1,2,2,1};
        new Solution_Intersection_of_Two_Arrays_II_350().intersect(nums1,nums2);
    }
}




class Solution_Intersection_of_Two_Arrays_II_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[0];
        if(nums1.length==0 || nums2.length==0)
            return res;

        if(nums1.length>nums2.length)
            return intersect(nums2,nums1);

        ArrayList res_li = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pre_count = 0;
        for(int i=0;i<nums1.length;i++){
            if(i>0 && nums1[i]==nums1[i-1]){
                if(pre_count!=0){
                    res_li.add(nums1[i]);
                    pre_count--;
                }
                continue;
            }

            int find_num = bin_find(nums2,nums1[i]);
            if(find_num != 0) {
                res_li.add(nums1[i]);
                find_num--;
                pre_count = find_num;
            }else {
                pre_count = 0;
            }

        }

        res = new int[res_li.size()];
        for(int i=0;i<res_li.size();i++){
            res[i]=(int)res_li.get(i);
        }

        return res;

    }

    int bin_find(int[] nums,int val){
        int start = 0,end = nums.length-1;
        while (start<=end){
            int mid = start + ((end-start)>>1);
            if(nums[mid]==val){
                int re = 1,mid_l=mid-1,mid_r=mid+1;
                while (mid_l>=0 && nums[mid_l]==val){
                    mid_l--;
                    re++;
                }
                while (mid_r<nums.length && nums[mid_r]==val){
                    mid_r++;
                    re++;
                }
                return re;
            }

            if(nums[mid]>val){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return 0;
    }

}