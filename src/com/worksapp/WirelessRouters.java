package com.worksapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Xue hongjian
 *
 */
public class WirelessRouters {

	// 记忆已 遍历 的路径
	static HashMap<Integer, Integer> rem[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n, m, s, e;
		ArrayList<Integer> adj_list[];
		while (in.hasNext()) {
			n = in.nextInt();
			m = in.nextInt();

			rem = new HashMap[n + 1][m + 1]; // 初始记忆容器

			adj_list = new ArrayList[n + 1];
			int souyi[] = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				souyi[i] = in.nextInt();
				adj_list[i] = new ArrayList<>();
			}

			for (int i = 1; i < n; i++) {
				s = in.nextInt();
				e = in.nextInt();
				adj_list[s].add(e);
				adj_list[e].add(s);
			}
			int visited[] = new int[n + 1];

			System.out.println(solve(1, n, m, visited, souyi, adj_list));
		}

		in.close();

	}

	// 回溯法 搜索所有可能  带记忆
	static int solve(int start, int n, int k, int visited[], int souyi[], ArrayList<Integer> adj_list[]) {
		if (start > n || k == 0) {
			return 0;
		}

		int key_r = 0;
		int this_max_souyi = 0;
		if (rem[start][k] != null) {
			for (int i = start; i <= n; i++)
				key_r += i * visited[i];
			if (rem[start][k].containsKey(key_r)) {
				return rem[start][k].get(key_r);
			}
		} else {
			rem[start][k] = new HashMap<>();
		}

		// 不放在当前位置
		int this_max_souyi_1 = solve(start + 1, n, k, visited, souyi, adj_list);

		int sou = souyi[start];
		for (int j : adj_list[start]) {
			if (visited[j] == 0)
				sou += souyi[j];
			visited[j]++;
		}

		// 放在当前位置
		int this_max_souyi_2 = solve(start + 1, n, k - 1, visited, souyi, adj_list) + sou;

		for (int j : adj_list[start]) {
			visited[j]--;
		}

		this_max_souyi = Math.max(this_max_souyi_1, this_max_souyi_2);
		rem[start][k].put(key_r, this_max_souyi);
		return this_max_souyi;
	}

}
