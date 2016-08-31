package leetcode_final;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Xuehj on 16/6/27.
 */
public class Serialize_and_Deserialize_Binary_Tree_297 {
    public static void main(String[] a){

        TreeNode p = new TreeNode(4);
        p.left=new TreeNode(5);
        p.left.left = new TreeNode(8);

        String str = new Codec().serialize(p);
        System.out.println(str);

        TreeNode x = new Codec().deserialize(str);

    }
}


/**
 * Definition for a binary tree node.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}


// 使用 层序遍历 序列化 二叉树,然后构建二叉树,但是超时了
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        if(root==null)
            return  res;
        Queue<TreeNode> qu_con = new LinkedList<>();
        qu_con.add(root);
        while (!qu_con.isEmpty()){
            int chen_size = qu_con.size();
            for(int i=0;i<chen_size;i++){
                TreeNode p = qu_con.poll();
                if(p==null){
                    res += "null ";
                }else{
                    res += p.val+" ";
                    qu_con.add(p.left);
                    qu_con.add(p.right);
                }
            }
//            res+="|";
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data.length()==0)
            return root;

        Queue<TreeNode> qu_con = new LinkedList<>();
        String[] datas = data.substring(0,data.length()-1).split(" ");
        root = new TreeNode(new Integer(datas[0]).intValue());
        qu_con.add(root);
        int i=1;
        while(i<datas.length){
            TreeNode p = qu_con.poll();
            if(p==null){
                continue;
            } else{
                if(!datas[i].equals("null")){
                    p.left = new TreeNode(new Integer(datas[i]).intValue());
                }
                i++;
                if(!datas[i].equals("null")){
                    p.right = new TreeNode(new Integer(datas[i]).intValue());
                }
                i++;
                qu_con.add(p.left);
                qu_con.add(p.right);
            }
        }
        return  root;
    }
}