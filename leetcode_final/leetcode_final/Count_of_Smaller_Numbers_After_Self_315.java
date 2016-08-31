package leetcode_final;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuehj on 16/7/9.
 */
public class Count_of_Smaller_Numbers_After_Self_315 {
    public static void main(String[] a){
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(new Solution_Count_of_Smaller_Numbers_After_Self_315_new().countSmaller(nums).toString());
    }
}




class BinSearchTree_2{
    XTreeNode root;

    BinSearchTree_2(int f_val){
        root = new XTreeNode(f_val);
    }

//    void add(int val_t){
//        add_t(val_t,root);
//    }
//
//    private void add_t(int val_t,XTreeNode pre){
//        if(val_t>pre.val){
//            if(pre.right==null)
//                pre.right = new XTreeNode(val_t);
//            else
//                add_t(val_t,pre.right);
//        }
//        if(val_t<pre.val){
//            if(pre.left==null)
//                pre.left=new XTreeNode(val_t);
//            else
//                add_t(val_t,pre.left);
//        }
//        if(val_t==pre.val)
//            pre.count++;
//    }


    // 在 count 的时候连带 add 进去
    int count(int small){
        return count_small(small,root);
    }

    private int  count_small(int val,XTreeNode start){
        if(val>start.val){
            if(start.right==null){
                start.right = new XTreeNode(val);
                return start.count+ count_treeNode(start.left);
            }else{
                return start.count+ count_treeNode(start.left) + count_small(val,start.right);
            }

        }else if(val<start.val){
            if(start.left==null){
                start.left = new XTreeNode(val);
                return 0;
            }else {
                return count_small(val, start.left);
            }
        }else {
            start.count++;
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


class Solution_Count_of_Smaller_Numbers_After_Self_315_new {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0)
            return res;
        res.add(0);
        BinSearchTree_2 root = new BinSearchTree_2(nums[nums.length-1]);
        for(int i=nums.length-2;i>=0;i--){
            res.add(0,root.count(nums[i]));
//            root.add(nums[i]);
        }

        return res;
    }
}