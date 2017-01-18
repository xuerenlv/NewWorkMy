package com.worksapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Xue hongjian
 *
 */
public class Magic_Cube {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m, n, p;
		int magic_cube[][][];
		ArrayList<int[][][]> small_cubes;
		while (in.hasNext()) {
			m = in.nextInt();
			n = in.nextInt();
			p = in.nextInt();

			// 初始化 大cube
			magic_cube = new int[m][m][m];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < m; k++) {
						magic_cube[i][j][k] = in.nextInt() % p;
					}
				}
			}

			// 读取 小cube
			small_cubes = new ArrayList<>();
			for (int t = 0; t < n; t++) {
				int len = in.nextInt();
				int small_cube[][][] = new int[len][len][len];
				for (int i = 0; i < len; i++) {
					for (int j = 0; j < len; j++) {
						for (int k = 0; k < len; k++) {
							magic_cube[i][j][k] = in.nextInt() % p;
						}
					}
				}
				small_cubes.add(small_cube);
			}

			// 对于 大cube 的每一个位置
			int rem_res[] = new int[n + 1]; // 纪录存放位置
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < m; k++) {

						// 对于每一个 小cube
						int rem_index = -1;
						int rem_size = 0;
						int rem_len = 0;

						// 寻找可以填充当前位置的 小cube ，当有多个 小cube 可以的时候，选择： 1，谁消灭的数字多，
						// 2，谁更大
						for (int t = 0; t < n && small_cubes.get(t).length != 0; t++) {
							int[][][] small_cube = small_cubes.get(t);
							int len = small_cube.length;
							int res_l = can_load_here(magic_cube, m, small_cube, len, i, j, k, p);
							if (res_l >= 0) {
								if (res_l > rem_size || (res_l == rem_size && len > rem_len)) {
									rem_index = t;
									rem_size = res_l;
									rem_len = len;
								}
							}
						}
						if (rem_index != -1) {
							rem_res[rem_index] = i * 100 + j * 10 + k; // 保存位置
							small_cubes.set(rem_index, new int[0][0][0]); // 对
																			// 小cube
																			// 清空
						}

					}
				}
			}

			// 输出结果
			for (int t = 0; t < n; t++) {
				System.out.println((rem_res[t] / 100) + " " + (rem_res[t] / 10) % 10 + " " + rem_res[t] % 10);
			}

		}

		in.close();
	}

	// 小cube 是否可以放在 当前的 i,j,k 位置
	// 返回： -1:不可以放； 0: 可以放，消灭掉 大cube 中的 0 个数字； 1-xx:可以放，消灭掉大立方体中 xx 个数
	static int can_load_here(int magic_cube[][][], int m, int small_cube[][][], int len, int s_i, int s_j, int s_k,
			int p) {
		int res = 0; // 纪录消灭的数字的个数
		if (s_i + len >= m || s_j + len >= m || s_k + len >= m) // 超出边界，肯定不可以
			return -1;

		for (int i = s_i; i < s_i + len; i++) {
			for (int j = s_j; j < s_j + len; j++) {
				for (int k = s_k; k < s_k + len; k++) {
					if (((magic_cube[i][j][k] + small_cube[i - s_i][j - s_j][k - s_k]) % p) == 0) {
						if (magic_cube[i][j][k] != 0) {
							res++;
						}
					} else {
						return -1;
					}
				}
			}
		}
		return res;
	}

}
