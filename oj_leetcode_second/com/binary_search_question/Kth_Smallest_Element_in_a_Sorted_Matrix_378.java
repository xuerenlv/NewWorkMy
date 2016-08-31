package com.binary_search_question;

import java.util.Arrays;

public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2 }, { 1, 3 } };
		int k = 3;

		System.out.println(new Solution_Kth_Smallest_Element_in_a_Sorted_Matrix_378().kthSmallest(matrix, k));
	}

}

class Solution_Kth_Smallest_Element_in_a_Sorted_Matrix_378 {

	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		if (m == 0 || k == 0)
			return 0;
		int n = matrix[0].length;

		DeterminedPriorityContainer de = new DeterminedPriorityContainer(k);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				de.add(matrix[i][j]);
				System.out.println(de.to_string());
			}
		}

		return de.get_last_one();
	}

	public int kthSmallest_cuo(int[][] matrix, int k) {
		int m = matrix.length;
		if (m == 0 || k == 0)
			return 0;
		int n = matrix[0].length;

		return matrix[(k - 1) / n][k % n];
	}

}

class DeterminedPriorityContainer {
	int con[];
	int add_index;
	int size;

	public DeterminedPriorityContainer(int de_size) {
		con = new int[de_size];
		add_index = 0;
		size = de_size;
	}

	// 假设 加入的 元素 是有序的
	public void add(int e) {
		if (add_index < size) {
			con[add_index++] = e;
			if(add_index==size){
				Arrays.sort(con);
			}
		} else {
			if (e < con[size - 1]) {
				int insert_index = size - 1;
				while (insert_index > 0 && e < con[insert_index - 1]) {
					con[insert_index] = con[insert_index - 1];
					insert_index--;
				}
				con[insert_index] = e;
			}
		}
	}

	int get_last_one() {
		return con[size - 1];
	}

	String to_string() {
		return Arrays.toString(con);
	}
}