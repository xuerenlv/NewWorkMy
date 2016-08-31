package com.micro_soft;

import java.util.ArrayList;
import java.util.Scanner;

public class Tower_Defense_Game_109 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();

			TowerTreeNode container[] = new TowerTreeNode[n + 1];
			for (int i = 0; i < n; i++) {
				int p = in.nextInt(), q = in.nextInt();
				container[i + 1] = new TowerTreeNode(p, q);
			}

			for (int i = 0; i < n - 1; i++) {
				int p = in.nextInt(), q = in.nextInt();
				container[p].child_list.add(q);
			}

			ArrayList<Integer> reached = new ArrayList<>();
			reached.addAll(container[1].child_list);

			int this_in_val = container[1].in_val;
			int now_val = container[1].out_val;
			int re[] = { Integer.MAX_VALUE };
			
			bfSearch(container, reached, this_in_val, now_val, re);
			
			System.out.println(re[0]);
		}
		in.close();
	}

	static void bfSearch(TowerTreeNode container[], ArrayList<Integer> reached, int this_in_val, int now_val,
			int[] re) {

		if (reached.size() == 0) {
			if (this_in_val < re[0])
				re[0] = this_in_val;
			return;
		}

		ArrayList<Integer> old_reached = new ArrayList<>(reached);
		for (int i = 0; i < old_reached.size(); i++) {
			Integer it = old_reached.get(i);
			reached.remove(it);

			int new_this_in_val, new_now_val;
			if (now_val < container[it].in_val) {
				new_this_in_val = this_in_val + container[it].in_val - now_val;
				new_now_val = container[it].out_val;
			} else {
				new_this_in_val = this_in_val;
				new_now_val = container[it].out_val - container[it].in_val + now_val;
			}

			bfSearch(container, reached, new_this_in_val, new_now_val, re);

			reached.add(it);
		}

	}

}

class TowerTreeNode {
	int in_val, out_val;
	ArrayList<Integer> child_list;

	public TowerTreeNode(int in_val, int out_val) {
		super();
		this.in_val = in_val;
		this.out_val = out_val;
		this.child_list = new ArrayList<>();
	}

}