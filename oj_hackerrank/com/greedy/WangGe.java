package com.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class WangGe {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testcase = in.nextInt();
		while (testcase > 0) {
			int n = in.nextInt();
			char container[][] = new char[n][n];
			for (int i = 0; i < n; i++) {
				char[] l = in.next().toCharArray();
				Arrays.sort(l);
				for (int j = 0; j < n; j++)
					container[i][j] = l[j];

			}

			boolean is_f = false;
			for (int j = 0; j < n; j++) {
				for (int i = 1; i < n; i++) {
					if (container[i][j] < container[i - 1][j])
						is_f = true;
				}
				if (is_f)
					break;
			}

			if (is_f) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

			testcase--;
		}

		in.close();
	}

}
