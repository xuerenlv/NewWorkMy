package First_book_program;

import java.util.ArrayList;
import java.util.Scanner;

public class code_huawei {

	static int[][] dij = { { 0, 2, 10, 5, 3, -1 }, { -1, 0, 12, -1, -1, 10 }, { -1, -1, 0, -1, 7, -1 },
			{ 2, -1, -1, 0, 2, -1 }, { 4, -1, -1, 1, 0, -1 }, { 3, -1, 1, -1, 2, 0 } };

	static int min_sum = Integer.MAX_VALUE;
	static ArrayList<Integer> min_path = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s = in.nextInt();
		int w = in.nextInt();

		if (w != 0) {
			for (int i = 0; i < 6; i++) {
				dij[i][w - 1] = -1;
				dij[w - 1][i] = -1;
			}
		}

		ArrayList<Integer> path = new ArrayList<>();
		trans(5 - 1, s - 1, 0, path);

		if (min_sum == Integer.MAX_VALUE) {
			System.out.println(1000);
		} else {
			System.out.println(min_sum);

		}
		System.out.println(min_path.toString());
		in.close();
	}

	static void trans(int start, int end, int cur_sum, ArrayList<Integer> cur_path) {
		if (start == end && cur_sum < min_sum) {
			min_sum = cur_sum;
			min_path = new ArrayList<>(cur_path);
			min_path.add(start + 1);
			return;
		}

		cur_path.add(start + 1);
		for (int i = 0; i < 6; i++) {
			// System.out.println(start + " " + i);
			if (dij[start][i] != -1 && i != start && !cur_path.contains((Integer) i + 1)) {
				trans(i, end, cur_sum + dij[start][i], cur_path);
			}
		}
		cur_path.remove((Integer) (start + 1));
	}

}
/*
 * 
 * 
 * 
 */