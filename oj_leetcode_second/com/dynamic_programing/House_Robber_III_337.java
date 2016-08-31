package com.dynamic_programing;

public class House_Robber_III_337 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution_House_Robber_III_337 {
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    
    // 二叉树的后序遍历 (可以看出后序遍历很有效果)
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        // 0 表示抢这个位置，1 表示不抢
        res[0] = left[1] + right[1] + x.val;
        // 如果不抢当前位置，则子节点既可以抢，也可以不抢
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}