package leetcode_final;

/**
 * Created by Xuehj on 16/6/30.
 */
public class Range_Sum_Query_Mutable_307 {
    public static void main(String[] a){
        int[] nums = {1,3,5};

        NumArray2 numArray2 = new NumArray2(nums);
        System.out.println(numArray2.sumRange(0,2));
        numArray2.update(1,2);
        System.out.println(numArray2.sumRange(0,2));
    }
}


// 超时 说明有更好的方法
class NumArray2 {
    int[] start_to_cur;
    int[] copy_nums;

    public NumArray2(int[] nums) {
        start_to_cur = new int[nums.length+1];
        copy_nums = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            start_to_cur[i] = sum;
            sum+= nums[i];
            copy_nums[i]=nums[i];
        }
        start_to_cur[nums.length] = sum;
    }

    void update(int i, int val) {
        int diff = copy_nums[i]-val;
        copy_nums[i] = val;

        for(int j=i;j<start_to_cur.length;j++)
            start_to_cur[j] -= diff;
    }

    public int sumRange(int i, int j) {
        return start_to_cur[j+1]-start_to_cur[i];
    }
}


// 使用的是: 线段树 ,
class NumArray_segment {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray_segment(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start]; // 叶节点赋值
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}