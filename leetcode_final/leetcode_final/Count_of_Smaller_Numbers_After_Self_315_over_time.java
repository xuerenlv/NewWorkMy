package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Xuehj on 16/7/8.
 */
public class Count_of_Smaller_Numbers_After_Self_315_over_time {
    public static void main(String[] a){
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(new Solution_Count_of_Smaller_Numbers_After_Self_315().countSmaller(nums).toString());
    }
}




class XTreeNode{
    int val;
    int count;
    XTreeNode left,right;
    XTreeNode(int valt){
        val = valt;
        count = 1;
        left=right=null;
    }
}

class BinSearchTree{
    XTreeNode root;

    BinSearchTree(int f_val){
        root = new XTreeNode(f_val);
    }

    void add(int val_t){
        add_t(val_t,root);
    }

    private void add_t(int val_t,XTreeNode pre){
        if(val_t>pre.val){
            if(pre.right==null)
                pre.right = new XTreeNode(val_t);
            else
                add_t(val_t,pre.right);
        }
        if(val_t<pre.val){
            if(pre.left==null)
                pre.left=new XTreeNode(val_t);
            else
                add_t(val_t,pre.left);
        }
        if(val_t==pre.val)
            pre.count++;
    }

    int count(int small){
        return count_small(small,root);
    }

    private int  count_small(int val,XTreeNode start){
        if(val>start.val){
            if(start.right==null){
                return start.count+ count_treeNode(start.left);
            }else{
                return start.count+ count_treeNode(start.left) + count_small(val,start.right);
            }

        }else if(val<start.val){
            if(start.left==null){
                return 0;
            }else {
                return count_small(val, start.left);
            }
        }else {
            return count_treeNode(start.left);
        }
    }

    private int count_treeNode(XTreeNode start){
        if(start==null)
            return 0;
        else
            return start.count+count_treeNode(start.left)+count_treeNode(start.right);
    }
}


class Solution_Count_of_Smaller_Numbers_After_Self_315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0)
            return res;
        res.add(0);
        BinSearchTree root = new BinSearchTree(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            res.add(0,root.count(nums[i]));
            root.add(nums[i]);
        }

        return res;
    }




    public List<Integer> countSmaller_others(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }
    private int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target) return end + 1;
        if (sorted.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }
}