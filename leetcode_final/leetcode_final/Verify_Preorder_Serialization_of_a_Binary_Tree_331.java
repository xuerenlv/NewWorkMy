package leetcode_final;

import java.util.Stack;

/**
 * Created by Xuehj on 16/7/11.
 */
public class Verify_Preorder_Serialization_of_a_Binary_Tree_331 {
    public static void main(String[] a){

    }
}



class Solution_Verify_Preorder_Serialization_of_a_Binary_Tree_331 {

    public boolean isValidSerialization_other(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();

        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

    public boolean isValidSerialization(String preorder) {
        String nodes[] = preorder.split(",");

        int leaf_null = 1;
        for(int i=0;i<nodes.length;i++){
            leaf_null--;
            if(leaf_null<0)
                return false;
            if(!nodes[i].equals("#"))
                leaf_null += 2;
        }

        return leaf_null==0;
    }
}