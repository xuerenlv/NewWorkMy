/**
 * 
 */
package com.worksapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Xuehj
 *
 */
public class Main_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
		int[] arr = new int[n];
		int all_xor = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			all_xor ^= arr[i];
		}

		Tree tree = new Tree();
		tree.add(0);
		int left_xor = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			left_xor ^= arr[i];
			all_xor ^= arr[i];
			tree.add(left_xor);
			ans = Math.max(ans, all_xor ^ tree.find(all_xor));
		}

		out.println(ans);
		out.close();
	}

	// read data
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}

}

// implement one prefix tree
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