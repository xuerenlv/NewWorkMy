package com.worksapp;

import java.util.Scanner;

public class Main_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] arr = new int[n];
		int all_xor = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			all_xor ^= arr[i];
		}

		Tree tree = new Tree();
		tree.add(0);// 先加 0 ，是因为可以是空集合。
		int left_xor = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			left_xor ^= arr[i];
			all_xor ^= arr[i];
			tree.add(left_xor); // 每次都把前缀的异或值加入到字典树中，然后查找后缀的最大异或值
			ans = Math.max(ans, all_xor ^ tree.find(all_xor));
		}

		System.out.println(ans);
	}
}

// implement one prefix tree， 在一组数中找一个数的最大异或值
class TreeNode {
	TreeNode zero, one;
}

class Tree {
	TreeNode root;

	Tree() {
		root = new TreeNode();
	}

	void add(int x) {
		TreeNode p = root;
		for (int i = 30; i >= 0; i--) {
			if (((x >> i) & 1) == 1) {
				if (p.one == null)
					p.one = new TreeNode();
				p = p.one;
			} else {
				if (p.zero == null)
					p.zero = new TreeNode();
				p = p.zero;
			}
		}
	}

	// in tree find one num, make it xor with x ,to be the largest
	int find(int x) {
		int res = 0;
		TreeNode p = root;
		for (int i = 30; i >= 0; i--) {
			int count = 0;
			if (((x >> i) & 1) == 1) {
				if (p.zero != null) {
					count = 0;
					p = p.zero;
				} else {
					count = 1;
					p = p.one;
				}
			} else {
				if (p.one != null) {
					count = 1;
					p = p.one;
				} else {
					count = 0;
					p = p.zero;
				}
			}
			res = 2 * res + count;
		}

		return res;
	}
}