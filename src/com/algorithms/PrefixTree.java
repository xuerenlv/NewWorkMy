package com.algorithms;

public class PrefixTree {

	public static void main(String[] args) {
		PrefixTreeSolution pre = new PrefixTreeSolution();
		pre.add("aa");
		pre.add("ab");
		System.out.println(pre.search("b"));
	}

}

class TreeNode {
	int count;
	TreeNode children[];

	public TreeNode() {
		count = 0;
		children = new TreeNode[26];
	}
}

class PrefixTreeSolution {
	TreeNode root;

	public PrefixTreeSolution() {
		root = new TreeNode();
	}

	public void add(String str) {
		TreeNode cur = root;
		for(int i=0;i<str.length();i++){
			int index = str.charAt(i)-'a';
			if(cur.children[index]==null){
				cur.children[index] = new TreeNode();
			}
			cur.count++;
			cur = cur.children[index];
		}
		cur.count++;
	}
	
	public int search(String str){
		TreeNode cur = root;
		for(int i=0;i<str.length();i++){
			int index = str.charAt(i)-'a';
			if(cur.children[index]==null){
				return 0;
			}
			cur = cur.children[index];
		}
		return cur.count;
	}
}